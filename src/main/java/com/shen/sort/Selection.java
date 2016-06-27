package com.shen.sort;

import com.shen.SortBase;

/**
 * 选择排序:
 *      首先找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么就和自己交换)。
 *      再次，在剩下元素中找到最小的元素，将它与数组的第二个元素交换位置。
 *      如此往复，直到将整个数组排序。
 *
 * Created by shenge on 16/6/27.
 */
public class Selection extends SortBase {

    @Override
    public void sort(Comparable[] arr) {
        int N = arr.length;
        //将arr升序排列
        for(int i=0; i<N; i++){
            int min = i;
            for(int j=i+1; j<N; j++){
                if(less(arr[j],arr[min])){
                    min = j;
                }
            }
            exch(arr,i,min);
        }
    }


    public static void main(String[] args) {
        Selection selection = new Selection();
        String[] arr = new String[]{"d","b","c","a","x","z","y"};
        selection.sort(arr);
        assert selection.isSorted(arr);
        selection.show(arr);
    }
}
