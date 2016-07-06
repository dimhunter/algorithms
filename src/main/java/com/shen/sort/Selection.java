package com.shen.sort;

import com.shen.SortBase;

/**
 *
 * 简单选择排序(不稳定排序？):
 *      首先找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么就和自己交换)。
 *      再次，在剩下元素中找到最小的元素，将它与数组的第二个元素交换位置。
 *      如此往复，直到将整个数组排序。
 *
 * Created by shenge on 16/6/27.
 */
public class Selection extends SortBase {

    /**
     * 将arr升序排列
     * @param arr
     */
    @Override
    public void sort(Comparable[] arr) {
        int length = arr.length;
        //1. 从第0位开始，至最后一位，和剩余元素的最小值两两互换位置。
        for(int i=0; i<length; i++){
            //剩余元素的最小值的索引
            int min = i;
            //2. 通过less比较，找出剩余元素最小值的索引位置。
            for(int j=i+1; j<length; j++){
                if(less(arr[j],arr[min])){
                    min = j;
                }
            }
            //3. 将剩余元素的最小值，与第0至length-1位元素互换位置。
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
