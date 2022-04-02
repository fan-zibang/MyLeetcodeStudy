package com.fanzibang.day01;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     *
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     *
     * 示例 2：
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     *
     * 示例 3：
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 方法一：通过暴力枚举的方法，枚举数组中的每一个元素x，当我们在遍历整个数组时，需要注意每一个在x之前的元素都已经和x匹配过，所以不需要再次匹配
     * 时间复杂度度：O(N^2)，最坏情况下数组中两个数都要匹配一次。
     */
    public int[] twoSum1(int[] nums, int target) {
        int sum;
        for (int i = 0;i < nums.length;i++) {
            for (int j = i + 1;j < nums.length;i++) {
                sum  = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }



    /**
     * 方法二：使用哈希表，遍历每一个x时，先查询哈希表里是否存在 target-x的key值，如果存在则返回两个值的value，如果不存在则将当前的值和值得下标存入map中，
     * 然后继续遍历直到找到为止。
     * 时间复杂度O(1)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

}
