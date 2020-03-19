package thread;

/**
 * @Author: huangzhentao
 * @Date: 2020/3/13 15:40
 */
public class MyLatch {
public int count=0;
public synchronized void await() throws InterruptedException {
 while (count>0){
     wait();
 }
}
public synchronized  void countDown(){
  count--;
  System.out.println(count);
  if (count<=0){
    System.out.println("xxxx");
    notifyAll();
  }
}
public MyLatch(int count){
  this.count=count;
}

}
