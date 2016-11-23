/**
 * Created by Mariia_Lavrova on 11/23/2016.
 */


public class Warmup2 {

    public static String stringTimes(String str, int n) {

        String finalStr = "";

        while (n > 0) {
            finalStr += str;
            n--;
        }

        return finalStr;
    }


    public static String frontTimes(String str, int n) {

        String finalStr = "";
        String subStr = "";

        if (str.length() < 3) {
            subStr = str;
        } else {
            subStr = str.substring(0, 3);
        }

        for (; n > 0; n--) {
            finalStr += subStr;
        }

        return finalStr;
    }

    public static int countXX(String str) {

        int amountX = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals("xx")) {
                amountX++;
            }
        }

        return amountX;
    }

    public static boolean doubleX(String str) {

        char x = 'x';

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == x) {
                if (str.charAt(i + 1) == x) {
                    return true;
                }
                break;
            }
        }

        return false;
    }


    public static String stringSplosion(String str) {

        String finalStr = "";

        for (int i = 0; i <= str.length(); i++) {
            finalStr += str.substring(0, i);
        }

        return finalStr;
    }



    public static int last2(String str) {

        int amountLastTwo = 0;

        if (str.length() > 2) {

            String lastTwo = str.substring(str.length() - 2);

            for (int i = 0; i <= str.length() - 3; i++) {
                if (str.substring(i, i + 2).equals(lastTwo)) {
                    amountLastTwo++;
                }
            }
        }

        return amountLastTwo;
    }


    public static boolean array123(int[] nums) {

        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3) {
                return true;
            }
        }

        return false;
    }


    public static String toString(int[] nums) {

        String str = "";

        for (int i = 0; i < nums.length; i++) {
            str += nums[i] + " ";
        }

        return str;
    }

    public static int stringMatch(String a, String b) {

        int minLength = a.length();
        int amountSubStrings = 0;

        if (b.length() < minLength) {
            minLength = b.length();
        }

        for (int i = 0; i < minLength - 1; i++) {
            if (a.substring(i, i + 2).equals(b.substring(i, i + 2))) {
                amountSubStrings++;
            }
        }

        return amountSubStrings;
    }

    public static String stringX(String str) {

        String x = "x";

        if (str.length() > 1) {
            String str2 = str.substring(1, str.length() - 1).replace(x, "");

            return str.charAt(0) + str2 + str.charAt(str.length() - 1);
        } else {
            return str;
        }
    }

    public static String stringYak(String str) {

        String regexYak = "y.k";

        return str.replaceAll(regexYak, "");
    }

}
