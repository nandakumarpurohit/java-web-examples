package com.demo;
import java.util.Vector;

public class VectorDemo {
    
    public static void main(String[] args) {
        Vector<String> v1 = new Vector<String>();
        Vector<String> v2 = new Vector<String>(25);
        v1.add("James");
        v1.add("John");
        v1.add("Smith");
        System.out.println(v1.size() + ":" + v1.capacity());
        
        v1.add("James");
        v1.add("John");
        v1.add("Smith");
        v1.add("James");
        v1.add("John");
        v1.add("Smith");
        v1.add("James");
        v1.add("John");
        v1.add("Smith");
        System.out.println(v1.size() + ":" + v1.capacity());
        
        
    }
}
