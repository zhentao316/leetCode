package sort;

import java.util.Arrays;

/**
 * @Author: huangzhentao
 * @Date: 2020/3/5 14:08
 *
 */
public class HeapSort {

  public static void sort(int[] nums,int n){
    for(int i=n/2-1;i>=0;i--){
      adjust(nums,i,n);
    }
  }
  public static void adjust(int[] nums,int i,int n){
    while (i<=n/2){
      int child=(i+1)*2;
      if(child+1<=n&&nums[child]>nums[child-1]){
        child=child+1;
      }
      if(child<=n&&nums[child-1]>nums[i]){
        swap(nums,i,child-1);
      }
      i=child-1;
    }
  }
  public static void swap(int[] nums,int i,int j){
    int temp=nums[i];
      nums[i]=nums[j];
      nums[j]=temp;
  }

  public static void main(String[] args) {
    int[] nums={7,6,5,4,3,2,1};

     for (int i=nums.length;i>0;i--){
       swap(nums,0,i-1);
     }
    System.out.println(Arrays.toString(nums));
  }
}
