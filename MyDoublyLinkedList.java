public class MyDoublyLinkedList<T> {
    private DLLNode<T> head;
    private DLLNode<T> tail;
    private int length;

    public MyDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void append(T data) {
        // Only checks head since tail is null if head is null.
        if(this.head == null) {
            DLLNode<T> newNode = new DLLNode<>(data);
            this.head = newNode;
            this.tail = newNode;
            this.length++;
            return;
        }

        // Creates new pointers to and from tail, then updates tail and length.
        DLLNode<T> newNode = new DLLNode<>(data);
        this.tail.setNext(newNode);
        newNode.setPrev(this.tail);
        this.tail = newNode;
        length++;
    }


    public void prepend(T data) {
        if(this.head == null) {
            DLLNode<T> newNode = new DLLNode<>(data);
            this.head = newNode;
            this.tail = newNode;
            this.length++;
            return;
        }

        // Creates new pointers to and from head, then updates head and length.
        DLLNode<T> newNode = new DLLNode<>(data);
        this.head.setPrev(newNode);
        newNode.setNext(this.head);
        this.head = newNode;
        this.length++;
    }

    public void insertAt(int index, T data) {
        if(this.length == 0 || index > this.length) {
            System.err.println("Out of list bounds");
        }

        if(index == 0) {
            prepend(data);
            return;
        } else if(index == this.length) {
            append(data);
            return;
        }

        // Initialize new node and helper variables.
        DLLNode<T> newNode = new DLLNode<>(data);
        DLLNode<T> curr;
        int currIndex;

        if(index * 2 < this.length) {
            curr = this.head;
            currIndex = 0;

            // Traverses to index before desired insertion index.
            while(currIndex + 1 != index) {
                curr = curr.getNext();
                currIndex++;
            }

            // Updates pointers without losing any nodes.
            curr.getNext().setPrev(newNode);
            newNode.setNext(curr.getNext());
            curr.setNext(newNode);
            newNode.setPrev(curr);
        } else {
            curr = this.tail;
            currIndex = this.length;

            // Traverses to index after desired insertion index.
            while(currIndex - 1 != index) {
                curr = curr.getPrev();
                currIndex--;
            }

            // Updates pointers without losing any nodes.
            curr.getPrev().setNext(newNode);
            newNode.setPrev(curr.getPrev());
            curr.setPrev(newNode);
            newNode.setNext(curr);
        }
        this.length++;
    }


    public T removeValue(T target) {
        // Handles lists of length 0 and 1 separately to prevent NullPointerException.
        if(this.length == 0) {
            System.err.println("Cannot remove from an empty list");
            return null;
        } else if(this.length == 1 && this.head.getData().equals(target)) {
            T returnData = this.head.getData();

            this.head = null;
            this.tail = null;

            this.length--;
            return returnData;
        } else if(this.length == 1 && !this.head.getData().equals(target)) {
            System.err.println("Value not in this list");
            return null;
        }

        // Handles head and tail removals
        if(this.head.getData().equals(target)) {
            DLLNode<T> newHead = this.head.getNext();
            T returnData = this.head.getData();

            this.head.setNext(null);
            newHead.setPrev(null);
            this.head = newHead;

            this.length--;
            return returnData;
        } else if(this.tail.getData().equals(target)) {
            DLLNode<T> newTail = this.tail.getPrev();
            T returnData = this.tail.getData();

            this.tail.setPrev(null);
            newTail.setNext(null);
            this.tail = newTail;

            this.length--;
            return returnData;
        }

        DLLNode<T> curr = this.head;
        while(curr.getNext() != null) {
            if(curr.getData().equals(target)) {
                curr.getPrev().setNext(curr.getNext());
                curr.getNext().setPrev(curr.getPrev());

                this.length--;
                return curr.getData();
            }
            curr = curr.getNext();
        }
        if(curr.getData().equals(target)) {
            curr.getPrev().setNext(curr.getNext());
            curr.getNext().setPrev(curr.getPrev());

            this.length--;
            return curr.getData();
        }
        return null;
    }

    public void set(int index, T data) {
        if(this.length == 0 || index > this.length) {
            System.err.println("Out of list bounds");
            return;
        }

        if(index == 0) {
            this.head.setData(data);
        } else if(index == this.length) {
            this.tail.setData(data);
        }

        DLLNode<T> curr;
        int currIndex;

        if(index * 2 < this.length) {
            curr = this.head;
            currIndex = 0;

            // Traverses to desired index starting from head.
            while(currIndex != index) {
                curr = curr.getNext();
                currIndex++;
            }

            curr.setData(data);
        } else {
            curr = this.tail;
            currIndex = this.length;

            // Traverses to desired index starting from tail.
            while(currIndex != index) {
                curr = curr.getPrev();
                currIndex--;
            }

            curr.setData(data);
        }
    }

    public void print() {
        // Traverses to second to last node printing at each step, then prints final node.
        DLLNode<T> curr = this.head;
        while(curr.getNext() != null) {
            System.out.print(curr.getData() + " <-> ");
            curr = curr.getNext();
        }
        System.out.println(curr.getData());
    }

    public String toString() {
        DLLNode<T> curr = this.head;
        StringBuilder output = new StringBuilder();

        // Traverses entire list building output string each step.
        while(curr.getNext() != null) {
            output.append(curr.getData()).append(" <-> ");
            curr = curr.getNext();
        }
        output.append(curr.getData());

        return output.toString();
    }

    public int getLength() {
        return this.length;
    }
}
