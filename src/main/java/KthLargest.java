class KthLargest {

  Integer[] result=null;
  public KthLargest(int k, int[] nums) {
    result=new Integer[k];
    for (int i=0;i<nums.length;i++){
      add(nums[i]);
    }
  }

  public int add(int val) {
    for (int i=0;i<result.length;i++){
      if(result[i]==null){
        result[i]=val;
        break;
      }
      if(result[i]<val){
        for (int j=result.length-1;j>i;j--){
          result[j]=result[j-1];
        }
        result[i]=val;
        break;
      }
    }
    if(result[result.length-1]!=null){
      return result[result.length-1];
    }

    return 0;
  }

  public static void main(String[] args) {
    int[] nums={4,5,8,2};
    KthLargest large=new KthLargest(3,nums);
  }
}