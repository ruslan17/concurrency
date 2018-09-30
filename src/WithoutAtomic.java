public class WithoutAtomic {

    static int i;

    public static void main(String[] args) throws InterruptedException {

        for (int j = 0; j < 10_000; j++) {
            new MyThread().start();
        }

        Thread.sleep(5000);
        System.out.println(i);

    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            i++;


            /* Thread 1:
                int k = i + 1
                i = k;
             */

        }
    }

}
