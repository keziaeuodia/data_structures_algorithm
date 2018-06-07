package sample;

public class CustomHashMap<K, V> {

    private int DEFAULT_BUCKET_COUNT = 10;
    private int counter;

    private Entry<K, V>[] buckets;

    public CustomHashMap() {
        buckets = new Entry[DEFAULT_BUCKET_COUNT];
    }

    public CustomHashMap(int capacity) {
        buckets = new Entry[capacity];
    }

    public V get(K key) {
        throwIfKeyNull(key);
        Entry<K, V> entry = buckets[getKeyIndex(key)];
        while (entry != null && !key.equals(entry.getKey()))
            entry = entry.getNext();
        return entry != null ? entry.getValue() : null;
    }

    public void put(K key, V value) {
        throwIfKeyNull(key);

        if (counter >= (buckets.length * .75)){
            resize();
        }

        int bucketIndex = getKeyIndex(key);
        Entry<K, V> entry = buckets[bucketIndex];

        if (null != entry) {
            boolean done = false;

            while (!done) {
                if (key.equals(entry.getKey())) {
                    entry.setValue(value);
                    done = true;
                } else if (entry.getNext() == null) {
                    entry.setNext(new Entry<K, V>(key, value));
                    done = true;
                }
                entry = entry.getNext();
            }
        } else {
            // nothing there at all; just shove the new entry in
            buckets[bucketIndex] = new Entry<K, V>(key, value);
        }
        counter++;
    }

    public void remove(K key) {
        throwIfKeyNull(key);
        int i = getKeyIndex(key);
        Entry<K, V> entry = new Entry<K, V>(buckets[i].getKey(), buckets[i].getValue());
        if (entry == null) {
            return;}
        // if only one element is present in the list ,set the index to null
        if(entry.getKey().equals(key)){
            if (entry.getNext() == null){
                buckets[buckets.length] = null;
                return;
            }
        }


    }

    private void resize() {
        Entry<K, V>[] bucketsTemp = new Entry[buckets.length * 2];
        for(int i = 0; i < buckets.length; i++){
            bucketsTemp[i] = buckets[i];
        }
        buckets = bucketsTemp;
    }

    public int getKeyIndex(K key) {
        int bucketIndex = key.hashCode() % buckets.length;
        return bucketIndex;
    }

    private void throwIfKeyNull(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key may not be null");
        }
    }
}

