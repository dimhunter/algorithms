package com.shen.sort;

import com.shen.SortBase;

public class Merge extends SortBase {
	
	private Comparable[] aux;
	
	public void sort(Comparable[] a){
		aux = new Comparable[a.length];
		mergeSort(a,0,a.length-1,"A");
	}

	private void mergeSort(Comparable[] a, int low, int high,String type) {
		if(high <= low){
			System.out.println("return , left="+low+", right="+high);
			return;
		}
		int mid = low + (high - low)/2;
		System.out.println("sort, begin="+low+",mid="+mid+",end="+high+", type = "+type);
		mergeSort(a,low,mid,"L");
		mergeSort(a,mid+1,high,"R");
		merge(a,low,mid,high);
	}
	
	/**
	 * 已递归到此处
	 * @param a
	 * @param low
	 * @param mid
	 * @param high
	 */
	private void merge(Comparable[] a, int low, int mid, int high) {
		System.out.println("merge, begin="+low+",mid="+mid+",end="+high);
		int i = low, j = mid + 1;
		//将此次要排序从low到high区间的a数组中对应下标low到high的元素赋值到tmp数组中。
		for(int k = low; k<=high; k++){
			aux[k] = a[k];
		}
		for(int k = low; k<=high; k++){
			if(i > mid){
				a[k] = aux[j++];
			}else if(j > high){
				a[k] = aux[i++];
			}else if(less(aux[j],aux[i])){
				a[k] = aux[j++];
			}else{
				a[k] = aux[i++];
			}
		}
	}
	
	public static void main(String[] args) {
		Merge m = new Merge();
        String[] arr = new String[]{"M","E","R","G","E","S","O","R","T","E","X","A","M","P","L","E"};
        m.sort(arr);
        assert m.isSorted(arr);
        m.show(arr);
	}
	
}
