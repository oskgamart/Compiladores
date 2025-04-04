import java.util.LinkedList;

public class Table<K,V> {

    private static class Entry<K, V>{
        K key;
        V value;

        Entry(K key,V value){
            this.key = key;
            this.value = value;
        }

    }

    private static final int CAPACITY = 10;
    private LinkedList<Entry<K, V>>[] table;

    //Constructor
    public Table(){
        table = new LinkedList[CAPACITY];
        for(int i=0; i<CAPACITY; i++){
            table[i] = new LinkedList<>();
        }

    }

    //hashear la key
    public int hash(K key){
        return Math.abs(key.hashCode() % CAPACITY);
    }
    
    //Agregar un elemento a la tabla
    public void put(K key, V value){
        int hashedKey = hash(key);
        Entry<K,V> entry = new Entry<>(key, value);
        int keyPosition = containsKey(key);
        //System.out.println(entry.key + " " + value + " " + hashedKey);
        if(keyPosition != -1){
            table[hashedKey].remove(keyPosition);
        }

        table[hashedKey].add(entry);

    }

    //Ver el valor del elemento con la key ingresada
    public V get(K key){
        int hashedKey = hash(key);
        //System.out.println("------------");
        int keyPosition = containsKey(key);
        //System.out.println("------------");
        if(keyPosition != -1){

            return table[hashedKey].get(keyPosition).value;
        
        }
        return null;
    }

    //quitar el elemento de la key correspondiente
    public void remove(K key){
        int hashedKey = hash(key);
        int keyPosition = containsKey(key);
        if(keyPosition != -1){
    
            table[hashedKey].remove(keyPosition);
            
        }else{
            throw new RuntimeException("Not a valid key!");
        }
    }

    //regresa la posición donde se encuentra la llave correspondiente
    public int containsKey(K key){
        int hashedKey = hash(key);
        for(int i=0; i<table[hashedKey].size(); i++){
            
            if(table[hashedKey].get(i).key.equals(key)){
                //System.out.println(i);
                return i;
            }
        }
        return -1;
    }
}
