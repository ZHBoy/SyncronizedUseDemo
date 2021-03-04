package com.zhboy.syncronizedusedemo;

/**
 * @author: zhou_hao
 * @date: 2021/3/4
 * @description:
 **/
public class Ticket implements Runnable {
    private  int ticket = 10;

    @Override
    public void run() {
        method();
    }

    /**
     * 类锁是所有线程共享的锁，所以同一时刻，只能有一个线程使用加了锁的方法或方法体，不管是不是同一个实例
     * 使用对象锁的情况，只有使用同一实例的线程才会受锁的影响，多个实例调用同一方法也不会受影响。
     */
    private synchronized void method() {

        while (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在买票" + ticket--);
        }
    }

}
