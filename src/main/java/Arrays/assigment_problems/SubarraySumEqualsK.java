package main.java.assigment_problems;

import java.util.*;

public class SubarraySumEqualsK {
    static int subarraySum(int[] nums,int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0,count=0;
        for(int num:nums){
            sum+=num;
            count+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums={1,1,1};
        int k=2;
        System.out.println(subarraySum(nums,k));
    }
}