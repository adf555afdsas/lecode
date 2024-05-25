package algorithms.binary;

/**
 * 将一个数转换成二进制数
 */
public class to_bit {
    public static void main(String[] args) {
        System.out.println(do_to_bit(-10));
    }

    public static String do_to_bit(int num){
        String result = "";
        boolean flag=false;
        if (num < 0) flag=true;
        while (num!=0){
            int n = 1;
            if(num%2 ==0) n = 0;
            num/=2;
            result =n+result;
        }
        if (flag) return "1"+result;
        return result;
    }

}
