
public class MyLinkedList <T> implements MyLinkedListInterface <T> {
    private Node<T> first;
    private Node<T> last;
    private int size;



    public MyLinkedList() {
        first = new Node<T>(null,null,null);
        last = new Node<T>(first,null,null);
        first.next = last;
        size = 0;
    }

    private  class Node<T> {
        private T current;
        private Node<T> next;
        private Node<T> prev;

        Node(Node<T> prev, T current, Node<T> next) {
            this.current = current;
            this.next = next;
            this.prev = prev;
        }

    }

    @Override
    public void add(Object value) {
        Node<T> prev = last;
        prev.current = (T)value;
        last = new Node<T>(prev,null,null);
        prev.next = last;
        size++;

    }

    @Override
    public boolean remove(int index) {
        if (size == 0){
            return false;
        } else if ( (index<0) || (index>(size-1)) ) return false;

        for (Node<T> i = first.next;i.current !=null; i = i.next){
            if (index == 0) {
                i.prev.next = i.next;
                i.next.prev = i.prev;
                size--;
                return true;
            }
            index--;
        }


        return false;
    }

    @Override
    public void clear() {
        size = 0;
        last.prev = first;
        first.next = last;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {

       if (size == 0){
           return null;
       } else if ( (index<0) || (index>(size-1)) ) return null;

       for (Node<T> i = first.next;i.current !=null; i = i.next){
           if (index == 0) return i.current;
           index--;
       }
       return null;
    }

    @Override
    public String toString() {

        if (size == 0) return "null";
        String result = "";
        int count = 0;
        Node<T> target = first.next;
        for (Node<T> i = first.next;i.current !=null;i = i.next){
            result+=count+": "+i.current+"\n";
            count++;
        }
       return result;
    }

}
