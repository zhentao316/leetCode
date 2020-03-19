package thread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: huangzhentao
 * @Date: 2020/3/13 13:28
 */
public class MyBlockingQueue {
  int limit;
  Queue<Integer> queue;
  public MyBlockingQueue(int limit){
    this.limit=limit;
    queue=new ArrayDeque();
  }
  public synchronized void  put(int num) throws InterruptedException {
    while (queue.size()==limit){
      System.out.println("threadNumber:"+Thread.currentThread().getName()+" put waiting before size:"+queue.size());

      wait();
      System.out.println("threadNumber:"+Thread.currentThread().getName()+" put waiting after size:"+queue.size());
    }
    queue.offer(num);
    notifyAll();
  }
  public synchronized  int take() throws InterruptedException {
//    while (queue.size()==0){
//      System.out.println("threadNumber:"+Thread.currentThread().getName()+" take waiting before size:"+queue.size());
//      wait();
//      System.out.println("threadNumber:"+Thread.currentThread().getName()+" take waiting after size:"+queue.size());
//    }
//   int temp=  queue.poll();
    notifyAll();
//    return temp;
    return 0;
  }

}
