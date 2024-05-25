package problem;

/**
 * 用减法实现除法
 */
public class devide_by_sub {
    public static void main(String[] args) {
        System.out.println(do_it(6666666, 2));
    }

    public static int do_it(int devid_end, int divisor){
        boolean flag=true;
        if(devid_end>0 && divisor>0 ||devid_end<0 && divisor<0) flag=false;
        if(devid_end>0) devid_end=-devid_end;
        if (divisor>0)divisor = -divisor;




        int value=divisor;
        int end = devid_end;
        int result = 0;
        boolean enter_flag=false;
        while (divisor>=devid_end){
            int ret=1;
            value=divisor;
            while (devid_end<=value+value){
                value+=value;
                ret+=ret;
                enter_flag=true;
            }
            result +=ret;
            devid_end-=value;

        }
        if (flag)return -result;
        return result;
    }

}
