//997,287,242,841,684,785

package Algorithm.lc7;

import java.util.Arrays;

public class alg_287_FindTheDuplicateNumber {
    //You must not modify the array (assume the array is read only).
    //You must use only constant, O(1) extra space.
    //Your runtime complexity should be less than O(n2).
    //There is only one duplicate number in the array, but it could be repeated more than once.
    public static int findDuplicate(int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(Arrays.binarySearch(nums,i+1,nums.length - 1,nums[i]) > 0){
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] testcase = {1,3,4,2,1};
        System.out.println(findDuplicate(testcase));
    }
}
