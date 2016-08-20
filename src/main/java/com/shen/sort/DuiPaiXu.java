package com.shen.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 
 * 基本思想就是将待排序的的序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根结点，将它移走（其实就是将
 * 	其与堆数组的末尾元素交换，此时末尾元素就是最大值）。然后将剩余的n-1个序列重新构造一个对，这样就会得到n个元素
 * 	中的次小值，如此反复，便得到一个有序序列。
 * 
 * 	2个for循环：
 * 		第一个要完成的就是将现在的待排序序列构建一个大顶堆
 * 		第二个要完成的就是逐步将每个最大值的根结点与末尾元素交换，并且再调整其成为大顶堆。
 *  
 *  以上说明均摘自大话数据结构
 * 
 * @author shen
 * 
 */
public class DuiPaiXu {

	public static void main(String[] args) {
		int[] a = { 49, -38, 65, 97, 76, -13, 27, 49, 0, 34, 12, 64 };
		int arrayLength = a.length;
		// 循环建堆
		for (int i = 0; i < arrayLength - 1; i++) {
			// 建堆
			buildMaxHeap(a, arrayLength - 1 - i);
			// 交换堆顶和最后一个元素
			swap(a, 0, arrayLength - 1 - i);
			System.out.println(Arrays.toString(a));
		}
	}

	// 对data数组从0到lastIndex建大顶堆
	public static void buildMaxHeap(int[] data, int lastIndex) {
		// 从lastIndex处节点（最后一个节点）的父节点开始
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// k保存正在判断的节点
			int k = i;
			// 如果当前k节点的子节点存在
			while (k * 2 + 1 <= lastIndex) {
				// k节点的左子节点的索引
				int biggerIndex = 2 * k + 1;
				// 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
				if (biggerIndex < lastIndex) {
					// 若果右子节点的值较大
					if (data[biggerIndex] < data[biggerIndex + 1]) {
						// biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}
				}
				// 如果k节点的值小于其较大的子节点的值
				if (data[k] < data[biggerIndex]) {
					// 交换他们
					swap(data, k, biggerIndex);
					// 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}

	// 交换
	private static void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

}
