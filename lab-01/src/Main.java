import singletonPattern.EagerInitializedSingleton;

public class Main {
    public static void main(String[] args) {
        EagerInitializedSingleton instance1 = EagerInitializedSingleton.getInstance();
        System.out.println("instance1: " + instance1);
    }
}

