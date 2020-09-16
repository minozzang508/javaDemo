package Algorithm.lc7;

//https://leetcode.com/problems/maximum-subarray/
public class alg_053_MaximumSubarray {
    //Runtime: 6 ms, faster than 82.24% of Java online submissions for Maximum Subarray.
    //Memory Usage: 38.6 MB, less than 91.02% of Java online submissions for Maximum Subarray.
    public static int maxSubArray(int[] nums){
        int size = nums.length;

        int sumOfStart = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){

            sumOfStart += nums[i];
            if(sumOfStart <= nums[i]){
                sumOfStart = nums[i];
            }
            maxSum = Math.max(maxSum, sumOfStart);

        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] testCase = {-2,1,-3,4,-1,2,1,-5,4};
        int[] testCase2 = {-1,-2};
//        System.out.println(maxSubArray(testCase));
        System.out.println(maxSubArray(testCase));
    }
}
