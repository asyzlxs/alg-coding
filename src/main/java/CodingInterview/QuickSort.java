package CodingInterview;

public class QuickSort {

    public static void quickSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        quickSortCore(nums, 0, nums.length - 1);

    }


    public static void quickSortCore(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int i = quickSortPartition(nums, start, end);
        quickSortCore(nums, start, i - 1);
        quickSortCore(nums, i + 1, end);
    }

    public static int quickSortPartition(int[] nums, int start, int end) {
        int point = nums[start];
        int left = start;
        int right = end;


        while (left < right) {
            while (left < right && nums[right] >= point)
                --right;
            if (left < right)
                nums[left] = nums[right];
            while (left < right && nums[left] < point)
                ++left;
            if (left < right)
                nums[right] = nums[left];
        }

        nums[left] = point;
        return left;
    }

    public static void main(String[] args) {
        int[] data = {1,5,4,2,3};
        quickSort(data);
        System.out.print("数组快速排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }
}
