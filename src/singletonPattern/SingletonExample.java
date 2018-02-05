package singletonPattern;

public class SingletonExample {
    private static SingletonExample ourInstance = new SingletonExample();

    public static SingletonExample getInstance() {
        return ourInstance;
    }

    private SingletonExample() {
    }
}
