package CodingInterview;

public class utils {

    public static boolean checkArray(int[] nums) {
        if (nums == null || nums.length < 2)
            return false;
        for (int num : nums) {
            if (num < 0)
                return false;
        }
        return true;
    }
}
