package design.datastructures;

import java.util.LinkedList;

class HashNode<K, V> {
    private K key;
    private V value;

    HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

public class CustomHashMap<K, V> {
    LinkedList<HashNode<K, V>>[] buckets;
    private int bucketSize = 16;

    CustomHashMap(int bucketSize) {
        this.bucketSize = bucketSize;
        buckets = new LinkedList[bucketSize];
    }

    CustomHashMap() {
        buckets = new LinkedList[bucketSize];
    }

    public void add(K key, V value) {
        int hash = key.hashCode() % bucketSize;

        if(buckets[hash] == null)
            buckets[hash] = new LinkedList<>();

//        buckets[hash].add
    }
}
