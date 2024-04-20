import java.util.*;

public class FIndDuplicate {

    private static int findDuplicate(int[] nums)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!arr.contains(nums[i])){
                arr.add(nums[i]);
            }
            else{
                return nums[i];
            }
        }
        return 0;
    }
    private static int findDuplicate2(int[] nums) {
        int mid = (1 + (nums.length - 1)) / 2;
        int left = 0;
        int right = 0;
        for (int x : nums) {
            if (x > mid) {
            }
            return 0;
        }
        return 0;
    }

}
