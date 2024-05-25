package algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个由正整数组成的数组和一个正整数k，请问数组中有多少个数字乘积小于k的连续子数组？
 * 例如，输入数组[10，5，2，6]，k的值为100，有8个子数组的所有数字的乘积小于100，
 * 它们分别是[10]、[5]、[2]、[6]、[10，5]、[5，2]、[2，6]和[5，2，6]。
 *
 * 双指针：从头开始计算当前固定p1，p2向后移动，若范围内数组小于目标值则添加进子数组；若不小于则p1向后移动，p2=p1，直到p1移动到数组的末尾。
 */
public class Pruduct_less_tan_tartget {
    public static List<List<Integer>> doing(int[]ints, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        int p1=0;
        int p2=0;

        while (p1<ints.length){
            int product=1;
            p2=p1;
            while (p2<ints.length){
                product*=ints[p2];
                if(product<target){
                    int tmp_p1=p1;
                    List<Integer> tmplist=new ArrayList<>();
                    while (tmp_p1<=p2)tmplist.add(ints[tmp_p1++]);
                    lists.add(tmplist);

                }else {
                    break;
                }
                p2++;
            }
            p1++;
        }
        return lists;
    }
    public static void main(String[] args) {
        int [] nums = {10, 5, 2, 6};
        System.out.println(doing(nums, 100));
    }
}
