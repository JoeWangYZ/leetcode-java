package string;

/**
 * Created by joe wang on 2017/3/14.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return 0;
        }
        int sizeWithoutDuplicate = 1;
        int mark = nums[0];
        int markIndex = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] != mark) {
                nums[markIndex ++] = nums[i];
                mark = nums[i];
                sizeWithoutDuplicate ++;
            }
        }
        return sizeWithoutDuplicate;
    }
}
