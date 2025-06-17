package concurrentProgramming.exerciseR_blockingQueuePostOffice;

public class TestingBlockingQueue_PostOffice {
    public static void main(String[] args) {
        PostOffice postOffice = new PostOffice();
        (new Thread(new Postman(postOffice))).start();
        (new Thread(new Customer("Mrs Darbellay", postOffice))).start();
        (new Thread(new Customer("Mrs Müller", postOffice))).start();
    }
}
