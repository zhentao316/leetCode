import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: huangzhentao
 * @Date: 2020/2/10 10:07
 */
public class SlidingWindow {

  public static boolean checkInclusion(String s1, String s2) {
    HashMap<Character, Integer> cMap = new HashMap<>();
    HashMap<Character, Integer> cCount = new HashMap<>();
    int left = 0, right = 0;
    for (int i = 0; i < s2.length(); i++) {
      int count = cMap.getOrDefault(s2.charAt(i), 0);
      count++;
      cMap.put(s2.charAt(i), count);
    }
    while (right < s1.length()) {
      char tem = s1.charAt(right);
      int count = cCount.getOrDefault(tem, 0);
      count++;
      cCount.put(s1.charAt(right), count);
      if (right - left + 1 == s2.length()) {
        boolean result=true;
        for(Character key : cMap.keySet()){
          result&=cMap.get(key).equals(cCount.get(key));
        }
        if(result){
          return result;
        }
        cCount.put(s1.charAt(left), cCount.get(s1.charAt(left)) - 1);
        left++;
      }
      right++;
    }
    return false;
  }

  public static double[] medianSlidingWindow(int[] nums, int k) {
    PriorityQueue<Integer> low = new PriorityQueue(Comparator.reverseOrder());
    PriorityQueue<Integer> high = new PriorityQueue();
    HashMap<Integer, Integer> counts = new HashMap<>();
    double[] result = new double[nums.length - k + 1];
    int index = 0;
    if (nums.length < k) {
      return new double[0];
    }
    for (; index < k; index++) {
      low.add(nums[index]);
    }
    for (int i = 0; i < k / 2; i++) {
      high.add(low.poll());
    }
    while (index <= nums.length) {
      if (k % 2 == 0) {
        result[index - k] = (high.peek() + low.peek()) / 2.0;
      } else {
        result[index - k] = low.peek();
      }
      if (index == nums.length) {
        break;
      }
      int outNumber = nums[index - k];
      int inNumber = nums[index];
      int balance = 0;
      if (outNumber <= low.peek()) {
        balance--;
      }
      if (inNumber <= low.peek()) {
        low.add(inNumber);
        balance++;
      } else {
        high.add(inNumber);
      }
      while (balance > 0) {
        high.add(low.poll());
        balance--;
      }
      if (balance < 0 && !high.isEmpty()) {
        low.add(high.poll());
        balance++;
      }
      int tempCount = counts.getOrDefault(outNumber, 0);
      tempCount++;
      counts.put(outNumber, tempCount);
      while (counts.containsKey(low.peek()) && counts.get(low.peek()) > 0) {
        counts.put(low.peek(), counts.get(low.peek()) - 1);
        low.poll();
      }
      while (counts.containsKey(high.peek()) && counts.get(high.peek()) > 0) {
        counts.put(high.peek(), counts.get(high.peek()) - 1);
        high.poll();
      }
      index++;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    String str = "eidbaooo";
    System.out.println(checkInclusion(str, "ab"));
  }

  public int characterReplacement(String s, int k) {
    HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
    int maxCount = 0;
    int left = 0, right = 0;
    int res = 0;
    for (; right < s.length(); right++) {
      int count = counts.getOrDefault(s.charAt(right), 0);
      count = count + 1;
      counts.put(s.charAt(right), count);
      maxCount = Math.max(count, maxCount);
      if (right - left - maxCount > k) {
        counts.put(s.charAt(left), counts.get(s.charAt(left)) - 1);
        left++;
      }
      res = Math.max(res, right - left + 1);
    }
    return res;
  }
}
