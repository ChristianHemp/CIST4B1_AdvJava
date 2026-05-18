public class HTEntry {
    // key doiesnt have to be as tring
    // maybe use generics for value

    String key;
    Object value;
    boolean deleted;

    public HTEntry(String key, Object value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }
}
