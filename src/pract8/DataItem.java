package pract8;

/**
 * @(#) DataItem.java
 *
 * Data Item class used to demonstrate 'open addressing'
 * hash table with linear probing. Note for simplicity
 * the properties are declared as public and no
 * set/get methods have been provided.
 *
 *
 */
public class DataItem {
    private String key;
    private String info;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * Constructor to create instance of a DataItem
     *
     * @param   nkey  key value to identify data item
     * @param   ninfo info to store in data item
     */
    public DataItem(String nkey, String ninfo) {
        key = nkey;
        info = ninfo;
    }

    /**
     * Test if the supplied Object is an instance of a DataItem and its
     * key value is equal to the key value of the current DataItem.
     *
     * @param   anObject  object to test for equality
     * @return  true if equal and false otherwise
     */
    public boolean equals(Object anObject) {
        if ((anObject != null) && (anObject instanceof DataItem)) {
            DataItem d = (DataItem)anObject;
            return key.equals(d.key);
        }
        return false;
    }

    /**
     * Return a printable representation of a DataItem
     *
     * @return String representation of a DataItem.
     */
    public String toString() {
        return "(Key:"+key+", Info:"+info + ")";
    }

}

