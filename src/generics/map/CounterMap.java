package generics.map;

import java.util.Map;

public interface CounterMap<T> {

    void add(T obj);

    int getCount(T obj);

    int remove(T obj);

    int size();

    //Добавить все элементы из anotherMap в текущий контейнер, при совпадении ключей - суммировать значения
    void addAll(CounterMap<T> anotherMap);

    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
    Map<T, Integer>  toMap();

    //Тот же самый контракт как и toMap(), только всю информацию записать в map
    void toMap(Map<T, Integer> map);
}
