public class First {

    public static void main(String[] args) {
        // Using extends Thread
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println(
                Thread.currentThread().getName());

        // Using Runnable
        Runnable runnable = new MyThread2();
        Thread thread = new Thread(runnable);
        thread.start();

        // Using anon class
        Runnable runnable1
                = () -> System.out.println("OK");
        Thread thread1 = new Thread(runnable1);
    }

}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("New thread");
        Thread.currentThread().setName("My thread");
        System.out.println(
                Thread.currentThread().getName());
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
        Thread.currentThread().setName("My thread 2");
        System.out.println(
                Thread.currentThread().getName());
    }
}
