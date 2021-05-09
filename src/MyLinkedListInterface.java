public interface MyLinkedListInterface<T> {

   void add(Object value);// добавляет элемент в конец
   boolean remove(int index);// удаляет элемент под индексом
   void clear();// очищает коллекцию
   int size();// возвращает размер коллекции
   T get(int index);// возвращает элемент под индексом

}
