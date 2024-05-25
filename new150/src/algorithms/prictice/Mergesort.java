package algorithms.prictice;

/**
 * 将数组从中点划分成两个数组，直到剩下一个数
 * 最后对这些数进行两两合并，小的先放到临时数组，大的后放；每次归并后将数放回数组，执行完该操作后每个组里的数是有序的。
 * 接着对组进行两两合并，小的先放到临时数组，大的后放，最后归并为一个有序数组。
 *
 */
public class Mergesort {
    public static void sort(int[]nums, int left, int right){
        if(left == right) return;
        int mid = (right+left)/2;
        sort(nums, left, mid);
        sort(nums, mid+1, right);
        merg(nums, left, mid, right);
    }

    private static void merg(int[] nums, int left, int mid, int right) {
        int[] tmp = new int [nums.length];
        int l_begin = left;
        int r = right;
        int t_begin=left;
        int r_begin = mid+1;
        while (l_begin<=mid && r_begin <=right){
            if(nums[l_begin] < nums[r_begin]){
                tmp[t_begin++] = nums[l_begin++];
            }else{
                tmp[t_begin++] = nums[r_begin++];
            }
        }
        // 将剩余的数放到临时数组
        while (l_begin<=mid) tmp[t_begin++] = nums[l_begin++];
        while (r_begin<=right) tmp[t_begin++] = nums[r_begin++];

        // 将临时数组放回原数组
        while (left<=right) nums[left] = tmp[left++];
    }

    public static void main(String[] args) {
        int[] nums = {14,12,15,13,11,11,16};
        sort(nums, 0, nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
