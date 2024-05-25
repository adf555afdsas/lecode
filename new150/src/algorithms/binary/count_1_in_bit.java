package algorithms.binary;

/**
 * 获取二进制数中1的个数
 */
public class count_1_in_bit {
    public static void main(String[] args) {
        int a = 111;
        System.out.println(count(a));
    }

    public static int count(int num){
        int count = 0;
        while (num!=0){
            count+=num&1;
            num=num>>>1;
        }
        return count;
    }

}
