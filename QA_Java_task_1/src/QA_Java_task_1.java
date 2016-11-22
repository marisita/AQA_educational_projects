/**
 * Created by Mariia_Lavrova on 11/21/2016.
 */
public class QA_Java_task_1 {
    public static void main(String[] args) {


        //1. posNeg

        System.out.println("//1. posNeg - Given 2 int values, return true if one is negative and one is positive. " +
                "Except if the parameter \"negative\" is true, then return true only if both are negative.");
        System.out.println("'1, -2, false': " + posNeg(1, -2, false));
        System.out.println("'-1, 2, true': " + posNeg(-1, 2, true));
        System.out.println("'-1, -2, true': " + posNeg(-1, -2, true));
        System.out.println();


        //2. notString

        System.out.println("//2. notString - Given a string, return a new string where \"not \" has been added to the front. " +
                "However, if the string already begins with \"not\", return the string unchanged. Note: use .equals() to compare 2 strings..");

        String[] dataNotString = {"candy", "x", "not bad"};

        for (int i = 0; i < dataNotString.length; i++) {
            System.out.println(dataNotString[i] + ": " + notString(dataNotString[i]));
        }

        System.out.println();


        //3. front3

        System.out.println("//3. front3 - Given a string, we'll say that the front is the first 3 chars of the string. " +
                "If the string length is less than 3, the front is whatever is there. Return a new string which is 3 copies of the front.");

        String[] dataFront3 = {"Java", "Chocolate", "abc"};

        for (int i = 0; i < dataFront3.length; i++) {
            System.out.println(dataFront3[i] + ": " + notString(dataFront3[i]));
        }

        System.out.println();


        //4. startHi

        System.out.println("//4. startHi - Given a string, return true if the string starts with \"hi\" and false otherwise.");

        String[] dataStartHi = {"hi there", "hi", "hello hi"};

        for (int i = 0; i < dataStartHi.length; i++) {
            System.out.println(dataStartHi[i] + ": " + notString(dataStartHi[i]));
        }

        System.out.println();


        //5. in1020

        int[][] dataIn1020 = {{12, 99}, {21, 12}, {8, 99}};
        System.out.println("//5. in1020 - Given 2 int values, return true if either of them is in the range 10..20 inclusive.");

        for (int i = 0; i < dataIn1020.length; i++) {
            System.out.println(dataIn1020[i][0] + ", " + dataIn1020[i][1] + ": " + in1020(dataIn1020[i][0], dataIn1020[i][1]));
        }

        System.out.println();


        //6. mixStart

        String[] dataMixStart = {"mix snacks", "pix snacks", "piz snacks"};
        System.out.println("//6. mixStart - Return true if the given string begins with \"mix\", except the 'm' can be anything, so \"pix\", \"9ix\" .. all count.");

        for (int i = 0; i < dataMixStart.length; i++) {
            System.out.println(dataMixStart[i] + ": " + mixStart(dataMixStart[i]));
        }

        System.out.println();


        //7. startOz

        String[] dataStartOz = {"ozymandias", "bzoo", "oxx"};
        System.out.println("//7. startOz - Given a string, return a string made of the first 2 chars (if present), " +
                "however include first char only if it is 'o' and include the second only if it is 'z', so \"ozymandias\" yields \"oz\".");

        for (int i = 0; i < dataStartOz.length; i++) {
            System.out.println(dataStartOz[i] + ": " + startOz(dataStartOz[i]));
        }

        System.out.println();


        //8. intMax

        int[][] dataIntMax = {{1, 2, 3}, {1, 3, 2}, {3, 2, 1}};
        System.out.println("//8. Given three int values, a b c, return the largest.");

        for (int i = 0; i < dataIntMax.length; i++) {
            System.out.println(dataIntMax[i][0] + ", " + dataIntMax[i][1] + ", " + dataIntMax[i][2] + ": " + intMax(dataIntMax[i][0], dataIntMax[i][1], dataIntMax[i][2]));
        }

        System.out.println();


        // 9. stringE

        String[] dataStringE = {"Hello", "Heelle", "Heelele"};
        System.out.println("//9. Return true if the given string contains between 1 and 3 'e' chars.");

        for (int i = 0; i < dataStringE.length; i++) {
            System.out.println(dataStringE[i] + ": " + stringE(dataStringE[i]));
        }

        System.out.println();


        //10. everyNth

        System.out.println("//10. everyNth - Given a non-empty string and an int N, return the string made starting with char 0, and then every Nth char of the string.");
        System.out.println("'Miracle, 2': " + everyNth("Miracle", 2));
        System.out.println("'abcdefg, 2': " + everyNth("abcdefg", 2));
        System.out.println("'abcdefg, 3': " + everyNth("abcdefg", 3));
        System.out.println();

    }

    public static boolean posNeg(int a, int b, boolean negative) {
        if (negative) return (a < 0 && b < 0);
        else return ((a < 0 && b > 0) || (a > 0 && b < 0));
    }

    public static String notString(String str) {
        if (str.length() >= 3 && str.substring(0, 3).equals("not")) return str;
        else return "not " + str;
    }

    public static String front3(String str) {
        String sub = str;
        if (str.length() >= 3) {
            sub = str.substring(0, 3);
        }
        return sub + sub + sub;
    }

    public static boolean startHi(String str) {
        if (str.length() >= 2) {
            return str.substring(0, 2).equals("hi");
        } else {
            return false;
        }
    }

    public static boolean in1020(int a, int b) {
        return a >= 10 && a <= 20 || b >= 10 && b <= 20;
    }

    public static boolean mixStart(String str) {
        return str.length() >= 3 && str.substring(1, 3).equals("ix");
    }

    public static String startOz(String str) {
        String res = "";
        if (str.length() >= 1 && str.charAt(0) == 'o') res += 'o';
        if (str.length() >= 2 && str.charAt(1) == 'z') res += 'z';
        return res;
    }

    public static int intMax(int a, int b, int c) {
        if (a > b && a > c) return a;
        if (b > c && b > a) return b;
        return c;
    }

    public static boolean stringE(String str) {
        int amountE = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == 'e') amountE++;
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
