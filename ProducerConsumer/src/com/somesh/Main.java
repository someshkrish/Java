package com.somesh;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message {
    private String message;
    private boolean empty = true;
    public synchronized String read(){
        while(empty){
            try{
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message){
        while(!empty){
            try{
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}

class Writer implements Runnable {
    private Message message;

    Writer(Message message){
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {
                "Humpty Dumpty sat on the wall",
                "Humpty Dumpty had great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty Dumpty together again"
        };

        Random random = new Random();

        for (String s : messages) {
            message.write(s);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        message.write("Finished");
    }
}

class Reader implements Runnable {
    private Message message;

    Reader(Message message){
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();

        for(String latestMsg = message.read(); !latestMsg.equals("Finished"); latestMsg = message.read()){
            System.out.println(latestMsg);
            try{
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}













