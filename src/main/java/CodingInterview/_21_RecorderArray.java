package CodingInterview;

public class _21_RecorderArray {

    public static void recorder(int[] data) {
        if (data == null || data.length < 2)
            return;

        int left = 0;
        int right = data.length - 1;
        while (left < right) {
            while (left < right && !isEven(data[left])) {
                ++left;
            }
            while (left < right && isEven(data[right])) {
                --right;
            }
            if (left < right) {
                int temp = data[right];
                data[right] = data[left];
                data[left] = temp;
            }
        }

    }

    private static boolean isEven(int num) {
        return (num & 1) == 0;
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,7,7};
        recorder(data);
        for (int datum : data) {
            System.out.print(datum);
            System.out.print('\t');
        }
        System.out.println();
    }
}
