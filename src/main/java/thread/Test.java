package thread;

import java.util.Date;

/**
 * @Author: huangzhentao
 * @Date: 2020/3/13 13:34
 */
public class Test {

  public static void main(String[] args) {
    MyBlockingQueue blockingQueue=new MyBlockingQueue( 0);
    Consumer consumer=new Consumer(blockingQueue,"consumer1");
    Consumer consumer2=new Consumer(blockingQueue,"consumer2");
    Producer producer=new Producer(blockingQueue,0,"producer1");
    Producer producer2=new Producer(blockingQueue,10,"producer2");
//    consumer.start();
    consumer2.start();
    producer.start();
    producer2.start();

  }

}
class Producer extends Thread{
  MyBlockingQueue myBlockingQueue;
  public int limit=0;
  @Override
  public void run(){
    for(int i=limit;i<limit+20;i++){
      try {
        myBlockingQueue.put(i);
        System.out.println("threadNumber:"+currentThread().getName()+"put:"+i +"time:"+new Date());

//        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  public Producer(MyBlockingQueue blockingQueue,int limit,String name ){
    this.limit=limit;
    this.myBlockingQueue=blockingQueue;
    this.setName(name);
  }

}
class Consumer extends Thread{
  MyBlockingQueue myBlockingQueue;
  @Override
  public void run(){
//    while (true){
      try {
        Thread.sleep(1000);
        System.out.println("ThreadNumber:"+currentThread().getName()+"take:"  + myBlockingQueue.take()+":time"+new Date());

      } catch (Exception e) {
        e.printStackTrace();
      }
//    }
  }
  public Consumer(MyBlockingQueue myBlockingQueue,String name){
    this.myBlockingQueue=myBlockingQueue;
    this.setName(name);
  }
}