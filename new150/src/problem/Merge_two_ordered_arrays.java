package problem;

import java.util.Arrays;
/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */

public class Merge_two_ordered_arrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // 将nums2的元素放到nums1中
        int tmp_num = m; // 存放m的值
        int tmp_i = 0;   // 冒泡排序的第三个参数
        for (int i = 0; i < nums2.length; i++) {
            nums1[tmp_num] = nums2[i];
            tmp_num++;
        }
        Arrays.sort(nums1);
        // 将nums1进行冒泡排序

    }

    public void buble_sourt(int[] nums){
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = false;
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
            if (flag) break;
        }
    }

}
