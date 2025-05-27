// Approach 1: Extending the Thread class
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Message " + i);
            try {
                Thread.sleep(500); // Simulate work by pausing the thread for 500ms
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ThreadCreationExample {
    public static void main(String[] args) {
        // Create two threads
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        
        // Start the threads
        thread1.start();
        thread2.start();
    }
}
