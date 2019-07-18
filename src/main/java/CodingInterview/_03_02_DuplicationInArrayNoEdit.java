package CodingInterview;

public class _03_02_DuplicationInArrayNoEdit {
    /**
     * 空间复杂度O(n), 时间复杂度O(n)
     */
    public static int getDuplication_01(int[] nums) {
        if (!utils.checkArray(nums))
            return -1;
        int[] tempArray = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            if (tempArray[nums[i]] == 0)
                tempArray[nums[i]] += 1;
            else
                return nums[i];
        }
        return -1;
    }

    /**
     * 空间复杂度O(1), 时间复杂度O(nlogn)
     */
    public static int getDuplication_02(int[] nums) {
        if (!utils.checkArray(nums))
            return -1;

        int begin = 1;
        int end = nums.length - 1;
        int middle = 0;
        int count = 0;
        while (begin <= end) {
            middle = begin + (end - begin) / 2;
            count = countRange(nums, begin, middle);
            if (begin == end) {
                if (count > 1)
                    return begin;
                break;
            }

            if (count > (middle - begin + 1))
                end = middle;
            else
                begin = middle + 1;

        }

        return -1;
    }

    private static int countRange(int[] nums, int left, int right) {
        int count = 0;
        for (int num : nums) {
            if (num >= left && num <= right)
                ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(getDuplication_01(nums));
        System.out.println(getDuplication_02(nums));
    }
}
