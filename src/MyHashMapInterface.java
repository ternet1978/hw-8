public interface MyHashMapInterface <A, B>{
    void put(Object key, Object value);// добавляет пару ключ + значение
    boolean remove(Object key);// удаляет пару по ключу
    void clear();// очищает коллекцию
    int size();// возвращает размер коллекции
    B get(Object key);// возвращает значение(Object value) по ключу

}
