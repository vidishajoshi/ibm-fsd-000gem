package comm.example;

import java.util.Vector;

class Producer implements Runnable {

    private final Vector<Integer> sharedQueue;
    private final int SIZE;

    public Producer(Vector<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println("Produced: " + i);
            try {
                produce(i);
            } catch (InterruptedException ex) {
             
            }

        }
    }

    private  synchronized void produce(int i) throws InterruptedException {

        //wait if queue is full
        if(sharedQueue.size() == SIZE) {
          
                System.out.println("Queue is full " + Thread.currentThread().getName()
                                    + " is waiting , size: " + sharedQueue.size());

                wait();
            }
        

        
            sharedQueue.add(i);
            notifyAll();
        }
    }


