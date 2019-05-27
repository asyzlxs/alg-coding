package CodingInterview;

public class _03_DuplicationInArray {

    public static int getDuplication(int[] nums) {
        if (nums == null || nums.length < 2)
            return -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < 0)
                return -1;
        }

        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != i) {
                int pos = nums[i];
                if (nums[i] == nums[pos])
                    return nums[i];
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(getDuplication(nums));

    }
}
