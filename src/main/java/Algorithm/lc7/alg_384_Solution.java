package Algorithm.lc7;

import java.util.Random;

//Shuffle a set  of numbers without duplicates.
//TODO : unsolved
public class alg_384_Solution {
    private static int[] nums;
    private int[] sffs;
    public alg_384_Solution(int[] nums){
        alg_384_Solution.nums = nums;
    }

    public int[] reset(){
        return nums;
    }

    public int[] shuffle(){
        Random rnd = new Random();
        for(int i : nums){
            sffs[i] = rnd.nextInt(nums.length);
        }
        return new int[]{-1};
    }
}
