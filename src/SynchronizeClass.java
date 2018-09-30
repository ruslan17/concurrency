public class SynchronizeClass {

    public static void main(String[] args) throws InterruptedException {

        Resource resource = new Resource();
        resource.setI(5);

        MyThreadd thread1 = new MyThreadd();
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

    public void changeI() {
        int i = this.i;

        if (Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }

        i++;
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
