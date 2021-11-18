package com.lwm.chapter5;

/**
 * @author weeming
 * @date 2021/11/9 12:13
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        rotate(nums, k);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length <= 1 || k == nums.length) {
            return;
        }
        int cidx = 0, nidx = (cidx + k) % nums.length, temp1 = nums[cidx], temp2;
        while (0 != nidx) {
            temp2 = nums[nidx];
            nums[nidx] = temp1;
            temp1 = temp2;
            cidx = nidx;
            nidx = (cidx + k) % nums.length;
        }
        nums[nidx] = temp1;
    }

}
