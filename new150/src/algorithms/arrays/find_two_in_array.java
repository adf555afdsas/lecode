package algorithms.arrays;

/**
 * 输入一个递增排序的数组和一个值k，
 * 请问如何在数组中找出两个和为k的数字并返回它们的下标？
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次
 */
public class find_two_in_array {
    public static String get_target(int [] ints, int target){
        int p1 = 0;
        int p2 = ints.length-1;
        for (int i = 0; i < ints.length; i++) {
            while (ints[p1] + ints[p2] != target){
                if (ints[p1] + ints[p2]  > target ){
                    p2 --;
                }else {
                    p1++;
                }
            }

        }
        return ""+p1+"  "+p2;
    }
    public static void main(String[] args) {
        int [] nums = {1, 2, 4, 6, 10};
        System.out.println(get_target(nums,8));
    }
}
