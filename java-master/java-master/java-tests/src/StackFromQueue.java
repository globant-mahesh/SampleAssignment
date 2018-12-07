import java.util.LinkedList;
import java.util.Queue;

public class StackFromQueue {

    Queue<Integer> queue = new LinkedList<Integer>();


    void push(int value) {
        queue.add(value);

        for (int i=0;i<queue.size()-1;i++) {
            queue.add(queue.remove());
        }
    }

    void printValues() {

        System.out.println("Values in the stack are ");

        for (Integer i:queue) {
            System.out.println(i);
        }
    }

    void pop () {
        System.out.println("Element removed from the stack is "+queue.remove());
    }

    public static void main(String args[]) {
        StackFromQueue stQ = new StackFromQueue();
        stQ.push(20);
        stQ.push(10);
        stQ.pop();
        stQ.push(30);
        stQ.push(50);
        stQ.push(60);
        stQ.pop();

        stQ.printValues();

    }

}
