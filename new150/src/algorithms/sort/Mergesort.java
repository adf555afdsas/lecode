package algorithms.sort;

/**
 * 归并排序
 * 1.将数组从中间划分成两个
 * 2.将左边和右边的数组进行继续进行1步骤直到只剩一个数
 * 3.将左边和右边的数组进行归并，大的先放回小的后放到临时数组
 * 4.将临时数组中的数放回原数组
 * 4.重复1，2，3，4实现排序
 *
 * 递归结束标志：当数组划分只剩下一个数
 */
public class Mergesort {
    public static void sort(int[] nums, int l, int r, int[] tmp){

        //递归退出条件
        if(r == l) return;

        //查找中间值
        int mid = (l+r)/2;
        // 2.将左边和右边的数组进行继续进行1步骤
        sort(nums, l , mid, tmp);

        sort(nums,mid+1, r, tmp);

        // 3.将左边和右边的数组进行归并，大的先放回小的后放回
        merg(nums, l, mid, r, tmp);
    }


    public static void merg(int[] nums, int l, int mid, int r, int[] tmp){

        // 定义起始索引
        int tmp_i=l;
        int b1 = l;
        int b2 = mid+1;
        while(b1<=mid && b2<=r){
            if(nums[b1] < nums[b2])
            {
                tmp[tmp_i++]=nums[b1++];
            }else {
                tmp[tmp_i++]=nums[b2++];
            }
        }
        // 检查左边数组是否遍历完
        while (b1<=mid) tmp[tmp_i++]=nums[b1++];
        // 检查右边数组是否遍历完
        while (b2<=r) tmp[tmp_i++]=nums[b2++];
        // 将排好序的数组写回到原数组
        for (int i = l; i <=r ; i++) {
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
