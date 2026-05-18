public class QuizHashTable {
    private static class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] table;
    private int size;

    public QuizHashTable(int capacity) {
            this.table = new Node[capacity];
            this.size = 0;
    }

    private int hash(String key) {
            return Math.abs(key.hashCode()) % table.length;
    }

    public void insert(String key, int value) {
        int index = hash(key);
        Node curr = table[index];
        Node prev = null;

        while(curr != null) {
            if(curr.key.equals(key)) {
                curr.value = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        if(prev == null) {
            table[index] = new Node(key, value);
        } else {
            prev.next = new Node(key, value);
        }
        size++;
    }

    public int search(String key) {
        int index = hash(key);
        Node curr = table[index];

        while(curr != null) {
            if(curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    public boolean remove(String key) {
        int index = hash(key);
        Node curr = table[index];
        Node prev = null;

        while(curr != null) {
            if(curr.key.equals(key)) {
                if(prev == null) {
                    table[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    class NotImplementedError extends Exception{
        public NotImplementedError(String message){
            super(message);
            System.out.println("Custom Not Implemented Error");
        }
    }
}
