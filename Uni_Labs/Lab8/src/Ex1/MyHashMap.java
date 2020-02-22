package Ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class MyHashMap<K extends Comparable<K>, V> implements Iterable<K> {

    private class Entry {
        private K key;
        private V value;

        Entry(final K newKey, final V newValue) {
            this.key = newKey;
            this.value = newValue;
        }
    }

    private ArrayList<Entry> entries = new ArrayList<>();

    public void put(final K key, final V value) {
        boolean keyFound = false;

        for (Entry e : entries) {
            if (e.key.equals(key)) {
                e.value = value;
                keyFound = true;
                break;
            }
        }

        if (!keyFound) {
            entries.add(new Entry(key, value));

            Collections.sort(entries, new Comparator<Entry>() {
                @Override
                public int compare(final Entry e1, final Entry e2) {
                    return e1.key.compareTo(e2.key);
                }
            });
        }
    }

    public V get(final K key) {
        V value = null;

        for (Entry e : entries) {
            if (e.key.equals(key)) {
                value = e.value;
                break;
            }
        }
        return value;
    }

    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index != entries.size();
            }

            @Override
            public K next() {
                K key = entries.get(index).key;
                index++;
                return key;
            }

            @Override
            public void remove() {
                // lasat neimplementat
            }
        };
    }

    public String toString() {
        String str = "[ ";

        for (Entry e : entries) {
            str += '(' + e.key.toString() + ", " + e.value.toString() + ") ";
        }

        str += "]\n";

        return str;
    }
}
