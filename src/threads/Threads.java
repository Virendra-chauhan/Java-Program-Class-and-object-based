package threads;

public class Threads extends Thread{

    // 1.Performing single task from single thread...

    /*

    @Override
    public void  run(){
        System.out.println("Single Thread.");
    }

    public static void main(String[] args){
        Threads t1 = new Threads();
        t1.start();
    }

     */

    // 2. Performing single task from multiple threads...

    /*
    @Override
    public void run(){
        System.out.println("Single task by multiple threads.");
    }

    public static void main(String[] args){
        Threads t1 = new Threads();
        t1.start();
        Threads t2 = new Threads();
        t2.start();
    }

     */

    // 3. performing multiple task from single thread...
    // it is not possible.

    /*
    @Override
    public void run(){
        System.out.println("Hello");
    }

    public void run(){
        System.out.println("Hello");
    }

    public static void main(String[] args){
        Thread t1 = new Threads();
        t1.start();
    }

     */


    // 4. performing multiple task from multiple thread...

    @Override
    public void run(){
        System.out.println("Hello ");
        System.out.println(Thread.currentThread());

        for (int i = 0; i < 5; i++) {
           System.out.println("Hello " + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            try{
//                Thread.sleep(1200);
//            }catch (Exception e){
//                System.out.println(e.getMessage());
//            }
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("World ");
        System.out.println(Thread.currentThread());
    }
}

class MyExample extends Thread{
    @Override
    public void run(){
        System.out.println("!");
        System.out.println(Thread.currentThread());
    }

    public static void main(String[] args){
        Threads t1 = new Threads();
        t1.start();
        try{
            System.out.println("Thread 11");
            t1.join(90000);
            System.out.println("Thread 1");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        MyThread t2 = new MyThread();
        t2.start();
        MyExample t3 = new MyExample();
        System.out.println(t3.isAlive());
        t3.start();
        System.out.println(t3.isAlive());
        System.out.println(Thread.currentThread());
    }
}
