package algorithms.binary;

/**
 * 我们可以使用哈希映射统计数组中每个元素的出现次数。对于哈希映射中的每个键值对，键表示一个元素，值表示其出现的次数。
 *
 * 在统计完成后，我们遍历哈希映射即可找出只出现一次的元素。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/single-number-ii/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Current_only_once {
    public static int singleNumber(int[] nums) {
        int [] nums_bit = new int[32];
        // 将数组中每个数字用三十二位二进制表示，并将每一位相加
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                nums_bit[i]+=num>>31-i & 1;
            }
        }
        // 将相加后的数组每一位除以3，出现三次的数字在这一位上余0，出现一次的余零或1，将相除后的结果就是这个数的二进制形式
        // 将这个二进制数转换成十进制
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret = (ret<<1)+nums_bit[i]%3;
        }
        return ret;
    }

    public static void main(String[] args) {
        int []nums = {0,1,0,1,0,1,98};
        singleNumber(nums);
    }
}
