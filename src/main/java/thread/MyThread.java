package thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: huangzhentao
 * @Date: 2020/3/13 15:43
 */
public class MyThread extends Thread {
 MyLatch latch;

  @Override
  public void run() {
    System.out.println("before");
    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName());
  }

  public MyThread(MyLatch latch){
    this.latch=latch;
  }
  public static void main(String[] args) throws InterruptedException {
    int num=5;
    MyLatch latch=new MyLatch(1);
    MyThread[] temp=new MyThread[num];
    for(int i=0;i<num;i++){
     temp[i]=new MyThread(latch);
       temp[i].start();
    }
 latch.countDown();

    System.out.println("imain ");
  }
}
