package algo.hashmap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
public class CustomHashMap {

    private int bucketSize;
    private LinkedList<KeyValue>[] elements;

    CustomHashMap() {
        bucketSize = 16;
        elements = new LinkedList[bucketSize];
    }

    public void add(String key, Integer value) {
        int position = getHash(key);
        List<KeyValue> list = new LinkedList<KeyValue>();

        try {
            if (elements[position] != null) {
                for (KeyValue element : elements[position]) {
                    // If the key already exists throw an error
                    if (element.getKey().equals(key)) throw new DuplicateKeyException();
                }
                // If the key has the same hashcode, add to the linked list
                elements[position].add(new KeyValue(key, value));
            }
            else {
                // Create a new KeyValue instance
                list.add(new KeyValue(key, value));
                elements[position] = (LinkedList) list;
            }
        } catch(DuplicateKeyException e) {
        System.out.printf("The key '%s' already exists in the HashMap \n", key);
        }

    }

    public Integer getValue(String key) {
        try {
            int position = getHash(key);
            if (elements[position] == null) throw new KeyNotFoundException();
            for (KeyValue element : elements[position]) {
                if (element.getKey().equals(key)) return element.getValue();
            }
            throw new KeyNotFoundException();
        } catch (KeyNotFoundException e) {
            System.out.printf("The key '%s' is not present in the HashMap \n", key);
        }
        return null;
    }

    public void remove(String key) {
        try{
            int position = getHash(key);
            if (elements[position] == null) throw new KeyNotFoundException();
            if (elements[position].size() == 1) elements[position] = null;
            else {
                for (KeyValue element: elements[position]) {
                    if (element.getKey().equals(key)) elements[position].remove(element);
                }
            }
        } catch (KeyNotFoundException e) {
            System.out.printf("You tried to remove '%s', but it is not present in the HashMap \n", key);
        }
    }

    public void clearAll() {
        this.elements = new LinkedList[bucketSize];
    }

    private int getHash(String key) {
        return Math.abs(key.hashCode() % bucketSize);
    }

    @Override
    public String toString() {
        return "CustomHashMap{" +
                "bucketSize=" + bucketSize +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
