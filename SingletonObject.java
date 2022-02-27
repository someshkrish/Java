package com.company;

class SingletonMain{
    public static void main(String[] args) {
        SingletonObject obj = SingletonObject.getInstance();
        obj.printmsg();
    }
}

public class SingletonObject {
    private static SingletonObject object = new SingletonObject();
    private SingletonObject(){};
    public static SingletonObject getInstance(){
        return object;
    }
    public void printmsg(){
        System.out.println("Hai from singleton implementation of design patterns.");
    }
}
