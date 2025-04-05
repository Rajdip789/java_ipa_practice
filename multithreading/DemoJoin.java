package multithreading;

class NewThread implements Runnable {
    
    String name;
    Thread t;

    NewThread(String threadname) {
        name = threadname;
        t = new Thread(this, name);

        System.out.println("New thread: " + t);

        t.start();
    }

    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        
        System.out.println(name + " exiting.");
    }
}

class DemoJoin {
    public static void main(String args[]) {
       
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");
        NewThread ob3 = new NewThread("Three");
        
        System.out.println("Thread One is alive: " + ob1.t.isAlive());  // true for all
        System.out.println("Thread Two is alive: " + ob2.t.isAlive());
        System.out.println("Thread Three is alive: " + ob3.t.isAlive());
       
        // Using join() to wait for threads to finish.
        try {
            System.out.println("Waiting for threads to finish.");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        // This lines of main thread will be executed only after all the threads are finish
        System.out.println("Thread One is alive: " + ob1.t.isAlive());  // false for all
        System.out.println("Thread Two is alive: "  + ob2.t.isAlive());
        System.out.println("Thread Three is alive: " + ob3.t.isAlive());
        
        System.out.println("Main thread exiting.");
    }
}