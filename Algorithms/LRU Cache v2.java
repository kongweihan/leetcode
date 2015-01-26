import java.util.*;

public class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int capacity;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity + 1, 1.1f, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            return map.get(key);
        }
    }
    
    public void set(int key, int value) {
        map.put(key, value);
        if (map.size() == capacity + 1) {
            Iterator it = map.keySet().iterator();
            if (it.hasNext()) {
                map.remove(it.next());
            }
        }
    }
}
