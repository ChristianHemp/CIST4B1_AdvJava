public class DLLNode<T> {
    private T data;
    private DLLNode<T> next;
    private DLLNode<T> prev;

    public DLLNode(T data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return this.data;
    }

    public DLLNode<T> getNext() {
        return this.next;
    }

    public DLLNode<T> getPrev() {
        return this.prev;
    }

    public void setData(T newData) {
        this.data = newData;
    }

    public void setNext(DLLNode<T> node) {
        this.next = node;
    }

    public void setPrev(DLLNode<T> node) {
        this.prev = node;
    }
}
