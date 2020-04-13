import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: huangzhentao
 * @Date: 2020/3/14 10:45
 */
public class Frog {

  public static void main(String[] args) {
    int[][] edges={{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
    Frog frog=new Frog();
    System.out.println( frog.frogPosition(7,edges,2,4));
  }
  public double frogPosition(int n, int[][] edges, int t, int target) {
    Set<Integer> used =new HashSet<>();
    Node node1=new Node(1);
    double result=1.0;
   Set<Integer> recycle=new HashSet<>();
   recycle.add(1);
    HashMap<Integer ,Node> nodeMaps=new HashMap<>();
    nodeMaps.put(1,node1);
    Node targetNode=null;
    while (count(edges)!=0){
      Set<Integer> temps=new HashSet<>();
      for (int i=0;i<edges.length;i++){
        if(recycle.contains(edges[i][0])){
           temps.add(edges[i][1]);
           Node temp=new Node(edges[i][1]);
           temp.parent=nodeMaps.get(edges[i][0]);
          nodeMaps.get(edges[i][0]).nodes.add(temp);
          nodeMaps.put(edges[i][1],temp);
          edges[i][0]=0;
          edges[i][1]=0;
        }
        if(recycle.contains(edges[i][1])){
          temps.add(edges[i][0]);
          Node temp=new Node(edges[i][0]);
          temp.parent=nodeMaps.get(edges[i][1]);
          nodeMaps.get(edges[i][1]).nodes.add(temp);
          nodeMaps.put(edges[i][0],temp);
          edges[i][0]=0;
          edges[i][1]=0;
        }
      }
      recycle=temps;
    }
    targetNode=nodeMaps.get(target);
    if(targetNode==null){
      return 0;
    }
    while(targetNode.parent!=null){
      t--;
      targetNode=targetNode.parent;
      result/=targetNode.nodes.size();
    }
    if(t<0){
      return 0.0;
    }
    if(t>0&&targetNode.nodes.size()!=0){
      return 0.0;
    }
    return result;

  }
  private int count(int[][] edges){
    int count=0;
    int index=0;
    while (index<edges.length){
      if(edges[index][0]!=0){
      count++;}
      index++;
    }
    return count;
  }
}


class Node{
  int value;

  Node left;
  Node right;
  Node parent;
  List<Node> nodes=new ArrayList<>();
  public Node(int value){
    this.value=value;
  }
}