package edu.cpp.austin.CS365_Homework2;

public class Main {

    public static void main(String[] args) {
        fp fp = new fp();

        int v24_25 = 0x41C20000; //  24.25
        int v_1875 = 0xBE400000; // -0.1875
        int v5     = 0xC0A00000; // -5.0

//	    int sum = fp.add(Float.floatToIntBits(Float.MAX_VALUE), Float.floatToIntBits(10f));
//        System.out.println(sum);

        int product = fp.mul(Float.floatToIntBits(0f), Float.floatToIntBits(4.2f));
        System.out.println(Float.intBitsToFloat(product));
        //System.out.println(24.25f * 24.25f);






    }
}
