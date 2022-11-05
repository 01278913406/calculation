package org.chicha.synthesis;

import java.util.ArrayList;
import java.util.Arrays;

public class Auxs {
    public static final String eSub = "ₑ";
    public static final String opSub = "₍";
    public static final String cpSub = "₎";

    static final String[] superscripts = {"⁰", "¹", "²", "³", "⁴", "⁵", "⁶", "⁷", "⁸", "⁹"};
    static final String[] superLowerLetters = {"ᵃ", "ᵇ", "ᶜ", "ᵈ", "ᵉ", "ᶠ", "ᵍ", "ʰ", "ᶦ", "ʲ", "ᵏ", "ˡ", "ᵐ", "ⁿ", "ᵒ", "ᵖ", "ᑫ", "ʳ", "ˢ", "ᵗ", "ᵘ", "ᵛ", "ʷ", "ˣ", "ʸ", "ᶻ"};
    static final String[] superUpperLetters = {"ᴬ", "ᴮ", "ᶜ", "ᴰ", "ᴱ", "ᶠ", "ᴳ", "ᴴ", "ᴵ", "ᴶ", "ᴷ", "ᴸ", "ᴹ", "ᴺ", "ᴼ", "ᴾ", "Q", "ᴿ", "ˢ", "ᵀ", "ᵁ", "ⱽ", "ᵂ", "ˣ", "ʸ", "ᶻ"};
    static final String[] subscripts = {"₀", "₁", "₂", "₃", "₄", "₅", "₆", "₇", "₈", "₉"};

    public static final ArrayList<String> superlist = new ArrayList<>(Arrays.asList("⁰", "¹", "²", "³", "⁴", "⁵", "⁶", "⁷", "⁸", "⁹"));
    public static final ArrayList<String> sublist = new ArrayList<>(Arrays.asList("₀", "₁", "₂", "₃", "₄", "₅", "₆", "₇", "₈", "₉"));
    public static final ArrayList<String> superlistMisc = new ArrayList<>(Arrays.asList("ᵉ", "⁽", "⁾", "·"));
    public static final ArrayList<String> sublistMisc = new ArrayList<>(Arrays.asList(eSub, opSub, cpSub, ".", "₋"));
    public static final ArrayList<String> normalListMisc = new ArrayList<>(Arrays.asList("e", "(", ")", ".", "-"));

    static final String[] trigIn = {"sin", "cos", "tan", "csc", "sec", "cot", "sinh", "cosh", "tanh", "csch", "sech", "coth", "arcsin", "arccos", "arctan", "arccsc", "arcsec", "arccot", "arcsinh", "arccosh", "arctanh", "arccsch", "arcsech", "arccoth", "sin⁻¹", "cos⁻¹", "tan⁻¹", "csc⁻¹", "sec⁻¹", "cot⁻¹", "sinh⁻¹", "cosh⁻¹", "tanh⁻¹", "csch⁻¹", "sech⁻¹", "coth⁻¹"};
    static final ArrayList<String> trigList = new ArrayList<>(Arrays.asList("sin", "cos", "tan", "csc", "sec", "cot", "sinh", "cosh", "tanh", "csch", "sech", "coth", "arcsin", "arccos", "arctan", "arccsc", "arcsec", "arccot", "arcsinh", "arccosh", "arctanh", "arccsch", "arcsech", "arccoth", "sin⁻¹", "cos⁻¹", "tan⁻¹", "csc⁻¹", "sec⁻¹", "cot⁻¹", "sinh⁻¹", "cosh⁻¹", "tanh⁻¹", "csch⁻¹", "sech⁻¹", "coth⁻¹"));

    public static final String divi = "÷";
    public static final String multi = "×";
    public static final String pi = "π";
    public static final String sq = "√";
    public static final String bulletDot = "•";
    public static final String multiDot = "⋅";
    public static final String superDot = "‧";
    public static final String emDash = "—";
    public static final String superMinus = "⁻";

