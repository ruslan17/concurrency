import java.util.Collections;

public class SynchronizeClass {

    public static void main(String[] args) throws InterruptedException {

        Resource resource = new Resource();
        resource.setI(5);

        MyThreadd thread1 = new MyThreadd();
        thread1.setName("one");
        thread1.setResource(resource);
        thread1.start();

        MyThreadd thread2 = new MyThreadd();
        thread2.setResource(resource);
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(resource.getI());

    }
}

class MyThreadd extends Thread {

    private Resource resource;

    @Override
    public void run() {
        resource.changeI();
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

}

class Resource {

    private int i;

    static int j;

    public static void changeSynchI() {
        synchronized (Resource.class) {

        }
    }

    public void changeI() {

        synchronized (this) {
            int i = this.i;

            if (Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }

            i++;
            this.i = i;
        }



        /*
         * Thread 1:
         *  int i = this.i  --> i = 5;
         *
         * Thread 2:
         * int i = this.i  --> i = 5;
         * i++;
         * this.i = i;  --> i = 6;
         *
         *  Thread 1:
         *  i++;
         *  this.i = i;  --> i = 6;
         */
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
