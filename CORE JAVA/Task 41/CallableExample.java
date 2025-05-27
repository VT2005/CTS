import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> task = () -> {
            Thread.sleep(500);
            return "Result from " + Thread.currentThread().getName();
        };

        Future<String> future = executor.submit(task);
        System.out.println(future.get());

        executor.shutdown();
    }
}
