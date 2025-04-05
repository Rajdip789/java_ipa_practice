package multithreading;

class Table {
    // By making this method synchronized we ensure that, only one thread can access
    // this method at a time
    // means no concurrent access
    synchronized void printTable(int n) {

        for (int i = 1; i <= n; i++) {

            System.out.println(n + "x" + i + " = " + n * i);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class Mythread1 extends Thread {

    Table t;

    Mythread1(Table x) {
        t = x;
    }

    public void run() {
        t.printTable(5);
    }
}

class Mythread2 extends Thread {

    Table t;

    Mythread2(Table x) {
        t = x;
    }

    public void run() {
        t.printTable(8);
    }
}

class ThreadSync {
    public static void main(String args[]) {
        Table obj = new Table();

        Mythread1 th1 = new Mythread1(obj);
        Mythread2 th2 = new Mythread2(obj);

        th1.start();
        th2.start();
    }
}