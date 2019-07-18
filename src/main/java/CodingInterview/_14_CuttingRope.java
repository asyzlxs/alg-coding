package CodingInterview;

public class _14_CuttingRope {

    public static int maxProductAfterCutting_solution1(int lenght) {
        if (lenght <= 1)
            return 0;
        else if (lenght == 2)
            return 1;
        else if (lenght == 3)
            return 2;

        int[] products = new int[lenght + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int i = 4; i <= lenght; ++i) {
            int max = 0;
            for (int j = 1; j <= i / 2; ++j) {
                int product = products[j] * products[i - j];
                max = Math.max(product, max);
            }
            products[i] = max;
        }

        return products[lenght];

    }


    public static int maxProductAfterCutting_solution2(int length) {
        if (length <= 1)
            return 0;
        else if (length == 2)
            return 1;
        else if (length == 3)
            return 2;

        int count3 = 0;
        while (length >= 3) {
            length -= 3;
            ++count3;
        }
        int count2 = 0;
        if (length == 1) {
            --count3;
            count2 += 2;
        } else if (length == 2) {
            ++count2;
        }
        int sum = 1;
        while (count3 >= 1) {
            sum *= 3;
            --count3;
        }
        while (count2 >= 1) {
            sum *= 2;
            --count2;
        }

        return sum;


    }

    public static void main(String[] args) {
        for(int i = 1; i< 10;++i){
            System.out.println(maxProductAfterCutting_solution1(i));
            System.out.println(maxProductAfterCutting_solution2(i));
        }

    }


}
