//1. Linked List Implementation (Dynamic Size)

public class LinkedQueue {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Add an element to the rear: O(1)
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Remove and return the front element: O(1)
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int removedData = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // Reset rear when the queue becomes empty
        }
        size--;
        return removedData;
    }

    // View the front element without removing it: O(1)
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());    // Output: 10
        System.out.println("Dequeued: " + queue.dequeue());      // Output: 10
        System.out.println("New front: " + queue.peek());        // Output: 20
        System.out.println("Queue size: " + queue.getSize());    // Output: 2
    }
}



// 2. Circular Array Implementation (Fixed Size)
public class ArrayQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Add an element to the rear: O(1)
    public void enqueue(int data) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size++;
    }

    // Remove and return the front element: O(1)
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int removedData = arr[front];
        front = (front + 1) % capacity;
        size--;
        return removedData;
    }

    // View the front element without removing it: O(1)
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);

        System.out.println("Dequeued: " + queue.dequeue()); // Output: 100
        queue.enqueue(400);                                 // Wraps around cleanly
        System.out.println("Front element: " + queue.peek()); // Output: 200
    }
}

//3. Java Built-in Queue Interface
import java.util.ArrayDeque;
import java.util.Queue;

public class BuiltInQueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(10); // Enqueue (returns false instead of throwing if full)
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue.peek()); // Output: 10
        System.out.println(queue.poll()); // Dequeue -> Output: 10
        System.out.println(queue);        // Output: [20, 30]
    }
}

