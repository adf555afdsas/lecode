package algorithms.sort;

/**
 * 计数排序
 * 1.找到数组中最大的数a，并创建大小大小为a的数组
 * 2.将原数组中中元素出现的次数统计到临时数组中
 * 3.按照次数将原数组还原
 *
 * 边界值：临时数组大小需要是原数组最大值+1，因为最大值为9，定义大小为9的数组下标最大只能到8.
 */
public class Countsort {
    public static void sort(int[] nums){
        int max = 0;
        // 1.找到数组中最大的数a，并创建大小大小为a的数组
        for (int num : nums) {
            if (max<num) max=num;
        }
        int tmp[] = new int[max+1];

        // 2.将原数组中中元素出现的次数统计到临时数组中
        for (int i = 0; i < nums.length; i++) {
            tmp[nums[i]]++;
        }

        // 3.按照次数将原数组还原
        int j = 0;
        for (int i = 0; i < tmp.length; i++) {
            int k=tmp[i];
            while (k >0){
                nums[j++]=i;
                k--;
            }
        }

    }

    public static void main(String[] args) {
        int []nums = {4,3,2,1,5,9,3,2,2,2};
        sort(nums);
        for (int num : nums) {
            System.out.println(num);

        }

//        int[] nums2 = new int[5];
//        System.out.println(nums2[2]);
    }
}
