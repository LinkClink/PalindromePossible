import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {


    private static String PalValidate(String str) {

        String replaceStr;
        String replaceSymbol;
        StringBuilder badChars = new StringBuilder();

        int previousLength; /* Set first length */
        previousLength = str.length() + 1;

        replaceStr = str;

        while (!replaceStr.equals("")) {/* replace symbols and check count to detected single charters */

            replaceSymbol = String.valueOf(replaceStr.charAt(0));
            replaceStr = replaceStr.replaceAll(replaceSymbol, "");

            if ((previousLength - (replaceStr.length() + 1)) % 2 != 0) { /* Check single */
                badChars.append(replaceSymbol);
            }
            previousLength = replaceStr.length() + 1;
        }

        if (badChars.length() >= 4) return "not possible"; /* Check when single characters are many */
        else if (str.length() <= 4 && badChars.length() >= 1) return "not possible"; /* Check with minimum size 3 */

        else if (badChars.length() > 1) { /* Show 1-2 single charters to delete */
            StringBuilder notParseCh = new StringBuilder();
            for (int i = 0; i < badChars.length() - 1; i++) {
                notParseCh.append(badChars.charAt(i));
            }
            return  notParseCh.toString();
        }

        return str; /* When default (pal) */
    }


    public static void main(String[] args) {
        /* Tests */
        System.out.println(PalValidate("abjchba"));
        System.out.println(PalValidate("mmop"));
        System.out.println(PalValidate("kjjjhjjj"));
        System.out.println(PalValidate("abcba"));
        System.out.println(PalValidate("kkkkkkkkk"));
    }
}