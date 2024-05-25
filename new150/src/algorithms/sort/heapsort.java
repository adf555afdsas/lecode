package algorithms.sort;
public class heapsort {
	// 堆排序

	/**
	 * @堆排序流程
	 * 1.先从堆尾向上构建标准大根堆，堆的每一个非叶子节点都大于其左右子节点
	 * 2.将根元素与最后一个元素进行交换，然后构建数组元素数量（n）减一的大根堆，直到完成根与根的左节点（及下表为1的元素）的元素交换后，数组变得有序。
	 * @param arr
	 * @return
	 */
	public static int[] headSort(int[] arr) {
		int n = arr.length;
		//构建大顶堆
		for (int i = (n - 2) / 2; i >= 0; i--) {
			downAdjust(arr, i, n - 1);
		}
		//进行堆排序
		for (int i = n - 1; i >= 1; i--) {
			// 把堆顶元素与最后一个元素交换
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			// 把打乱的堆进行调整，恢复堆的特性
			downAdjust(arr, 0, i - 1);
		}
		return arr;
	}

	//下沉操作
	public static void downAdjust(int[] arr, int parent, int n) {
		//临时保存要下沉的元素
		int temp = arr[parent];
		//定位左孩子节点的位置
		int child = 2 * parent + 1;
		//开始下沉
		while (child <= n) {
			// 如果右孩子节点比左孩子大，则定位到右孩子
			if (child + 1 <= n && arr[child] < arr[child + 1])
				child++;
			// 如果孩子节点小于或等于父节点，则下沉结束
			if (arr[child] <= temp) break;
			// 父节点进行下沉
			arr[parent] = arr[child];
			parent = child;
			child = 2 * parent + 1;
		}
		arr[parent] = temp;
	}


	public static void main(String[] args) {
		int arr[] = {4, 3, 2, 1, 5, 9, 3, 2, 2, 2};
		headSort(arr);

		for (int i : arr) {
			System.out.print(i);
		}
	}
}