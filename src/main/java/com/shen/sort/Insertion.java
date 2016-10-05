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
            //从最后一个和相邻的前一个元素逐一比较，前边的小于后边的，就互换位置，这样a[j]就变成了a[j-1],然后在和a[j-2]比较，在互换，
            //  其实就是实现了最后一个元素a[j]逐一往前比较，插入到合适位置，其他元素逐一后移了。
            //如果最后一个元素本来就大于(前一个)元素，是有序的，就不需要在进行逐一的比较了，直接break
            for(int j=i; j>0; j--){
                if(less(arr[j],arr[j-1])){
                    exch(arr,j,j-1);
                }else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Insertion insertion = new Insertion();
//        String[] arr = new String[]{"d","b","c","a","x","z","y"};
        String[] arr = new String[]{"8","5","1","2","4","6","3"};
        insertion.sort(arr);
        assert insertion.isSorted(arr);
        insertion.show(arr);
    }
}
