package com.shen.sort;

import com.shen.SortBase;

/**
 * 插入排序
 *      和整理扑克牌是类似的，将每张牌插入到其他已经有序的牌中适当位置。为给插入的元素腾出空间，需要将其余
 *      所有元素在插入之前都向右移动一位，这种算法就叫插入排序
 *      与选择排序一样，当前索引左边的所有元素都是有序的，但它们最终位置还不确定，为了给更小的元素腾出空间，
 *      它们可能会被移动，但是当索引到达数组右端时，排序就完成了。
 *      和选择排序不同，插入排序所需时间取决于数组元素的初始顺序。对于一个元素已经有序(或接近有序)的数组会
 *      比随机顺序的数组或逆序数组进行排序要快的多。
 *
 *
 * Created by shenge on 16/7/6.
 */
public class Insertion extends SortBase {
    @Override
    public void sort(Comparable[] arr) {
        int length = arr.length;
        //从索引1开始，也就是从数组的第2位开始，注意不是第一位
        for(int i=1; i<length; i++){
            //从当前索引开始，从后往前，逐个比较大小，目的就是把当前索引的元素插入到前边已经有序元素的适当位置。
            for(int j=i; j>0; j--){
                if(less(arr[j],arr[j-1])){
                    exch(arr,j,j-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Insertion insertion = new Insertion();
        String[] arr = new String[]{"d","b","c","a","x","z","y"};
        insertion.sort(arr);
        assert insertion.isSorted(arr);
        insertion.show(arr);
    }
}
