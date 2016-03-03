package com.shen.order.charu;

/**
 * 直接插入排序
 * 
 * 是稳定排序，因为相等的不会移动，所以相等的元素在排序前后的前后顺序不会变。
 * 
 * @author shen
 * 
 */
public class ZhijieChaRu {
	
	public static void main(String[] args) {
		int[] a = { 49, -38, 65, 22, 76, -13, 27, 49, 78, 0, 34, 12, 64, 1 };
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		// 直接插入排序
		// 可以打断点跟一下
		for (int i = 1; i < a.length; i++) {
			// 待插入元素
			int temp = a[i];
			int j;
			for (j = i - 1; j >= 0; j--) {
				// 将大于temp的往后移动一位
				int now = a[j];
				if (now > temp) {
					a[j + 1] = now;
				} else {
					break;
				}
			}
			a[j + 1] = temp;
		}
		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
}
