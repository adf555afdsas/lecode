package algorithms.prictice;

public class heapSort {

    public static void main(String[] args) {
         int []nums = {4,3,2,1,5,9,3,7,6,2};
         heapSort(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }

    public static int[] heapSort(int arr[]){
        int n = arr.length;
        // ini big root heap
        for (int i = (n-2)/2; i >=0; i--) {
            headSort(arr, i, n-1);
        }

        // begin to sort
        for (n--; n >0 ; ) {
            int tmp = arr[0];
            arr[0] = arr[n];
            arr[n] = tmp;
            headSort(arr, 0, --n);
        }
        return arr;
    }


    // 构建大根堆
  public static void headSort(int[]arr, int parent, int end){
        // arr:source arraylist; parent：Non-leaf node; end:last node

      // 父节点的值
      int temp = arr[parent];
      // 左孩子节点
      int child = 2*parent + 1;

      while (child<=end){
          // find out the bigger between left child and right child;

          if (child + 1 < end && arr[child] < arr[child+1]){
              child++;
          }

          // if parent >  two child then break
          if (temp>=arr[child]) break;
          arr[parent] = arr[child];
          parent = child;
          child = 2*parent + 1;
      }
      arr[parent] =temp;

  }



}