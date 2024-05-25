package algorithms.sort;

/**
 * 递归实现归并排序
 * 1.将数组从中间划分成两个子数组直到剩下一个数
 * 2.合并划分到最后的两个数，按从小到大的顺序把元素放入到临时数组，得到一个有序的临时数组，将临时数组的内容还原到原数组
 * 3.重复1，2步骤得到一个有序的原数组
 *
 */
public class Mymergesort {
    public static void sort(int[] nums, int l , int r , int[] tmp){
        // 直到剩下一个数
        if (l == r) return;
        // 1.将数组从中间划分成两个子数组直到剩下一个数
        int mid = (l + r)/2;
        sort(nums, l, mid, tmp);
        sort(nums, mid+1, r , tmp);
        merge(nums, l, mid , r , tmp);
    }

    // 2.合并划分到最后的两个数:按从小到大的顺序把元素放入到临时数组，得到一个有序的临时数组，将临时数组的内容还原到原数组
    private static void merge(int[] nums, int l, int mid, int r, int[] tmp) {
        int b1 = l;
        // tmp临时下标
        int tmp_i = l;
        int b2 = mid+1;

        while(b1<=mid && b2<=r){
            // 按从小到大的顺序把元素放入到临时数组
            if(nums[b1] < nums[b2]) tmp[tmp_i++] = nums[b1++];
            if(nums[b1] > nums[b2]) tmp[tmp_i++] = nums[b2++];

        }
        // 将剩余的数放入tmp
        while (b1<=mid) tmp[tmp_i++] = nums[b1++];
        while (b2<=r) tmp[tmp_i++] = nums[b2++];

        // 将tmp中的数覆盖回原数组
        for (int i = l; i <=r ;i++) {
            nums[i] = tmp[i];
        }

    }

    public static void main(String[] args) {
        int[] nums = {14,12,15,13,11,11,16};
        // 创建临时数组存放归并元素
        int[] tmp = new int[nums.length];
        sort(nums,0, nums.length-1, tmp);

        for (int num : nums) {
            System.out.println(num);
        }
    }

}