    public static final String piStr = superscripts[3] + superDot + superscripts[1] + superscripts[4] + superscripts[1] + superscripts[5] + superscripts[9];

    public static ArrayList<String> ops = new ArrayList<>(Arrays.asList("+", "-", multi, divi, sq, "^", "(", ")", "!", "%", bulletDot, multiDot, "*", "/", "log", "ln"));
    public static ArrayList<String> binaryOps = new ArrayList<String>(Arrays.asList("+", "-", "/", "*", multi, divi, "^", "%", Auxs.emDash, bulletDot, multiDot));

    //The method's name is a shortened version of "charAt." It's literally just a shortcut for writing "Character.toString(str.charAt(index))"
    public static String chat(String str, int index) {
        if (str == null || str.equals("\0"))
            return null;
        else if (index >= str.length() || index < 0)
            return null;

        try {
            str = Character.toString(str.charAt(index));
        }
        catch (Exception e){
            return null;
        }

        return str;
    }

    //A fancier version of the original chat function that gets a specified number of characters at the specified index, rather than just one
    public static String chat(int numChars, String str, int index) {
        if (numChars == 0)
            return null;
        if (numChars == 1)
            return chat(str, index);

        if (isNull(str))
            return null;
        if (!isNull(str) && (index >= str.length() || index < 0))
            return null;

        if (numChars > str.length() - index) {
            try {
                return str.substring(index);
            }
            catch (IndexOutOfBoundsException e){
                return null;
            }
        }
        else {
            try {
                return str.substring(index, index + numChars);
            }
            catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
    }

    public static boolean isOp(String str) {
        if (str == null || str.equals("\0"))
            return false;

        if (ops.contains(str))
            return true;

        return false;
    }

    public static boolean isBinaryOp(String str) {
        if (isNull(str))
            return false;

        return binaryOps.contains(str);
    }

    public static int charDiff(String str, String s1, String s2) {
        if (str == null || s1 == null || s2 == null || str.length() < 2 || s1.length() != 1 || s2.length() != 1)
            return 0;

        int count1 = 0, count2 = 0;

        for (int i=0; i < str.length(); i++) {
            char current = str.charAt(i);

            if (current == s1.charAt(0))
                count1++;
            else if (current == s2.charAt(0))
                count2++;
        }

        return count1 - count2;
    }

    public static boolean isDigit(char character) {
        return (int) character >= 48 && (int) character <= 57;
    }

    public static boolean isDigit(String str) {
        return !isNull(str) && str.length() == 1 && (int) str.charAt(0) >= 48 && (int) str.charAt(0) <= 57;
    }

    public static boolean isNum(String str) {
        if (isNull(str))
            return false;

        if (!isDigit(str)){
            if (str.equals("e") || str.equals("π")) {
                return true;
            }
        }

        return isDigit(str);
    }

    public static boolean isFullNum(String str) {
        int i, length;
        if (isNull(str))
            return false;

        length = str.length();

        if (length == 0)
            return false;

        if (length == 1) {
            if (isDigit(str))
                return true;
            if (str.equals("."))
                return false;
        }

        for (i=0; i < length; i++) {
            String current = chat(str, i);

            if (current == null || (!isDigit(current) && !(current.equals("e") || current.equals("π") || current.equals("."))))
                return false;
        }

        return countChars(str, ".") <= 1;
    }

    public static boolean isFullSignedNum(String str) {
        return str != null && !str.equals("\0") && !str.equals("") && (isFullNum(str.replace(",", "")) || (str.startsWith("-") && isFullNum(str.substring(1).replace(",", ""))));
    }

    public static boolean isFullSignedNumE(String str) {
        return str != null && !str.equals("\0") && !str.equals("") && (isFullSignedNum(str) || isFullSignedNum(str.replace("E-", "").replace("E", "")) || (str.startsWith("-") && isFullSignedNum(str.replace("E-", "").replace("E", ""))));
    }

    public static int countChars(String str, String input){
        if (isNull(str) || isNull(input) || input.length() < 1)
            return 0;

        int i;
        int numChars = 0;
        int length = str.length();
        int inputLength = input.length();

        try {
            for (i = 0; i < length; i += inputLength) {
                if (chat(inputLength, str, i).equals(input))
                    numChars++;
            }
        }
        catch (Exception ignored) {}

        return numChars;
    }

    public static String newTrim(String str, int numChars) {
        int s;

        if (isNull(str))
            return "";

        for (s=0; s < numChars; s++) {
            if (!str.equals("\0") && str.length() == 1)
                return "";

            if (!str.equals("\0") && str.length() > 1)
                str = str.substring(0, str.length() - 1);
        }

        return str;
    }

    public static String lastChar(String str) {
        return (!isNull(str) && str.length() > 1) ? str.substring(str.length() - 1) : str;
    }

    public static boolean isSuperscript(String str) {
        if (!isNull(str) && str.length() == 1) {
            if (superlist.contains(str))
                return true;
            if (str.equals("⋅") || str.equals(superDot))
                return true;
            if (str.equals("⁻"))
                return true;
            if (str.equals("ᵉ"))
                return true;
        }

        return false;
    }



    public static boolean isSubscript(String str) {
        if (str == null || str.equals("\0"))
            return false;

        if (str.length() == 1)
            return sublist.contains(str) || sublistMisc.contains(str);

        return false;
    }

    public static boolean isSubDigit(String str) {
        if (str == null || str.equals("\0"))
            return false;

        if (str.length() == 1)
            return sublist.contains(str);

        return false;
    }

    public static boolean isFullSubNum(String str) {
        int i;

        if (str == null || str.equals("\0"))
            return false;

        for (i=0; i < str.length(); i++) {
            if (!isSubscript(chat(str, i)))
                return false;
        }

        return true;
    }

    public static String subToNum(String str) {
        int i;
        StringBuilder output = new StringBuilder();

        if (str == null || str.equals("\0"))
            return null;

        for (i=0; i < str.length(); i++) {
            if (isSubDigit(chat(str, i)))
                output.append(Integer.toString(sublist.indexOf(chat(str, i))));
            else if (sublistMisc.contains(str))
                output.append(normalListMisc.get(sublistMisc.indexOf(str)));
            else
                return null;
        }

        final String s = output.toString();
        return s;
    }

    public static String numToSuper(String str) {
        int i;
        String output = "";

        if (str == null || str.equals("\0"))
            return null;

        for (i=0; i < str.length(); i++) {
            if (isDigit(chat(str, i)))
                output += superlist.get(Integer.parseInt(chat(str, i)));
            else if (normalListMisc.contains(str))
                output += superlistMisc.get(normalListMisc.indexOf(str));
            else
                return null;
        }

        return output;
    }

    public static String superToNum(String str) {
        int i;
        String output = "";

        if (str == null || str.equals("\0"))
            return null;

        for (i=0; i < str.length(); i++) {
            if (isSuperscript(chat(str, i)))
                output += Integer.toString(superlist.indexOf(chat(str, i)));
            else if (superlistMisc.contains(str))
                output += normalListMisc.get(superlistMisc.indexOf(str));
            else
                return null;
        }

        return output;
    }

    public static String getLast(String str, int numChars){
        int s;
        String result = lastChar(str);

        if (str == null || str.equals("\0"))
            return null;
        if (numChars >= str.length())
            return str;

        str = newTrim(str, 1);

        for (s=0; s < numChars - 1; s++) {
            if (!isNull(str)) {
                if (str.length() == 1)
                    return lastChar(str) + result;

                if (str.length() > 1)
                    result = lastChar(str) + result;

                if (str.length() > 0)
                    str = str.substring(0, str.length() - 1);
            }
        }

        return result;
    }

    public static boolean isNull(Object input){
        if (input == null)
            return true;

        if (input.getClass() == String.class) {
            String str = (String) input;

            return str.equals("\0") || str.equals("");
        }

        return false;
    }
}
