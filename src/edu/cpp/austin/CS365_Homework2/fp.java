package edu.cpp.austin.CS365_Homework2;

public class fp {
    public int add(int a, int b) {
        //put the number with smaller exponent in a (to make it easier for me)
        if (((a >> 23) & 255) > ((b >> 23) & 255)) {
            int temp = a;
            a = b;
            b = temp;
        }

        //split numbers into sign, exponent, and fraction
        int aS = (a >> 31) & 1;
        int aE = (a >> 23) & 255;
        int aF =  a & 0x7FFFFF;

        int bS = (b >> 31) & 1;
        int bE = (b >> 23) & 255;
        int bF =  b & 0x7FFFFF;

        //add back the 1 in front of the decimal point, (increment exponent?)
        //numbers are now in the form 0.x
        aF += 0x800000;
        bF += 0x800000;

        //shifts a to the right until exponents match
        aF = aF >> (bE - aE);
        aE = bE;

        //add the significands together
        int cF = aF + bF;

        //we need 8 leading zeroes for a properly normalized sum
        //(int is 32 bits; result should be 8 zeroes and a 1, followed by 23 bit mantissa)
        int shiftAmt = 8 - Integer.numberOfLeadingZeros(cF);

        //shift so that "hidden 1 bit" is in the correct place
        if (shiftAmt >= 0) {
            cF = cF >> shiftAmt;
        } else {
            cF = cF << Math.abs(shiftAmt);
        }

        //remove the hidden bit
        cF -= 0x800000;

        //set the add the shift amount to the exponent
        int cE = aE + shiftAmt;

        //fix! incorrect! TODO! assumes that sign doesn't change
        int cS = aS;

        //reassemble integer result
        int c = cF;
        c += cE << 23;
        c += cS << 31;

        return c;

    }

    public int mul(int a, int b) {

        return 0;
    }
}
