import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: huangzhentao
 * @Date: 2020/2/24 15:42
 */
public class Recursion {

  public void reverseString(char[] s) {
    reverse(0,s.length-1,s);
  }
  public void reverse(int start,int end ,char[] s){
    if(end-start<=0){
      return;
    }
    reverse(start+1,end-1,s);
    char temp=s[start];
    s[start]=s[end];
    s[end]=temp;
  }

  public boolean isSubPath(ListNode head, TreeNode root) {
    if(root==null){
      return false;
    }
      return dfs(head,root)||isSubPath(head,root.left)||isSubPath(head,root.right);
  }
  public boolean dfs(ListNode head, TreeNode root) {
    if(head==null){
      return true;
    }
    if(root==null){
      return false;
    }
    if(head.val!=root.val){
      return false;
    }
   return dfs(head.next,root.left)||dfs(head.next,root.right);
  }
  public static void main(String[] args) {
    int[] temp=new  int[3];
    Arrays.sort(temp);
    System.out.println(temp[2]);
    Map<String,Integer> tests=new LinkedHashMap<>();
    tests.put("1",2);
  }

}
