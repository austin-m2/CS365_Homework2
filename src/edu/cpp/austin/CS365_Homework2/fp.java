package edu.cpp.austin.CS365_Homework2;

public class fp {
    public int add(int a, int b) {
        //put the number with smaller exponent in a
        if (((a >> 23) & 255) > ((b >> 23) & 255)) {
            int temp = a;
            a = b;
            b = temp;
        }

        int aS = (a >> 31) & 1;
        int aE = (a >> 23) & 255;
        int aF =  a & 0x7FFFFF;

        int bS = (b >> 31) & 1;
        int bE = (b >> 23) & 255;
        int bF =  b & 0x7FFFFF;

        //add back the 1 in front of the decimal point, shift to the right
        //numbers are now in the form 0.x
        aF += 0x800000;
        bF += 0x800000;
        aE += 1;
        bE += 1;

        //shifts a to the right until exponents match
        aF = aF >> (bE - aE);
        aE = bE;

        //add the numbers together
        int cF = aF + bF;
        int cE = aE;

        //normalize the sum
        int shiftAmt = Integer.numberOfLeadingZeros(cF) + 1;
        cF = cF << shiftAmt;
        cE -= shiftAmt;



        return 0;
    }

    public int mul(int a, int b) {

        return 0;
    }
}
