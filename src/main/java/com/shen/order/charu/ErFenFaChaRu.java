package com.shen.order.charu;

/**
 * 二分法插入排序
 * 
 * 也是稳定排序。
 * 
 * @author shen
 *
 */
public class ErFenFaChaRu {
	
	public static void main(String[] args) {
		int[] a = { 49, 38, -65, 97, 176, 213, 227, -49, 78, 34, 12, 0, 11, 18};
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		// 二分插入排序
		sort(a);
		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int temp = a[i];
			int left = 0;
			int right = i - 1;
			int mid = 0;
			// 1. 先找出left和right的位置。
			while (left <= right) {
				//程序中5/2=2，是强制转换，不会四舍五入的。
				mid = (left + right) / 2;
				int midtemp = a[mid]; 
				if (temp < midtemp) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			// 2. 然后在用直接插入法，在正确的left和right区间中排序。
			for (int j = i - 1; j >= left; j--) {
				a[j + 1] = a[j];
			}
			if (left != i) {
				a[left] = temp;
			}
		}
	}
}
