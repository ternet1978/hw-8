public interface MyStackInterface <V>{
    void push(Object value); //добавляет элемент в конец
    boolean remove(int index);// удаляет элемент под индексом
    void clear();// очищает коллекцию
    int size();//возвращает размер коллекции
    V peek();// возвращает первый элемент в стеке (LIFO)
    V pop();// возвращает первый элемент в стеке и удаляет его из коллекции
}
