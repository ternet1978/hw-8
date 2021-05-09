public interface MyQueueInterface <V>{
    void add(Object value);// добавляет элемент в конец
    boolean remove(int index);// удаляет элемент под индексом
    void clear();// очищает коллекцию
    int size();// возвращает размер коллекции
    V peek();// возвращает первый элемент в очереди (FIFO)
    V poll();// возвращает первый элемент в очереди и удаляет его из коллекции

}
