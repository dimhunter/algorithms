package com.shen;

/**
 * Created by shenge on 16/6/27.
 */
public abstract class SortBase {

    /**
     * 排序主逻辑
     * @param arr
     */
    public abstract void sort(Comparable[] arr);

    /**
     * 比较大小(辅助函数)，a是否小于b
     *      对于compareTo方法
     *          返回正整数1，前者>后者
     *          返回0，前者=后者
     *          返回-1，前者<后者
     * @param a
     * @param b
     * @return true ：a<b ，反之false
     */
    public boolean less(Comparable a, Comparable b){
        System.out.println("-less");
        return a.compareTo(b) < 0;
    }

    /**
     * 交换顺序(辅助函数)
     * @param arr
     * @param i
     * @param j
     */
    public void exch(Comparable[] arr, int i, int j){
        //输出一些东西，可以比较不同算法执行元素交换位置的次数。次数越少，排序越快。
        System.out.println("==exch");
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }    

    /**
     * 测试数组元素是否有序
     * @param arr
     * @return
     */
    public boolean isSorted(Comparable[] arr){
        for(int i=1; i<arr.length; i++){
            if(less(arr[i],arr[i-1])){
                return false;
            }
        }
        return true;
    }

    /**
     * 单行中打印数组
     * @param arr
     */
    public void show(Comparable[] arr){
        for(int i=0; i<arr.length; i++ ){
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

}
