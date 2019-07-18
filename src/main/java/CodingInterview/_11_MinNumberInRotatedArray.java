package CodingInterview;

public class _11_MinNumberInRotatedArray {

    public static int minNumberInRotatedArray(int[] data) {
        if (data == null || data.length <= 0)
            return -1;
        int left = 0;
        int right = data.length - 1;
        int middle = left;
        while (data[left] >= data[right]) {
            if (right - left <= 1)
                return data[middle];

            middle = left + (right - left) / 2;
            if (data[left] == data[middle] && data[right] == data[middle])
                return minInOrder(data, left, right);

            if (data[left] <= data[middle])
                left = middle;
            if (data[right] >= data[middle])
                right = middle;
        }
        return data[middle];
    }


    public static int minInOrder(int[] data, int left, int right) {
        int result = data[left];
        for (int i : data) {
            if (result > i)
                result = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data0 = {3,4,5,1,2};
        int[] data1 = {1,0,1,1,1};
        int[] data2 = {1,2,3,4,5};
        System.out.println(minNumberInRotatedArray(data0));
        System.out.println(minNumberInRotatedArray(data1));
        System.out.println(minNumberInRotatedArray(data2));

    }
}
