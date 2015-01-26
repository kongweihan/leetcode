import java.util.*;

public class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int capacity;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity + 1);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return val;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            int val = map.get(key);
            map.remove(key);
            map.put(key, value);
        } else {
            map.put(key, value);
            if (map.size() == capacity + 1) {
                Iterator it = map.keySet().iterator();
                if (it.hasNext()) {
                    map.remove(it.next());
                }
            }
        }
    }
}
