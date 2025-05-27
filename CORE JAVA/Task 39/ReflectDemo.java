import java.lang.reflect.*;

public class ReflectDemo {
    public void greet(String name) {
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("ReflectDemo");
        Method method = clazz.getDeclaredMethod("greet", String.class);
        method.invoke(clazz.getDeclaredConstructor().newInstance(), "Alice");
    }
}
