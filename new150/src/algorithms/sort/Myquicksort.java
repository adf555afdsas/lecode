package algorithms.sort;

/**
 * 双指针法
 * 1.选取最左边的的数为key,
 * 2.先从右往左找第一个小于key对应值的数，从左往右找第一个大于key的数
 * 3.交换这两个数，直到这两个指针对应的下标相同
 * 4.交换key与end的值，此时key左边的比key小，key右边的比key大。
 * 5.key已经有序，按照1，2，3，4步骤排begin到key-1 key+1到end
 *
 * 边界值：if (begin>=end) return
 * 边界值解析：begin-end区间内如果begin右边的总是比begin对饮的值大，则不会发生替换（代码参考Quicksort）例：1，5，3
 * 此时从右往左找直到end=begin,key=end下一次排序begin到key-1就会出现数组下标异常。
 * 因为key=0（1，5，3）前面没有值也算是有序，所以只需要排key后面的区间（5，3）。
 *
 * 时间复杂度(n^2)  空间复杂度（nlogn）
 */
public class Myquicksort {
    public static void sort(int[] nums, int l , int r){
        int key=l;
        int begin=l;
        int end = r;
        if( begin >= end ) return;
        // 当end 不等于begin一直查找
        while (begin<end){
            // 从右往左找第一个小于key对应值的数
            while(begin<end && nums[end] >= nums[key]) end--;
            // 从左往右找第一个大于key的数
            while (begin<end && nums[begin]<=nums[key]) begin++;
            swap(nums, end, begin);
        }
        swap(nums, key, begin);
        sort(nums, l , begin-1);
        sort(nums, begin+1 , r);
    }

    public static void swap(int[] nums, int l , int r){
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
