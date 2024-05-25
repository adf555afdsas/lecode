package algorithms.String;

/**
 * 题目：输入一个字符串，求该字符串中不含重复字符的最长子字符串的长度。
 * 例如，输入字符串"babcca"，其最长的不含重复字符的子字符串是"abc"，长度为3。
 */
public class Longest_subString {
    public static int doing(String str) {
        int[] letters = new int[26];
        int p1 = 0;
        int max_len = 0;
        for (int i = 0; i < str.length(); i++) {
            letters[str.charAt(i) - 'a']++;
            boolean flag = false;
            while (check_biger_than_1(letters)){
                letters[str.charAt(p1++) - 'a'] --;
            }
            max_len = Math.max(max_len, i-p1+1);
        }
        return max_len;
    }

    private static Boolean check_biger_than_1(int[] letters) {
        for (int letter : letters) {
            if(letter > 1) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(doing("babcddca"));
    }
}
