/**
 * @Author: huangzhentao
 * @Date: 2020/2/11 16:16
 */
public class Array {

  /**
   * 1,2,3,-1,7 53. 最大子序和
   * //todo分治法和动态规化
   *
   * @param nums
   * @return
   */
  public static int maxSubArray(int[] nums) {
    int maxCurrent = 0;
    int maxThis = nums[0];
    for (int i = 0; i < nums.length; i++) {
      maxThis = Math.max(nums[i] + maxCurrent, maxThis);
      if (maxCurrent + nums[i] > 0) {
        maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
      } else {
        maxCurrent = 0;
      }
    }
    return maxThis;
  }

  public static int maxSubArray2(int[] nums) {
    int maxCurrent = 0;
    int maxThis = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (maxCurrent > 0) {
        maxCurrent += nums[i];
      } else {
        maxCurrent = nums[i];
      }
      maxThis = Math.max(maxThis, maxCurrent);
    }
    return maxThis;
  }

  public static void main(String[] args) {
    int[] temp = {-1};
    System.out.println(maxSubArray(temp));
  }

  public int removeDuplicates(int[] nums) {
    int mark = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[mark]) {
        nums[++mark] = nums[i];
      }
    }
    return mark + 1;
  }

  /**
   * 27. 移除元素
   *
   * @param nums
   * @param val
   * @return
   */
  public int removeElement(int[] nums, int val) {
    int mark = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[mark++] = nums[i];
      }
    }
    return mark;
  }

  /**
   * 35. 搜索插入位置
   *
   * @param nums
   * @param target
   * @return
   */
  public int searchInsert(int[] nums, int target) {
    int i = 0;
    for (; i < nums.length; i++) {
      if (nums[i] >= target) {
        break;
      }
    }
    return i;
  }
}
