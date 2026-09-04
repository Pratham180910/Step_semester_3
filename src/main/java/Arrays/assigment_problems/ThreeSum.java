package main.java.assigment_problems;

import java.util.*;

public class ThreeSum {
    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<int[]> list=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int left=i+1,right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    list.add(new int[]{nums[i],nums[left],nums[right]});
                    while(left<right&&nums[left]==nums[left+1]) left++;
                    while(left<right&&nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        int[][] result=threeSum(nums);
        for(int[] a:result) System.out.println(Arrays.toString(a));
    }
}