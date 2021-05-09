public class MyQueue <V> implements MyQueueInterface <V> {
    private Node<V> first;
    private Node<V> last;
    private int size;

    public MyQueue() {
        first = new Node<V>(null,null,null);
        last = new Node<V>(first,null,null);
        first.next = last;
        size = 0;
    }

    private  class Node<V> {
        private V current;
        private Node<V> next;
        private Node<V> prev;

        Node(Node<V> prev, V current, Node<V> next) {
            this.current = current;
            this.next = next;
            this.prev = prev;
        }

    }




    @Override
    public void add(Object value) {
        Node<V> prev = last;
        prev.current = (V)value;
        last = new Node<V>(prev,null,null);
        prev.next = last;
        size++;
    }

    @Override
    public boolean remove(int index) {
        if (size == 0){
            return false;
        } else if ( (index<0) || (index>(size-1)) ) return false;

        for (Node<V> i = first.next; i.current !=null; i = i.next){
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
    public V peek() {
        if (size == 0) {
            return null;
        }
        return (V)first.next.current;
    }

    @Override
    public V poll() {
        if (size == 0) {
            return null;
        }
        V result = first.next.current;
        first.next = first.next.next;
        first.next.next.prev =first;
        size--;
        return result;
    }

    @Override
    public String toString() {

        if (size == 0) return "null";
        String result = "";
        int count = 0;
        Node<V> target = first.next;
        for (Node<V> i = first.next; i.current !=null; i = i.next){
            result+=count+": "+i.current+"\n";
            count++;
        }
        return result;
    }


}
