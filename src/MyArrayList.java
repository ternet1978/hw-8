import java.util.Arrays;

public class MyArrayList <E>  implements MyArrayListInterface<E> {
    private Object[] array;
    private int size;
//    private int index;


    public <E> MyArrayList() {

        array = new Object[10];
        size = 0;
//        index =0;
    }


    @Override
    public void add(Object value) {
        if (size == array.length) {
            Object[] tempArray = new Object[size * 2];
            System.arraycopy(array, 0, tempArray, 0, size);
            array = tempArray;
        }
        array[size] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        if ((index >=0)&& (index< size)){
//           int newSize;
//            if ((size -1) < array.length / 2) {
//                newSize = array.length / 2;
//            } else {
//                newSize = array.length;
//            }
//            Object[] tempArray = new Object[newSize];
            Object[] tempArray = new Object[array.length];
            if (index == size -1){
                System.arraycopy(array, 0, tempArray, 0, size-1);
            } else if (index ==0){
                System.arraycopy(array, 1, tempArray, 0, size-1);
            } else {
                System.arraycopy(array, 0, tempArray, 0, index);
                System.arraycopy(array, index + 1, tempArray, index, size-index-1);
            }
            size--;
            array = tempArray;

        }
    }

    @Override
    public void clear() {
        array = new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) throws ArrayIndexOutOfBoundsException {
        if ((size > 0)&&(index < size)) {
            return (E) array[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Array Index Out of Bounds" + ". Size is " + size + ", your request is " + index);
        }
    }

    @Override
    public String toString() {
        String result = "MyArrayList{array=[";
        for (int i = 0; i < size; i++){
            result += array[i];
            if (i < size() - 1){
                result += ", ";
            }
        }
        result += "], size="+size+"}";
        return result;
    }
}
