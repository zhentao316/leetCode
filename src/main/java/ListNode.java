import java.util.Stack;

/**
 * @Author: huangzhentao
 * @Date: 2020/2/24 15:52
 */
public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }

  public static void main(String[] args) {

  }

  public static  void middleOrder(Node root){
    Node currentNode=root;
    Stack<Node> stack=new Stack<>();
    while (currentNode!=null||!stack.isEmpty()){
      while (currentNode!=null){
        stack.push(currentNode);
        currentNode=currentNode.left;
      }
      if(!stack.isEmpty()){
        currentNode=stack.pop();
        System.out.println(currentNode.value);
        currentNode=currentNode.right;
      }
    }
  }
  public static  void preOrder(Node root){
    Node currentNode=root;
    Stack<Node> stack=new Stack<>();
    while (currentNode!=null||!stack.isEmpty()){
      while (currentNode!=null){
        System.out.println(currentNode.value);
        stack.push(currentNode);
        currentNode=currentNode.left;
      }
      if(!stack.isEmpty()){
        currentNode=stack.pop();
        currentNode=currentNode.right;
      }
    }
  }
}
