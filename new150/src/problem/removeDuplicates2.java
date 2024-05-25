package problem;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class removeDuplicates2 {
    public static int solution(int[] nums){
        // 双指针
        int p=0;
        int q=0;
        int flag = nums.length;
        int step=0;
        boolean checkout = check(nums);
        if(flag <=2)return flag;
        while (q < flag){
            if(nums[q] == nums[flag-1] && checkout) return q+2;
            if(nums[q] == nums[flag-1] && !checkout) return q+1;
            while (nums[p] == nums[q]) q++;
            if(p < q-2) {
                move(p+2,nums,q-p-2);
                step = q-p-2;
                p+=2;
                q=p;
            }else {
                p=q;
            }
        }
        return q+1;
    }

    // 检查数组中最大的数是否超过2
    public static boolean check(int[] ints){
        int i = ints[ints.length-1];
        int count =0;
        for (int anInt : ints) {
            if(anInt == i) count++;
            if(count>=2) return true;
        }
        return false;
    }

    // 将数组的数往前移动setps位
    public static void move(int index, int[] nums, int setps){
        int len = nums.length;
        while (index < len-setps){
            nums[index] = nums[index+setps];
            index++;
        }
    }

    public static void main(String[] args) {
        int[] ints = {0,0,1,1,1,1,2,3,3};
        System.out.println(solution(ints));
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
