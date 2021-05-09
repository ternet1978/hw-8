import java.util.Arrays;
import java.util.Objects;

public class MyHashMap <A,B> implements MyHashMapInterface<A,B>{
    private int size;
    private Node[] buckets;
   // private Node[] buckets3;



    public <A,B> MyHashMap() {
        buckets = new Node[16];
        size = 0;
    }

    private  class Node<A,B> {
        private A currentKey;
        private B currentVolume;
        private int hashCode;
        private Node<A,B> next;

        Node( A currentKey,B currentVolume,int hashCode, Node<A,B> next) {
            this.currentKey = currentKey;
            this.currentVolume = currentVolume;
            this.hashCode =hashCode;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return currentKey.equals(node.currentKey);
        }

        @Override
        public int hashCode() {
            return Objects.hash(currentKey);
        }
    }


    @Override
    public void put(Object key, Object value) {
         int hashCode = Objects.hash(key);
         int index = getIndex(hashCode);
         Node<A,B> newElement = new Node<A,B>((A)key,(B)value,hashCode,null);
         if (buckets[index]==null) {
             buckets[index] = newElement;
             size++;
         } else {
             Node bucket =buckets[index];
             for(;;) {
                 if ((hashCode == bucket.hashCode) && (newElement.equals(bucket)) ) {
                     bucket.currentVolume = newElement.currentVolume;
                     break;
                 }
                 if (bucket.next == null){
                     bucket.next = newElement;
                     size++;
                     break;
                 } else {
                     bucket = bucket.next;
                 }

             }
         }

    }

    @Override
    public boolean remove(Object key) {
        int hashCode = Objects.hash(key);
        int index = getIndex(hashCode);
        if (buckets[index] == null) {
            return false;
        }
        Node element = buckets[index];
        if (element.currentKey.equals(key)) {
            if (element.next !=null){
                buckets[index] = element.next;
                size--;
                return true;
            } else {
                buckets[index] = null;
                size--;
                return true;
            }


        } else if (element.next ==null) {   //First element by Index don't equals our Key
            return false;
        } else {     // We continuing searching element in current Index (Bucket)
            for (;;) {
               Node elementNext = element.next;
                if (elementNext.currentKey.equals(key)) {
                     if (elementNext.next!=null) {
                         element.next = elementNext.next;
                     } else {
                         element.next = null;
                     }
                    size--;
                    return true;
                }
                element = elementNext;
                if (element.next == null) break;
            }

        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i< buckets.length; i++){
            buckets[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public B get(Object key) {
        int hashCode = Objects.hash(key);
        int index = getIndex(hashCode);
        if (buckets[index] == null) {
            return null;
        }
        Node element = buckets[index];
        if (element.currentKey.equals(key)) {
            return (B) element.currentVolume;

        } else if (element.next ==null) {   //First element by Index don't equals our Key
            return null;
        } else {     // We continuing searching element in current Index (Bucket)
            for (;;) {
                Node elementNext = element.next;
                if (elementNext.currentKey.equals(key)) {

                    return (B) elementNext.currentVolume;
                }
                element = elementNext;
                if (element.next == null) break;
            }

        }
        return null;
    }
    private int getIndex(int hashCode) {
        return  hashCode & 15;
        //index = hashCode(key) & (n-1)
    }

    @Override
    public String toString() {
        String result = "";
        for (int i =0;i < buckets.length;i++){
           result+=i+": ";
            if (buckets[i] ==null) {
                result+="null\n";
            } else {
                Node element = buckets[i];
                for (;;) {
                    result+="{"+element.currentKey+", "+element.currentVolume+"}";
                    if (element.next!=null) result+=", ";
                    else {
                        result+="\n";
                        break;
                    }
                    if (element.next!=null) element = element.next;
                    else break;
                 }



            }

        }
        return result;
    }

}
