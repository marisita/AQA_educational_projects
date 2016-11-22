/**
 * Created by Mariia_Lavrova on 11/22/2016.
 */
public class QA_Java_task_2 {
    public static void main(String[] args) {


        //1. stringTimes

        System.out.println("//1. stringTimes - Given a string and a non-negative int n, return a larger string that is n copies of the original string.");

        System.out.println("\"Hi\", 2: " + stringTimes("Hi", 2));
        System.out.println("\"Hi\", 3: " + stringTimes("Hi", 3));
        System.out.println("\"Hi\", 1: " + stringTimes("Hi", 1));

        System.out.println();


        //2. frontTimes

        System.out.println("//2. frontTimes - Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, " +
                "or whatever is there if the string is less than length 3. Return n copies of the front;");

        System.out.println("\"Chocolate\", 2: " + frontTimes("Chocolate", 2));
        System.out.println("\"Chocolate\", 3: " + frontTimes("Chocolate", 3));
        System.out.println("\"Abc\", 3: " + frontTimes("Abc", 3));

        System.out.println();


        //3. countXX

        System.out.println("//3. countXX - Count the number of \"xx\" in the given string. We'll say that overlapping is allowed, so \"xxx\" contains 2 \"xx\".");

        String[] dataCountXX = {"abcxx", "xxx", "xxxxc"};

        for (int i = 0; i < dataCountXX.length; i++) {
            System.out.println(dataCountXX[i] + ": " + countXX(dataCountXX[i]));
        }

        System.out.println();


        //4. doubleX

        System.out.println("//4. doubleX - Given a string, return true if the first instance of \"x\" in the string is immediately followed by another \"x\".");

        String[] dataDoubleX = {"axxbb", "axaxax", "xxxxx"};

        for (int i = 0; i < dataDoubleX.length; i++) {
            System.out.println(dataDoubleX[i] + ": " + doubleX(dataDoubleX[i]));
        }

        System.out.println();


        //5. stringSplosion

        System.out.println("//5. stringSplosion - Given a non-empty string like \"Code\" return a string like \"CCoCodCode\".");

        String[] dataStringSplosion = {"Code", "abc", "ab"};

        for (int i = 0; i < dataStringSplosion.length; i++) {
            System.out.println(dataStringSplosion[i] + ": " + stringSplosion(dataStringSplosion[i]));
        }

        System.out.println();


        //6. last2

        System.out.println("//6. last2 - Given a non-empty string like \"Code\" return a string like \"CCoCodCode\".");

        String[] dataLast2 = {"hixxhi", "xaxxaxaxx", "axxxaaxx"};

        for (int i = 0; i < dataLast2.length; i++) {
            System.out.println(dataLast2[i] + ": " + last2(dataLast2[i]));
        }

        System.out.println();


        //7. array123

        System.out.println("//7. array123 - Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.");

        int[][] dataArray123 = {{1, 1, 2, 3, 1}, {1, 1, 2, 4, 1}, {1, 1, 2, 1, 2, 3}};

        for (int i = 0; i < dataArray123.length; i++) {
            System.out.println(toString(dataArray123[i]) + ": " + array123(dataArray123[i]));
        }

        System.out.println();


        //8. stringMatch

        System.out.println("//8. stringMatch - Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring. " +
                "So \"xxcaazz\" and \"xxbaaz\" yields 3, since the \"xx\", \"aa\", and \"az\" substrings appear in the same place in both strings..");

        String[][] dataStringMatch = {{"xxcaazz", "xxbaaz"}, {"abc", "abc"}, {"abc", "axc"}};

        for (int i = 0; i < dataStringMatch.length; i++) {
            System.out.println(dataStringMatch[i][0] + ", " + dataStringMatch[i][1] + ": " + stringMatch(dataStringMatch[i][0], dataStringMatch[i][1]));
        }

        System.out.println();


        //9. stringX

        System.out.println("//9. stringX - Given a string, return a version where all the \"x\" have been removed. Except an \"x\" at the very start or end should not be removed.");

        String[] dataStringX = {"xxHxix", "abxxxcd", "xabxxxcdx"};

        for (int i = 0; i < dataStringX.length; i++) {
            System.out.println(dataStringX[i] + ": " + stringX(dataStringX[i]));
        }

        System.out.println();


        //10. stringYak

        System.out.println("//10. stringYak - Given a string, return a version where all the \"x\" have been removed. Except an \"x\" at the very start or end should not be removed.");

        String[] dataStringYak = {"yakpak", "pakyak", "yak123ya", "yik123ya"};

        for (int i = 0; i < dataStringYak.length; i++) {
            System.out.println(dataStringYak[i] + ": " + stringYak(dataStringYak[i]));
        }

        System.out.println();

    }

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

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'x') {
                if (str.charAt(i + 1) == 'x') {
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

        if (str.length() > 1) {
            String str2 = str.substring(1, str.length() - 1).replace("x", "");

            return str.charAt(0) + str2 + str.charAt(str.length() - 1);
        } else {
            return str;
        }
    }

    public static String stringYak(String str) {
        return str.replaceAll("y.k", "");
    }

}
