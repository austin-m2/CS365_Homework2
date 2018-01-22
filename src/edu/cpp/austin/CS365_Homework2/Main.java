package edu.cpp.austin.CS365_Homework2;

public class Main {

    public static void main(String[] args) {
        fp fp = new fp();
        int a = 0x42c923d7; // 100.57
        int b = 0x3bf227d0; // 0.00739

        int v24_25 = 0x41C20000; //  24.25
        int v_1875 = 0xBE400000; // -0.1875
        int v5     = 0xC0A00000; // -5.0

	    int c = fp.add(v24_25, v24_25);
	    System.out.println(c);
    }
}
