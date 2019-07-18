package CodingInterview;

public class _20_Numericstrings {

    public static boolean isNumeric(String str) {
        if (str == null)
            return false;
        int index = 0;
        if (str.charAt(0) != '.') {
            index = scanInteger(str, index);
            if (index == -1)
                return false;
            if (index == str.length())
                return true;
            if (str.charAt(index) == '.') {
                if (index == str.length() - 1)
                    return true;
                index = scanUnsignedInteget(str, index + 1);
                if (index == str.length())
                    return true;
            }
            if (str.charAt(index) == 'e' || str.charAt(index) == 'E') {
                index = scanInteger(str, index + 1);
                return index == str.length();
            } else
                return false;
        } else {
            index = scanUnsignedInteget(str, index + 1);
            if (index == str.length())
                return true;
            if (str.charAt(index) == 'e' || str.charAt(index) == 'E') {
                index = scanInteger(str, index + 1);
                if (index == str.length())
                    return true;
            } else
                return false;
        }


        return false;
    }


    public static int scanInteger(String str, int index) {
        if (index >= str.length())
            return -1;

        if (str.charAt(index) == '+' || str.charAt(index) == '-')
            return scanUnsignedInteget(str, index + 1);
        else
            return scanUnsignedInteget(str, index);
    }

    public static int scanUnsignedInteget(String str, int index) {
        int origin = index;
        while (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            ++index;
            if (index == str.length())
                return index;
        }

        if (origin == index)
            return -1;
        return index;
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("+100"));//true
        System.out.println(isNumeric("5e2")); //true
        System.out.println(isNumeric("-123"));//true
        System.out.println(isNumeric("3.1416"));//true
        System.out.println(isNumeric("-1E-16"));//true
        System.out.println(isNumeric(".6"));//true
        System.out.println(isNumeric("6."));//true
        System.out.println(isNumeric("12e"));//false
        System.out.println(isNumeric("1a3.14"));//false
        System.out.println(isNumeric("1.2.3"));//false
        System.out.println(isNumeric("+-5"));//false
        System.out.println(isNumeric("12e+5.4"));//false
    }


}
