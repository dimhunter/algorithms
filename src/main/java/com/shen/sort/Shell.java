package com.shen.sort;

import com.shen.SortBase;

/**
 * 希尔排序就是在插入排序的基础上加入一个外循环，将h按照递增序列递减。
 * 适用于大型数组。解决的是插入排序只会交换相邻元素的弊端，跨大步的交换。比如最小值在数组末尾，这样交换就会节省时间。
 * Created by shenge on 16/7/6.
 */
public class Shell extends SortBase {

    @Override
    public void sort(Comparable[] arr) {
        int length = arr.length;
        int h = 1;
        //1. 通过3*h + 1计算出循环的因子。
        while(h < length/3){
            //1,4,13,40,121,.....
            h = 3*h + 1;
        }
        System.out.println("h="+h+",length="+length);
        //2. 将计算出的循环因子h加入到插入排序的外循环，h=h/3进行递减。
        while(h >= 1){
            //将数组变为h有序
            //将此处代码和插入排序的2个for循环比较，其实就是i++换成了j -= h，h增量的增量。
            for(int i = h; i<length; i++){
                //将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]... 之中
                for(int j = i; j >= h && less(arr[j],arr[j-h]); j -= h){
                    exch(arr,j,j-h);
                }
            }
            h=h/3;
        }
    }

    public static void main(String[] args) {
        Shell shell = new Shell();
        String[] arr = new String[]{"d","b","c","a","x","z","y","8","5","7","2","6","9","m","k","0","-38", "22", "-13"};
        shell.sort(arr);
        assert shell.isSorted(arr);
        shell.show(arr);
    }

}
