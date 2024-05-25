package algorithms.String;

/**
 * 输入字符串s1和s2，如何判断字符串s2中是否包含字符串s1的某个变位词？
 * 如果字符串s2中包含字符串s1的某个变位词，则字符串s1至少有一个变位词是字符串s2的子字符串。假设两个字符串中只包含英文小写字母。
 * 例如，字符串s1为"ac"，字符串s2为"dgcaf"，由于字符串s2中包含字符串s1的变位词"ca"，因此输出为true。
 * 如果字符串s1为"ab"，字符串s2为"dgcaf"，则输出为false。
 */
public class Find_inclusion {
    public static Boolean doing(String str1, String str2) {
        if(str1.length() > str2.length()) return false;
        int count[] = new int[26];
        // 将数组的目标变位词在26字母数组中对应位置加一
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a'] ++;
        }
        int p1=0;
        int p2=1;
        count[str2.charAt(p1) - 'a'] --;
        count[str2.charAt(p2) - 'a'] --;
        if(All_zero(count)) return true;
        for (int i = str1.length(); i < str2.length(); i++) {

            count[str2.charAt(i-str1.length()) - 'a'] ++;
            System.out.println(str2.charAt(i-str1.length())+" "+str2.charAt(i));
            count[str2.charAt(i) - 'a'] --;
            if(All_zero(count)) return true;
        }

        return false;
    }

    private static boolean All_zero(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if(count[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(doing("ms", "nums"));
    }
}
