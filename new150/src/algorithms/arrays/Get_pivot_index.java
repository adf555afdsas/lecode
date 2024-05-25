package algorithms.arrays;

public class Get_pivot_index {
    public static int doing(int[]ints) {
        int total = 0;
        for (int anInt : ints) {
            total+=anInt;
        }

        int sum=0;
        for (int i = 0; i < ints.length; i++) {
            sum+=ints[i];
            if(sum-ints[i] == total-sum) return i;
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 2, 9};
        System.out.println(doing(nums));
    }
}
