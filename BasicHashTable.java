public class BasicHashTable {
    private HTEntry[] table;
    private int size;
    private double loadFactor;  // size / table.length (not integer division)

    public BasicHashTable(int capacity) {
        table = new HTEntry[capacity];
        size = 0;
        loadFactor = 0;
    }

    private int hash(String key) {
        // bad hash function

        int hashValue = 0;
        for(int i = 0; i < key.length(); i++) {
            hashValue += key.charAt(i);
        }
        // Just use key.hashCode();
        return Math.abs(hashValue % table.length);
    }

    private int hash2(String key) {
        return Math.abs(key.hashCode());
    }

    // resize when load factor is greater than 0.7
    // create the new array
    // rehash every item from our old array to our new one
    private void resize(int newSize) {
        HTEntry[] originalTable = table;
        table = new HTEntry[newSize];
        for(HTEntry e : originalTable) {
            if(e != null && !e.value.equals("DELETED")) {
                put(e.key, e.value);
            }
        }
        loadFactor = (double) size / table.length;
    }


    // add
    public void put(String key, Object value) {
        // check for room to add

        if (loadFactor > 0.7) {
            resize(size * 2);
        }

        if (value.equals("DELETED")) {
            System.err.println("Don't enter a DELETED value");
            return;
        }

        // get the hash index based on key
        int index1 = hash(key);
        int index2 = hash2(key);
        int startIndex = index1;
        int i = 0;


        // check hash index: if not occupied insert
        // if occupied, probe to next valid location and repeat
        // also stop early if we return to the start index

        while(table[index1] != null && !table[index1].deleted) {
            // if we find key again, overwrite value at that position

            if(table[index1].key.equals(key)) {
                table[index1].value = value;
                return;
            }

            // index1 = (index1 + 1) % table.length;     // linear probe

            index1 = (startIndex + i * index2) % table.length;      // double hashing, helps with clustering
            i++;

            if(index1 == startIndex) {
                System.err.println("No empty slot");
                return;
            }
        }

        table[index1] = new HTEntry(key, value);
        size++;
        loadFactor = (double) size / table.length;

    }
    // lookup

    public Object get(String key) {
        // get hash index based on key
        int index = hash(key);
        int originalIndex = index;

        // loop: while key not found and not null -> probe to next location
        while(table[index] != null) {
            if(!table[index].value.equals("DELETED") && table[index].key.equals(key)) {
                // if key found return value, if null, return null
                return table[index].value;
            }

            // circular probing, eventually goes back to first index if not found
            index = (index + 1) % table.length;

            if(index == originalIndex) {
                return null;
            }
        }
        return null;
    }

    // remove
    public void remove(String key) {
        int index = hash(key);
        int originalIndex = index;

        while(table[index] != null) {
            if(!table[index].value.equals("DELETED") && table[index].key.equals(key)) {
                // if key found return value, if null, return null
                table[index].value = "DELETED";
                loadFactor = (double) size / table.length;
                size--;
                break;
            }

            // circular probing, eventually goes back to first index if not found
            index = (index + 1) % table.length;

            if(index == originalIndex) {
                break;
            }
        }
    }
}
