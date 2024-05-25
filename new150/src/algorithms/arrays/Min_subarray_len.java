package algorithms.arrays;

/**
 * 输入一个正整数组成的数组和一个正整数k，请问数组中和大于或等于k的连续子数组的最短长度是多少？
 * 如果不存在所有数字之和大于或等于k的子数组，则返回0。
 * 例如，输入数组[5，1，4，3]，k的值为7，和大于或等于7的最短连续子数组是[4，3]，因此输出它的长度2。
 */
public class Min_subarray_len {
    public static int doing(int[]ints, int target) {
        int len = 0;
        boolean flag = false;
        int p1 = 0;
        int p2 = 0;
        while (p1<=p2){
            while (get_sum(ints,p1,p2)<target && p2 < ints.length){
                p2++;
                if(p2==ints.length && p1==0) flag=true;
                len = len == 0 ? (p2 -p1)+1:Math.min(len,(p2 -p1)+1);
            }
            if(flag) break;


            while (get_sum(ints,p1,p2)>target && p1<p2){
                p1++;
                if(get_sum(ints,p1,p2)>target){
                    len--;
                }
            }

            if(p2==ints.length-1)break;
        }
        return len;

    }

    public static int get_sum(int[]ints,int i,int j) {
        int sum = 0;
        int end = (j-i)+1;
        for (int k = i; k <=j; k++) {
            sum+=ints[k];
        }
        return sum;
    }

    public static int doing2(int[]ints, int target){
        int p1=0;
        int p2=0;
        int sum = 0;
        int min_len = Integer.MAX_VALUE;
        for (; p2 < ints.length; p2++) {
            sum+=ints[p2];
            while (sum>=target&&p1<=p2){
                min_len = Math.min(min_len,(p2-p1)+1);
                sum-=ints[p1++];
            }
        }
        return min_len==Integer.MAX_VALUE?0:min_len;
    }
    public static void main(String[] args) {
        int [] arr = {5,1,4,3};
        System.out.println(doing2(arr, 7));
    }

}
