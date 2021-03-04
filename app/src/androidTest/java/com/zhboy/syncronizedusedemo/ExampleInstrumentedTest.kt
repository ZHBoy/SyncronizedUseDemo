package com.zhboy.syncronizedusedemo

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.zhboy.syncronizedusedemo", appContext.packageName)
    }
    /**
     * 测试同一个对象
     */
    @Test
    fun testSynchronized() {
        val ticket = Ticket()
        val t1 = Thread(ticket, "窗口1")

        val ticket2 = Ticket()
        val t2 = Thread(ticket2, "窗口2")
        t1.start()
        t2.start()
    }

    /**
     * 测试同一个对象
     */
    @Test
    fun testSynchronized2() {

    }
}