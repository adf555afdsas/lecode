package algorithms.arrays;

/**
 * 输入一个字符串数组words，请计算不包含相同字符的两个字符串words[i]和words[j]的长度乘积的最大值
 */
public class Get_max {

    public static int getMAX(String[] words) {
        // 先把每个单词放入二维数组
        boolean current[][] = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                current[i][c-'a'] = true;
            }
        }
        int ret=0;

        for (int i = 0; i < words.length-1; i++) {
            for (int i1 = i+2; i1 < words.length; i1++) {
                boolean flag=false;
                for (int i2 = 0; i2 < 26; i2++) {
                    if (current[i][i2] && current[i1][i2]){flag = true;break;}
                    System.out.println(current[i][i2] + " " +current[i1][i2]);
                    System.out.println(i2);
                }
                if (flag) continue;
                ret =  Math.max(ret,words[i].length()*words[i1].length());
                System.out.println(words[i]+" "+words[i1]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] strs = {"abcw", "foo", "bar", "fxyz", "abcdef"};
        System.out.println(getMAX(strs)+"========");
    }

}
