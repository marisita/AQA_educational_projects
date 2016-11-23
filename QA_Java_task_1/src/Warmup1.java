/**
 * Created by Mariia_Lavrova on 11/23/2016.
 */

public class Warmup1 {

    public static boolean posNeg(int a, int b, boolean negative) {

        if (negative) {
            return (a < 0 && b < 0);
        } else {
            return ((a < 0 && b > 0) || (a > 0 && b < 0));
        }
    }


    public static String notString(String str) {

        String not = "not";

        if (str.length() >= 3 && str.substring(0, 3).equals(not)) {
            return str;
        } else {
            return not.concat(str);
        }
    }


    public static String front3(String str) {

        String sub = str;

        if (str.length() >= 3) {
            sub = str.substring(0, 3);
        }

        return sub.concat(sub).concat(sub);
    }


    public static boolean startHi(String str) {

        String hi = "hi";

        if (str.length() >= 2) {
            return str.substring(0, 2).equals(hi);
        } else {
            return false;
        }
    }


    public static boolean in1020(int a, int b) {

        return a >= 10 && a <= 20 || b >= 10 && b <= 20;
    }


    public static boolean mixStart(String str) {

        String ix = "ix";

        return str.length() >= 3 && str.substring(1, 3).equals(ix);
    }


    public static String startOz(String str) {

        String res = "";
        char o = 'o';
        char z = 'z';

        if (str.length() >= 1 && str.charAt(0) == o) {
            res += o;
        }

        if (str.length() >= 2 && str.charAt(1) == z) {
            res += z;
        }

        return res;
    }


    public static int intMax(int a, int b, int c) {

        if (a > b && a > c) {
            return a;
        }

        if (b > c && b > a) {
            return b;
        }

        return c;
    }


    public static boolean stringE(String str) {

        int amountE = 0;
        char e = 'e';

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == e) {
                amountE++;
            }
        }

        return amountE >= 1 && amountE <= 3;
    }


    public static String everyNth(String str, int n) {

        String finalStr = "";
        char[] charStr = str.toCharArray();

        for (int i = 0; i < str.length(); i += n) {
            finalStr += charStr[i];
        }

        return finalStr;
    }
}
