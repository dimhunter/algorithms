package com.shen.order.charu;

/**
 * 希尔排序
 * 
 * 是不稳定的排序，但时间复杂度最低。最快。
 * 
 * @author shen
 *
 */
public class XiEr {

	public static void main(String[] args) {
		int[] a = { 49, -38, 65, 97, 76, -13, 27, 49, 0, 34, 12, 64, 1 };
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		// 希尔排序
		int d = a.length;
		while (true) {
			//1. 取一个小于元素总数的整数d作为第一个增量，把文件的全部记录分成d个组。所有距离为d的倍数的记录放在同一个组中。
			d = d / 2;
			for (int x = 0; x < d; x++) {
				//2. 先在各组内进行直接插入排序。排完之后while循环中d=d/2继续将d变小，继续分组排。
				for (int i = x + d; i < a.length; i = i + d) {
					int temp = a[i];
					int j;
					for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
						a[j + d] = a[j];
					}
					a[j + d] = temp;
				}
			}
			//3.最后直到d=1，表示排完了。
			if (d == 1) {
				break;
			}
		}
		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
