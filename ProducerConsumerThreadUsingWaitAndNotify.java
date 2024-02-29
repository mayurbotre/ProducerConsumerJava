package MultiThreading;

import java.util.LinkedList;

public class ProducerConsumerThreadUsingWaitAndNotify {


    public static class ProducerConsumer {

        LinkedList<Integer> linkedList = new LinkedList<>();

        int capacity = 2;

        public void produce() throws InterruptedException{

            int value = 0;

            while(true){
                synchronized (this){
                    while(linkedList.size()==capacity){
                        wait();
                    }
                    System.out.println("Producer Produced - "+value);

                    linkedList.add(value++);

                    notify();

                    Thread.sleep(1000);

                }

            }

        }

        public void consume() throws InterruptedException {

            while(true){
                synchronized (this){

                    while(linkedList.size()==0){
                        wait();
                    }

                    int val = linkedList.removeFirst();

                    System.out.println("Consumer Consumed - "+ val);

                    notify();

                    Thread.sleep(1000);

                }
            }

        }


    }
}