package com.shen.sort;

/**
 * 快速排序
 * 
 * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,
 * 此时基准元素在其排好序后的正确位置,
 * 然后再用同样的方法递归地排序划分的两部分。
 * @author shen
 *
 */
public class Quick{

	public void sort(int[] arr) {
		quickSort(arr,0,arr.length-1);
	}

	private void quickSort(int[] arr, int left, int right) {
		//满足 left<right 条件才进行排序,
		if(left < right){
			//将数组进行一分为二
			int middle = partition(arr,left,right);
			System.out.println("---"+middle);
			//左右2边分别递归调用quickSort进行排序
			quickSort(arr,left,middle - 1);
			quickSort(arr,middle + 1,right);
		}
	}

	private int partition(int[] arr, int left, int right) {
		//数组的第一个元素作为基准，提到while循环外边，最后在赋值用，不会导致丢值。
		int tmp = arr[left];
		while(left < right){
			//找到比基准元素小的元素位置
			while(left < right && arr[right] >= tmp){
				right -- ;
			}
            arr[left] = arr[right]; 
            while(left < right && arr[left]<=tmp){
                left ++;
            }
            arr[right] = arr[left];
		}
		arr[left] = tmp;
		return left;
	}
	
	public static void main(String[] args) {
		Quick q = new Quick();
		int[] arr ={49,38,65,97,76,13,27,49,78,34,12,64,1,8};
        q.sort(arr);
        for(int i=0; i<arr.length; i++ ){
            System.out.print(arr[i] + " ");
        }
	}

}
