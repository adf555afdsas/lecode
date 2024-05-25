package algorithms.arrays;

/**
 * 输入一个二维矩阵，如何计算给定左上角坐标和右下角坐标的子矩阵的数字之和？
 * 对于同一个二维矩阵，计算子矩阵的数字之和的函数可能由于输入不同的坐标而被反复调用多次。
 * 例如，输入图2.1中的二维矩阵，以及左上角坐标为（2，1）和右下角坐标为（4，3）的子矩阵，该函数输出8。
 */
public class Nummatrinx {
    public static int doing (int r1, int c1, int r2, int c2, int[][] nums) {
        if (nums.length==0 || nums[0].length==0) return 0;
        // 把nums中的数计算出其从（0，0）到（i，j）的和并把和放入一个长nums.length+1，宽nums[0].length+1的数组中，长度加一是为了避免数组溢出
        int[][]sums = new int[nums.length+1][nums[0].length+1];
        for (int i = 0; i < nums.length; i++) {
            int sumRow = 0;
            for (int i1 = 0; i1 < nums[0].length; i1++) {
                sumRow += nums[i][i1];
                sums[i+1][i1+1] = sumRow + sums[i][i1+1];
            }
        }

        //（r1，c1）到 （r2, c2）的值
        return sums[r2+1][c2+1] - sums[r2+1][c1] - sums[r1][c2+1] + sums[r1][c1];


    }
    public static void main(String[] args) {
        System.out.println();
    }
}
