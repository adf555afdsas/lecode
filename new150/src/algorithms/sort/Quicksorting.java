package algorithms.sort;

/**
 * 1.选取key轴元素将数组（此处选取左边第一个为key）
 * 2.从key元素的右边第一个（l）向右找到大于key的值，从数组末尾(r)向左找第一个小于key的值
 * 3.交换这两个值
 * 4.循环第二步直到l=r,交换key和r对应的值
 * 5.递归调用1，2，3，4最终得到有序数组
 */

public class Quicksorting {
    public static void sort(int[]nums, int l, int r){
        int key = l;
        int begin = l;
        int end = r;
        if (begin >= end) return;
        while (begin < end) {
            // 从右往左找到第一个小于key的数
            while (begin < end && nums[end]>=nums[key]) end--;

            // 从左往右找第一个大于key数
            while (begin < end && nums[begin]<=nums[key]) begin++;
            swap(nums, begin, end);
        }
        swap(nums, key, end);
        key=end;
        sort(nums, l, key-1);
        sort(nums, key+1, r);
    }

    public static void swap(int[]nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    static int []nums = {4,3,2,1,5,9,3,2,2,2};

    public static void main(String[] args) {
        sort(nums,0, nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
