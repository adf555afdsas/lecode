package algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：输入一个整数数组和一个整数k，
 * 请问数组中有多少个数字之和等于k的连续子数组？例如，输入数组[1，1，1]，k的值为2，有2个连续子数组之和等于2。
 */
public class Sub_array_sum {
    public static int doing(int[] ints, int target) {
        Map<Integer, Integer>sum_map = new HashMap<>();
        sum_map.put(0, 1);
        int count=0;
        int sum = 0;
        for (int anInt : ints) {
            sum +=anInt;
            // 如果减去目标值，在前面的累加和中能找到说明当前的累加和，减去之前的累加和之间的数之和为目标值；count+1;
            count+=sum_map.getOrDefault(sum-target, 0);
            sum_map.put(sum, sum_map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(doing(nums, 2));

    }
}
