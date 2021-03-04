package com.zhboy.syncronizedusedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * 关于类锁和对象锁参考文章
 * https://zhuanlan.zhihu.com/p/98145713
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        testSynchronized()
//        testSynchronized2()
//        testSynchronized3()
        testSynchronized4()
    }

    /**
     * 静态方法加锁（对象锁）
     * 多个线程使用同一实例
     */
    fun testSynchronized(){
        val ticket = Ticket()
        val t1 = Thread(ticket, "窗口1")
        val t2 = Thread(ticket, "窗口2")
        t1.start()
        t2.start()
    }

    /**
     * 静态方法加锁（对象锁）
     * 不同线程，使用不同实例
     */
    fun testSynchronized2(){
        val ticket = Ticket()
        val t1 = Thread(ticket, "窗口1")

        val ticket2 = Ticket()
        val t2 = Thread(ticket2, "窗口2")
        t1.start()
        t2.start()
    }

    /**
     * 静态方法加锁（类锁）
     * 多个线程使用同一个实例对象
     */
    fun testSynchronized3(){
        val ticket = Ticket()
        val t1 = Thread(ticket, "窗口1")
        val t2 = Thread(ticket, "窗口2")
        t1.start()
        t2.start()
    }

    /**
     * 静态方法加锁（类锁）
     * 有多个实例对象
     */
    fun testSynchronized4(){
        val ticket = Ticket2()
        val t1 = Thread(ticket, "窗口1")

        val ticket2 = Ticket2()
        val t2 = Thread(ticket2, "窗口2")
        t1.start()
        t2.start()
    }
}