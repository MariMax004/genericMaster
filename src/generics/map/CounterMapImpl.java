package generics.map;

import java.util.HashMap;
import java.util.Map;

public class CounterMapImpl<T> implements CounterMap<T> {

    private final Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T obj) {
        map.put(obj, map.getOrDefault(obj, 0) + 1);
    }

    @Override
    public int getCount(T obj) {
        return map.computeIfPresent(obj, (k, v) -> v);
    }

    @Override
    public int remove(T obj) {
        return map.remove(obj) != null ? 1 : 0;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CounterMap<T> anotherMap) {
        for (Map.Entry<T, Integer> entry : anotherMap.toMap().entrySet()) {
            T key = entry.getKey();
            int value = entry.getValue();
            map.put(key, map.getOrDefault(key, 0) + value);
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return new HashMap<>(map);
    }

    @Override
    public void toMap(Map<T, Integer> newMap) {
        newMap.putAll(map);
    }
}
