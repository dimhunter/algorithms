package com.shen.sort;

import com.shen.SortBase;

/**
 * Created by shenge on 16/7/6.
 */
public class Shell extends SortBase {

    @Override
    public void sort(Comparable[] arr) {
        int length = arr.length;
        int h = 1;
        while(h < length/3){
            //1,4,13,40,121,.....
            h = 3*h + 1;
        }
        while(h >= 1){
            //将数组变为h有序
            for(int i = h; i<length; i++){
                //将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]... 之中
                for(int j = i; j >= h && less(arr[j],arr[j-1]); j-=h){
                    exch(arr,j,j-h);
                }
                h=h/3;
            }
        }
    }

    public static void main(String[] args) {

    }

}
