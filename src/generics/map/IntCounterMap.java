package generics.map;

import java.util.HashMap;
import java.util.Map;

public class IntCounterMap implements CounterMap<Integer> {
    private final Map<Integer, Integer> map = new HashMap<>();

    @Override
    public void add(Integer obj) {
        map.put(obj, map.getOrDefault(obj, 0) + 1);
    }

    @Override
    public int getCount(Integer obj) {
        return map.computeIfPresent(obj, (k, v) -> v);
    }

    @Override
    public int remove(Integer obj) {
        return map.remove(obj) != null ? 1 : 0;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CounterMap<Integer> anotherMap) {
        for (Map.Entry<Integer, Integer> entry : anotherMap.toMap().entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            map.put(key, map.getOrDefault(key, 0) + value);
        }
    }

    @Override
    public Map<Integer, Integer> toMap() {
        return new HashMap<>(map);
    }

    @Override
    public void toMap(Map<Integer, Integer> anotherMap) {
        anotherMap.putAll(map);
    }
}
