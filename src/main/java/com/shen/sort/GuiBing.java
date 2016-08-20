package com.shen.sort;

/**
 * 归并排序
 * @author shen
 *
 */
public class GuiBing {
	
	public static void main(String[] args) {
        int[] a={49,-38,65,97,76,-13,27,49,0,34,12,64,1,8,7,12};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+", ");
        }
        System.out.println();
        //归并排序
        mergeSort(a,0,a.length-1,"A");
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+", ");
        }
    }

    private static void mergeSort(int[] a, int left, int right,String type) {
        if(left<right){
        	//找出中间索引
            int middle = (left+right)/2;
            System.out.println("sort, begin="+left+",mid="+middle+",end="+right+", type="+type);
            //对左边数组进行递归
            mergeSort(a, left, middle,"L");
            //对右边数组进行递归
            mergeSort(a, middle+1, right,"R");
            //合并指定索引的2个子数组
            merge(a,left,middle,right);
        }else{
        	System.out.println("return , left="+left+", right="+right);
        	return ;
        }
    }
    
    
    /**
     * 将2个子数组进行归并，归并前2子数组已经分别有序，归并后依然有序（第一次递归到底，2个子数组应该是前2个元素，每个子数组包含一个元素）
     * @param a 原数组
     * @param left 左子数组第一个元素索引
     * @param middle 左子数组最后一个元素索引，middle+1是右数组第一个元素索引
     * @param right 右数组最后一个元素索引
     */
    private static void merge(int[] a, int left, int middle, int right) {
    	System.out.println("merge, begin="+left+",mid="+middle+",end="+right);
        //临时数组
    	int[] tmpArr = new int[a.length];
        //右数组第一个元素的索引
    	int rightArrIndex = middle + 1;
        //临时数组的索引
        int tmpIndex = left;
        //缓存左数组第一个元素的索引，最后将缓存数组本次排序的元素赋值回原数组用。
        int tmpBeginIndex = left;
        //核心比较部分？？？？？
        while(left<=middle && rightArrIndex<=right){
            //从两个数组中选取较小的数放入中间数组
            if(a[left]<=a[rightArrIndex]){
            	//++表示执行完再+1，其实就是循环条件的重新赋值。
                tmpArr[tmpIndex++] = a[left++];
            }else{
                tmpArr[tmpIndex++] = a[rightArrIndex++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while(left<=middle){
            tmpArr[tmpIndex++] = a[left++];
        }
        while(rightArrIndex<=right){
            tmpArr[tmpIndex++] = a[rightArrIndex++];
        }
        // 将临时数组中的内容拷贝回原数组中  
        // （原left-right范围的内容被复制回原数组）
        while(tmpBeginIndex<=right){
            a[tmpBeginIndex] = tmpArr[tmpBeginIndex++];
        }
    }
	
}
