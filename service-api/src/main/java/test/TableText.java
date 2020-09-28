package test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.concurrent.*;

public class TableText {
    private static class RunnableTest implements Runnable{
        @Override
        public void run() {
            // System.out.println("---- execute work - " + Thread.currentThread().getId());
            // System.out.println(Thread.currentThread().getName());
            try {
                // 模拟耗时操作：使得新任务加入时，没有 free 的线程可用，也就不会执行加入 workQueue 的任务
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                // thread.setName("lxk-test-thread-" + thread.getId());
                System.out.println("create thread - " + thread.getId());
                return thread;
            }
        };
        int corePoolSize = 5;
        int maximumPoolSize = 10;
        BlockingQueue workerQueue = new ArrayBlockingQueue<>(1);
        long timeout = 1;
        ExecutorService threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, timeout, TimeUnit.MINUTES, workerQueue, factory);
        for(int i = 0; i < 3; ++i){
            System.out.println("第 " + (i + 1) + " 阶段");
            for (int j = 0; j < 6; j++) {
                threadPool.submit(new RunnableTest());
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
