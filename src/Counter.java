import java.util.Scanner;


public class Counter extends Variables implements Runnable {

    public void run() {

        while (isCounting.get()){

            i.incrementAndGet();

//            System.out.println("COUNTER");
//            System.out.println(i.hashCode());
//            System.out.println(i);
//            System.out.println(isCounting);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if (!isCounting.get()){
                Thread.currentThread().interrupt();
                break;
            }

        }
    }
}

class Stopper extends Variables implements Runnable {

    Scanner input = new Scanner(System.in);

    public void run() {

        i.set(i.get());   // get er tilstrækkeligt

        while (true) {

            if (input.nextLine().equals("")) {


                isCounting.set(false);

                System.out.println(i.get());

//                System.out.println("-------------");
//                System.out.println("STOPPER");
//                System.out.println(i.hashCode());
//                System.out.println(isCounting);
//                System.out.println("-------------");

                break;


            } else {
                System.out.println("fuck");
            }

        }

    }

}


class Main {

    public static void main(String[] args) {

        Counter c = new Counter();
        Stopper s = new Stopper();
        Thread thread1 = new Thread(c);
        Thread thread2 = new Thread(s);

        thread1.start();
        thread2.start();


    }

}