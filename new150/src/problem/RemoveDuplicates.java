package problem;

/**
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *  https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicates {
    public static int do_it(int[] nums){
        // 双指针法
        // f1是目标值，f2是游走值
        int f1 ,f2;
        int flag = nums[nums.length-1] ;
        f1 =0;
        f2 = 1;

        while (f2 <= nums.length-1){
            // 如果只有一个数直接返回数组大小
            if(flag == nums[f1]) return f1+1;
            // 向右找到和目标值不相等的数
            if(nums[f1] == nums[f2]){
                f2++;
            }else {
                // 如果后面的数和f1
                f1 ++;
                // 如果f2不是f1的后一个数则把f1后的一个数和f2交换

                if(f2 != f1){
                    swap(nums, f1, f2);
                    f2++;
                }


            }

        }

        return f1+1;
    }

    public static void swap(int[] nums, int l , int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        // 创建临时数组存放归并元素
        System.out.println(do_it(nums));

        for (int num : nums) {
            System.out.println(num);
        }
    }



}
