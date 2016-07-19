package letcode;

/**
 * 本题题意：给出一个数组，然后求出数组中的子数组，使得其和�?�?
 * 
 * For example, given the array [�?2,1,�?3,4,�?1,2,1,�?5,4],the contiguous subarray [4,�?1,2,1] has the largest sum = 6
 * 
 * 解题思路：贪心方�?   先判断当前元素的前面max是多少，如果前面的max小于0，那么当前的max就不用�?�虑前面的部分了；如果前面的max大于零，那么当前的元素就可以加进去�??
 *
 */
public class MaximumSubarray100 {
	
	
	public int maxSubArray(int[] A) {
		
    	if (A == null || A.length == 0) return Integer.MIN_VALUE;  
        
    	//初始化数�?
        int[] max = new int[A.length];  
        //初始化最大�??
        max[0] = A[0];  
        int maximum = max[0];
        //从前�?后遍�?
        for (int i = 1; i < A.length; i++) {
        	//当前面的和大�?0的时�?  那么继续累加上当前的�?
            if (max[i - 1] > 0) {  
                max[i] = A[i] + max[i - 1];
            //也就是前面求出的和小�?0,那么就不用加上前面的数�?�了
            } else {  
                max[i] = A[i];  
            }  
            if (maximum < max[i]) {  
                maximum = max[i];  
            }  
        }  
        return maximum; 
	}
	
	
	
	public int minSubArray(int[] A){
		
		int ret = Integer.MAX_VALUE;
		int temp = 0;
		int aLength = A.length;
		for(int i = 0; i < aLength; i++){
			temp += A[i];
			if(ret > temp){
				ret = temp;
			}
			if(temp > 0){
				temp = 0;
			}
		}
		
		return ret;
	}
	
	
	public static void main(String[] args){
		int[] A = {1,2,-9,-4,5,6};
		MaximumSubarray100 object = new MaximumSubarray100();
		System.out.println(object.minSubArray(A));
	}
	
}
