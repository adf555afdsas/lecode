package problem;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *
 */
public class Remove_element {
    public static int removeElement(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {

            if( nums[i] == val ){
            // 如果与目标值相等的这个位置后面没有值则直接将该位置的值变为0
                nums[i] = 111;
            }
        }
        int out =0;

        // 整理数组,0移到非0的后面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 111){
                for (int j = nums.length-1; j > 0; j--) {
                    if(i == j) break; //说明i下标后面已经没有非0的数了
                    if(nums[j] !=111){
                        nums[i] = nums[j];
                        nums[j] = 111;
                        break;
                    }
                }
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 111) return i;
            out = nums.length;
        }

        return out;
    }

//    public static int get_out(){
//        int left = 0, right = nums.size();
//        while (left < right) {
//            if (nums[right - 1] == val) {
//                right--;
//            } else if (nums[left] == val) {
//                nums[left] = nums[right - 1];
//                right--;
//            } else {
//                left++;
//            }
//        }
//        return left;
//    }


    public static void main(String[] args) {
            System.out.println(removeElement(new int[] {3,2,2,3}, 3));
    }


}
