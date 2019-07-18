package CodingInterview;

public class _16_Power {

    static boolean invalidInput = false;

    public static double power(double base, int exponent) {
        // 底数为0没有数学意义，忽略也为1
        if (exponent == 0)
            return 1.0;
        if (exponent == 1)
            return base;

        if (exponent < 0) {
            if (equal(base, 0)) {
                invalidInput = true;
                return 0;
            }
            return 1 / powerWithUnsignedExponent(base, -exponent);
        }
        return powerWithUnsignedExponent(base, exponent);
    }

    private static boolean equal(double x, double y) {
        return -0.00001 < x - y && x - y < 0.00001;
    }

    private static double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1)
            result *= base;
        return result;
    }

    public static void main(String[] args) {
        System.out.println("2^3=" + power(2, 3) + "\t是否报错:" + invalidInput);
        System.out.println("2^-3=" + power(2, -3) + "\t是否报错:" + invalidInput);
        System.out.println("0^3=" + power(0, 3) + "\t是否报错:" + invalidInput);
        System.out.println("0^-3=" + power(0, -3) + "\t是否报错:" + invalidInput);
    }
}
