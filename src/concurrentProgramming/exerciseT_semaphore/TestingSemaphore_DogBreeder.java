package concurrentProgramming.exerciseT_semaphore;

import java.util.concurrent.Semaphore;

public class TestingSemaphore_DogBreeder {
    public static void main(String[] args) {
        Semaphore[] bowlsSemaphores =
                new Semaphore[]{new Semaphore(1),
                        new Semaphore(1),
                        new Semaphore(1)};

        new Thread(new Breeder("Marco", bowlsSemaphores)).start();
        new Thread(new Breeder("Luisa", bowlsSemaphores)).start();

        for (int i = 1; i < 10; i++)
            new Thread(new Dog("Dog" + i, bowlsSemaphores)).start();
    }
}
