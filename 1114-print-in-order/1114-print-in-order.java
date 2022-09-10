class Foo {

    Semaphore sempahore1;
    public Foo() {
        sempahore1 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        sempahore1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(!sempahore1.tryAcquire(1));
        printSecond.run();
        sempahore1.release(2);
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        while(!sempahore1.tryAcquire(2));
        printThird.run();
    }
}