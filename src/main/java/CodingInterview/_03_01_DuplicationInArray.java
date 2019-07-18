package CodingInterview;


public class _03_01_DuplicationInArray {

    public static int getDuplication(int[] nums) {
        if (!utils.checkArray(nums))
            return -1;

        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]])
                    return nums[i];
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(getDuplication(nums));

    }
}
