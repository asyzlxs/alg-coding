package CodingInterview;

public class _17_Print1ToMaxOfNDigits {

    public static void print1ToMaxOfNDigits(int num) {
        if (num <= 0)
            return;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < num; ++i) {
            str.append(0);
        }
        while (increment(str)) {
            printNumber(str);
        }
    }

    private static boolean increment(StringBuilder str) {
        for (int i = str.length() - 1; i >= 0; --i) {
            if (str.charAt(i) < '9' && str.charAt(i) >= '0') {
                str.setCharAt(i, (char) (str.charAt(i) + 1));
                return true;
            } else if (str.charAt(i) == '9') {
                str.setCharAt(i, '0');
            } else {
                return false;
            }
        }
        return false;
    }

    private static void printNumber(StringBuilder str) {
        if (str.length() <= 0)
            return;
        boolean flag = false;
        for (int i = 0; i < str.length(); ++i) {
            if (flag) {
                System.out.print(str.charAt(i));
            } else {
                if (str.charAt(i) != '0') {
                    System.out.print(str.charAt(i));
                    flag = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits(3);
    }
}
