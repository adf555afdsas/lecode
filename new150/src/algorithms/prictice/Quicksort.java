package algorithms.prictice;

import static algorithms.sort.Myquicksort.swap;

/**
 * 双指针
 * 1.将数组的最左边的数作为基准key
 * 2.先从右往左找到第一个小于key下标对应值的下标，再从左往右找到第一个大于key下标对应的值的下标
 * 3.交换这两个数
 * 重复2，3直到左右两边指针值相等，交换右指针与key的值，此时key的左边比key小，右边比key大
 * 重复将[0-key-1],[key+1 -end] 执行1，2，3直到数组中只有一个数。
 */
public class Quicksort {
    int a = 0;
    public static void sort(int[] nums, int left, int right){
        int key=left;
        int l = left;
        int r = right;
        if(l >= r) return;
        while (l < r) {
            while (r>l && nums[r] >= nums[key]) r--;
            while (l < r && nums[l] <= nums[key]) l++;
            swap(nums, r, l);
        }
        swap(nums, r, key);
        sort(nums,left, r-1);
        sort(nums,r+1, right);
    }

    public static void main(String[] args) {
        int []nums = {4,3,2,1,5,9,3,2,2,2};
        sort(nums,0, nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
