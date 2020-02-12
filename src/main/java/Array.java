import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @Author: huangzhentao
 * @Date: 2020/2/11 16:16
 */
public class Array {

  /**
   * 1,2,3,-1,7 53. 最大子序和 //todo分治法和动态规化
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


  /**
   * 66. 加一
   *
   * @param digits
   * @return
   */
  public static int[] plusOne(int[] digits) {
    int prefix = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
      int result = digits[i] + prefix;
      prefix = result / 10;
      digits[i] = result % 10;
    }
    if (prefix > 0) {
      int[] result = new int[digits.length + 1];
      result[0] = prefix;
      System.arraycopy(digits, 0, result, 1, digits.length);
      return result;
    } else {
      return digits;
    }
  }

  public static int getValue(int pos, int level) {
    if (pos == 0 || pos == level - 1) {
      return 1;
    }
    if (pos < 0 || level < 1) {
      return 0;
    }
    return getValue(pos - 1, level - 1) + getValue(pos, level - 1);
  }

  public static int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int max = 0;
    while (left < right) {
      int area = Math.min(height[left], height[right]) * (right - left);
      max = Math.max(max, area);
      if (height[left] > height[right]) {
        right--;
        while (right > left && height[right] < height[right + 1]) {
          right--;
        }
      } else {
        left++;
        while (left < right && height[left] < height[left - 1]) {
          left++;
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] temp = {1, 2, 3};
    nextPermutation(temp);
    System.out.println(Arrays.toString(temp));
  }

  /**
   * 31. 下一个排列
   *
   * @param nums
   */
  public static void nextPermutation(int[] nums) {
    int pos = 0;
    for (pos = nums.length - 2; pos >= 0; pos--) {
      if (nums[pos] < nums[pos + 1]) {
        break;
      }
    }
    if (pos >= 0) {
      for (int i = nums.length - 1; pos < i; i--) {
        if (nums[i] > nums[pos]) {
          int temp = nums[pos];
          nums[pos] = nums[i];
          nums[i] = temp;
          break;
        }
      }
    }
    int j = nums.length - 1;
    while (pos + 1 < j) {
      int temp = nums[pos + 1];
      nums[pos + 1] = nums[j];
      nums[j] = temp;
      pos++;
      j--;
    }
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

  /**
   * 88. 合并两个有序数组
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int index = m + n - 1;
    while (true) {
      if (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
          nums1[index--] = nums1[i--];
        } else {
          nums1[index--] = nums2[j--];
        }
      } else if (i >= 0) {
        nums1[index--] = nums1[i--];
      } else if (j >= 0) {
        nums1[index--] = nums2[j--];
      } else {
        break;
      }
    }
  }

  /**
   * 118. 杨辉三角
   *
   * @param numRows
   * @return
   */
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 1; i <= numRows; i++) {
      List<Integer> temp = new ArrayList<>();
      for (int j = 0; j < i; j++) {
        if (j == 0 || j == i - 1) {
          temp.add(1);
        } else {
          temp.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j));
        }
      }
      result.add(temp);
    }
    return result;
  }

  /**
   * 119. 杨辉三角 II 递归会超时
   *
   * @param rowIndex
   * @return
   */
  public List<Integer> getRow(int rowIndex) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < rowIndex + 1; i++) {
      result.add(getValue(i, rowIndex + 1));
    }
    return result;
  }

  public int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int middle = (low + high) / 2;
      if (nums[middle] == target) {
        return target;
      }
      //说明中点在大数这边
      if (nums[middle] >= nums[low]) {
        if (target > nums[middle]) {
          low = middle + 1;
        } else {
          if (target < nums[low]) {
            low = middle + 1;
          } else {
            high = middle - 1;
          }
        }
      } else {
        if (target < nums[middle]) {
          high = middle - 1;
        } else {
          if (target > nums[high]) {
            high = middle - 1;
          } else {
            low = middle + 1;
          }
        }
      }
    }
    return -1;
  }

  public int maxProfit(int[] prices) {
    int small = Integer.MAX_VALUE;
    int max = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < small) {
        small = prices[i];
      }
      max = Math.max(max, prices[i] - small);
    }
    return max;
  }

  /**
   * 122. 买卖股票的最佳时机 II
   *
   * @param prices
   * @return
   */
  public int maxProfit2(int[] prices) {
    int sum = 0;
    int small = Integer.MAX_VALUE;
    int index = 0;
    while (index < prices.length) {
      small = Math.min(small, prices[index]);
      while (index + 1 < prices.length && prices[index + 1] > prices[index]) {
        index++;
      }
      sum += prices[index] - small;
      small = Integer.MAX_VALUE;
      index++;
    }
    return sum;
  }

  public int[] twoSum(int[] numbers, int target) {

    Map<Integer, Integer> maps = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
      if (maps.containsKey(target - numbers[i])) {
        int[] result = new int[2];
        result[0] = maps.get(target - numbers[i]) + 1;
        result[1] = i + 1;
        return result;
      }
      maps.put(numbers[i], i);
    }
    return new int[0];
  }

  /**
   * 169. 多数元素
   *
   * @param nums
   * @return
   */
  public int majorityElement(int[] nums) {
    int count = 0;
    int target = 0;
    for (int i = 0; i < nums.length; i++) {
      if (count == 0) {
        target = nums[i];
        count++;
      } else {
        if (nums[i] == target) {
          count++;
        } else {
          count--;
        }
      }
    }
    return target;
  }

  /**
   * 189. 旋转数组
   *
   * @param nums
   * @param k
   */
  public void rotate(int[] nums, int k) {
    int length = nums.length;
    for (int i = 0; i < k; i++) {
      int temp = nums[length - 1];
      for (int j = nums.length - 1; j > 0; j--) {
        nums[j] = nums[j - 1];
      }
      nums[0] = temp;
    }
  }

  /**
   * 217. 存在重复元素
   *
   * @param nums
   * @return
   */
  public boolean containsDuplicate(int[] nums) {
    Map<Integer, Integer> mapCount = new HashMap<>();
    for (int i : nums) {
      if (mapCount.containsKey(i)) {
        return true;
      }
      mapCount.put(i, 1);
    }
    return false;
  }

  /**
   * 219. 存在重复元素 II
   *
   * @param nums
   * @param k
   * @return
   */
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> mapCount = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (mapCount.containsKey(nums[i]) && (i - mapCount.get(nums[i])) <= k) {
        return true;
      }
      mapCount.put(nums[i], i);
    }
    return false;
  }

  /**
   * 268. 缺失数字
   *
   * @param nums
   * @return
   */
  public int missingNumber(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += 1 + i - nums[i];
    }
    return sum;
  }

  /**
   * 283	移动零
   *
   * @param nums
   */
  public void moveZeroes(int[] nums) {
    int index = 0;
    for (int temp : nums) {
      if (temp != 0) {
        nums[index++] = temp;
      }
    }
    while (index < nums.length) {
      nums[index++] = 0;
    }
  }

  /**
   * 414. 第三大的数
   *
   * @param nums
   * @return
   */
  public int thirdMax(int[] nums) {
    TreeSet<Integer> set = new TreeSet();
    for (int i : nums) {
      if (set.size() < 3) {
        set.add(i);
      } else {
        if (i > set.first() && !set.contains(i)) {
          set.remove(set.first());
          set.add(i);
        }
      }
    }
    if (set.size() == 3) {
      return set.first();
    } else {
      return set.last();
    }
  }

  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>(nums.length);
    List<Integer> temp = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (res.get(nums[i]-1) == null) {
        res.set(nums[i]-1, nums[i]);
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (res.get(i) == null) {
        temp.add(i + 1);
      }
    }
    return temp;
  }

}
