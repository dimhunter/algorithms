package com.shen.order.jiaohuan;

/**
 * 冒泡排序（是稳定的算法）
 * 
 * @author shen
 * 
 */
public class MaoPao1 {
	
	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, -76, 13, 27, 49, 78, 34, 12 , 0 , 64, 1, -8 };
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		// 冒泡排序
		for (int i = 0; i < a.length; i++) {
			//对当前无序区间a[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
			for (int j = 0; j < a.length - i - 1; j++) {
				// 这里-i主要是每遍历一次都把最大的i个数沉到最底下去了，没有必要再替换了
				// 把小的值交换到后面
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		
		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
