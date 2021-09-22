package PrepSetOne;

/**
 * [ Goo 98_01 ] [ Implement HashMap Using Array ]
 * ____________________________________________________________________________________________________________________
 */
public class _Goo_98_01_Implement_HashMapUsing_Array{
    private final static int TABLE_SIZE = 128;
    HashEntry[] table;

    public _Goo_98_01_Implement_HashMapUsing_Array() {
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    public int get(int key) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        if (table[hash] == null)
            return -1;
        else
            return table[hash].getValue();
    }

    public void put(int key, int value) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        table[hash] = new HashEntry(key, value);
    }

    public static void main(String[] args) {
        _Goo_98_01_Implement_HashMapUsing_Array map = new _Goo_98_01_Implement_HashMapUsing_Array();
        int key =100;//Key starting at 100
        //Inserting
        for(int i=0; i<10;i++){
            map.put(key++,i);
        }
        //Getting values from Map.
        for(int j=100; j<110;j++){
            System.out.println(map.get(j));
        }
    }
}

class HashEntry {
    private int key;
    private int value;

    HashEntry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}