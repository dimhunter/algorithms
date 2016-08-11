package com.shen.sort;

import com.shen.SortBase;
/**
 * 快速排序
 * @author shen
 *
 */
public class Quick extends SortBase{

	@Override
	public void sort(Comparable[] a) {
		quickSort(a,0,a.length-1);
	}

	private void quickSort(Comparable[] a, int left, int right) {
		if(right <= left){
			return ;
		}
		int j = partition(a,left,right);
		quickSort(a,left,j-1);
		quickSort(a,j+1,right);
	}

	private int partition(Comparable[] a, int left, int right) {
		int i = left, j = right+1;
		Comparable v = a[left];
		while(true){
			while(less(a[++i],v)) if(i == right) break;
			while(less(v, a[--j])) if(j == left) break;
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,left,j);
		return j;
	}
	
	public static void main(String[] args) {
		Quick q = new Quick();
		String[] arr = new String[]{"Q","U","I","C","K","S","O","R","T","E","X","A","M","P","L","E"};
        q.sort(arr);
        assert q.isSorted(arr);
        q.show(arr);
	}

}
