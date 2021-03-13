package aut.ir;

/**
 * Created by mahdis on 1/20/2018.
 */
public class Queue {
    int front,rear;
    int[] q;
    int maxsize;
    public Queue(int maxsize){
        this.maxsize=maxsize;
        q=new int[maxsize];
        front=rear=-1;
    }
    public void add(int input){
        if(rear==maxsize-1){
            System.out.println("Queue is full");
        }
        else q[++rear]=input;

    }
    public int delete(){
        if(rear==front) return 0;
        return q[++front];
    }
    public boolean isEmpty(){
        return rear==front;
    }
}
