package algorithms.sort;

/**
 * 冒泡排序
 * 平均时间复杂度（n^2） 空间复杂度n(1) 稳定排序
 */
public class Bulblesort {
    public static void buble_sourt(int [] nums){
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i -1; j++) {
                if(nums[j] > nums[j+1]){
                    flag = false;
                    int tmp_num = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp_num;
                }
            }
            if (flag) break;
        }
    }
}
