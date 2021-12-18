package pract8;
/**
 * @(#) HashTableLinear.java
 *
 * HashTable implementation Using Open Addressing
 * and Linear Probing.
 *
 */

public class HashTableLinear {
    private DataItem[] hashArray; // array holds hash table
    private int nElems;           // number of elements in hashtable

    private static final int DEFAULT_SIZE = 11; // default size

    /**
     * Default Constructor Creates a Hash Table
     * of default size
     */
    public HashTableLinear() {
        this(DEFAULT_SIZE);
    }

    /**
     * Constructor to create Hash Table of specified size
     *
     * @param size size of hash table to create
     */
    public HashTableLinear(int size) {
        nElems = 0;
        hashArray = new DataItem[size];
        for (int i = 0; i < hashArray.length; i++) {
            hashArray[i] = null;
        }
    }

    /**
     * Hash function generates hash value from key
     *
     * @param key       key to hash
     * @param tableSize size of table key is generated for
     * @return hash value
     */
    public int hashFunc(String key, int tableSize) {
        int sum = 0;

        for (int i = 0; i < key.length(); i++) {
            sum = sum + (int) key.charAt(i);
        }
        return sum % tableSize;
    }



    public boolean isFull(){
        return nElems >= hashArray.length;
    }

    /**
     * Insert a DataItem into the hash table
     *
     * @param item dataitem to insert
     */
    public void insert(DataItem item) {
        int hashVal = hashFunc(item.getKey(), hashArray.length); // hash the key

        // loop until empty cell
            if(isFull()){
                System.out.println("Hash is already Full!");
                return;
            }
            while (hashArray[hashVal] != null) {
                hashVal++;                            // go to next cell
                hashVal = hashVal % hashArray.length; // wrap around if necessary
            }
        hashArray[hashVal] = item;              // insert item
        nElems++;                               // increase element count
    }


    /**
     * Delete DataItem from HashTable identified by specified key
     *
     * @return copy of deleted data item if found, otherwise null
     */
    public DataItem delete(String target) {
        int hashVal = hashFunc(target, hashArray.length); // hash the key
        int i = 0;
        // loop until empty cell
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey().equals(target)) { // if found key
                DataItem temp = hashArray[hashVal];       // save item
                hashArray[hashVal] = null;                // delete item
                nElems--;                       // decrease element count
                return temp;                    // return item
            }
            hashVal++;// go to next cell
            i++;
            hashVal = hashVal % hashArray.length; // wraparound if necessary
            if(i == nElems){
                return null;
            }
        }
        return null;                        // can't find item
    }


    /**
     * Search hash table for DataItem identifed by specifed key
     *
     * @return DataItem if found otherwise null
     */
    public DataItem find(String target) {
        int hashVal = hashFunc(target, hashArray.length); // hash the key
        int i = 0;
        // loop until empty cell,
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey().equals(target)) { // if found key
                return hashArray[hashVal];
            }
            hashVal++;                             // go to next cell
            hashVal = hashVal % hashArray.length;  // wraparound if necessary
            i++;
            if(i == nElems){return null;}
        }
        return null;                             // can't find item
    }

    /**
     * Provide printable representation of a hashtable
     *
     * @return String representation
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] == null) {
                buffer.append("empty\n");
            } else {
                buffer.append(hashArray[i] + "\n");
            }
        }
        return buffer.toString();
    }

    /**
     * Print Elements in HashTable to Console
     */
    public void print() {
        System.out.println(this.toString());
    }
}