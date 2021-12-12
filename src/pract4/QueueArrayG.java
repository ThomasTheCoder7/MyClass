package pract4;

import java.lang.reflect.Array;

public class QueueArrayG<T>{
    int capacity;
    int front = 0;
    int rear = -1;
    int nElems = 0;
    T[] a;
    public QueueArrayG(Class c, int s) {
        capacity = s;
        front = 0;
        rear = -1;
        nElems = 0;
        a = (T[]) Array.newInstance(c,s);
    }
    public void enqueue(T value) {
        rear = (rear + 1) % a.length;
        a[rear] = value;
        nElems++;
    }
    public T dequeue() {
        T temp = a[front];
        front = (front + 1) % a.length;
        nElems--;
        return temp;
    }
    public boolean isEmpty() {
        return (nElems == 0);
    }
    public boolean isFull() {
        return (nElems == a.length);
    }
    public int size() {
        return nElems;
    }
}

