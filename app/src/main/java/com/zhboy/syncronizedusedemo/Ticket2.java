package com.zhboy.syncronizedusedemo;

/**
 * @author: zhou_hao
 * @date: 2021/3/4
 * @description:
 **/
public class Ticket2 implements Runnable {
    private static int ticket = 10;

    @Override
    public void run() {
        method2();
    }

    /**
     *
     * 类锁是加载类上的，而类信息是存在 JVM 方法区的，并且整个 JVM 只有一份，方法区又是所有线程共享的，所以类锁是所有线程共享的。
     */
    private static synchronized void method2() {
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
