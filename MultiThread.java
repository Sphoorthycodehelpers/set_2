import java.util.*;

class Thread1 extends Thread {
    static int num;

    public void run() {
        for (int i = 0; i < 10; i++) {
            Thread2 t2 = new Thread2();
            Thread3 t3 = new Thread3();
            Random r = new Random();
            num = r.nextInt(100);
            System.out.print(num + "-->");
            if (num % 2 == 0) {
                t2.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            } else {
                t3.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

class Thread2 extends Thread {
    public void run() {
        System.out.println(Thread1.num * Thread1.num);
    }
}

class Thread3 extends Thread {
    public void run() {
        System.out.println(Thread1.num * Thread1.num * Thread1.num);
    }
}

class MultiThread {
    public static void main(String ar[]) {
        Thread1 t1 = new Thread1();
        t1.start();
    }
}
