public class MyStack<T> {
    private int capacity;
    private int currSize;
    private Object[] data;

    public MyStack(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
        this.currSize = 0;
    }

    public void push(T item) {
        if(currSize < capacity) {
            data[currSize] = item;
            currSize++;
        } else {
            Object[] newData = new Object[this.capacity * 2];
            for(int i = 0; i < this.capacity; i++) {
                newData[i] = this.data[i];
            }
            newData[this.currSize] = item;
            this.data = newData;
            this.capacity *= 2;
            this.currSize++;
        }
    }

    public T pop() {
        if(!this.isEmpty()) {
            currSize--;
            T returnValue = (T) data[currSize];
            data[currSize] = null;
            return returnValue;
        }
        System.out.println("Stack is empty");
        return null;
    }

    public T peek() {
        if(!this.isEmpty()) {
            return (T) data[currSize - 1];
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean isFull() {
        return currSize == capacity;
    }
}
