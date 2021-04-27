package CoreJava.multithreading.basics;

class Sender {

  public synchronized void sendAgain(String msg) {
    System.out.println("Sending again\t" + msg);
    try {
      Thread.sleep(1000);
    } catch (Exception e) {
      System.out.println("Thread interrupted.");
    }
    System.out.println("\n" + msg + "Sent again");
  }

  public void send(String msg) {
    System.out.println("Sending\t" + msg);
    try {
      Thread.sleep(1000);
    } catch (Exception e) {
      System.out.println("Thread  interrupted.");
    }
    System.out.println("\n" + msg + "Sent");
  }
}

// Class for send a message using Threads
class ThreadedSend extends Thread {
  Sender sender;
  private String msg;

  // Recieves a message object and a string
  // message to be sent
  ThreadedSend(String m, Sender obj) {
    msg = m;
    sender = obj;
  }

  public void run() {
    // Only one thread can send a message
    // at a time.
    synchronized (sender) {
      // synchronizing the snd object
      sender.send(msg);
    }
  }
}

// Driver class
class SyncDemo {
  public static void main(String args[]) {
    Sender snd = new Sender();
    ThreadedSend S1 = new ThreadedSend(" Hi ", snd);
    ThreadedSend S2 = new ThreadedSend(" Bye ", snd);

    // Start two threads of ThreadedSend type
    S1.start();
    S2.start();

    // wait for threads to end
    try {
      S1.join();
      S2.join();
    } catch (Exception e) {
      System.out.println("Interrupted");
    }

    Sender send = new Sender();
    Runnable r =
        () -> {
          {
            send.sendAgain("Hello from synchronized method");
          }
        };

    Thread t1 = new Thread(r);
    Thread t2 = new Thread(r);
    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch (Exception e) {
      System.out.println("Interrupted");
    }
  }
}
