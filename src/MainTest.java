//https://habr.com/ru/post/421179/ - как работ ает HashMap

public class MainTest {
    public static void main(String[] args) {
//   Test MyArrayList
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Nikole");
        myArrayList.add("John");
        myArrayList.add("Alex");
        myArrayList.add("George");
        myArrayList.add("Lilu");
        myArrayList.add("Nikole");
        myArrayList.add("John");
        myArrayList.add("Alex");
        myArrayList.add("George");
        myArrayList.add("Nikole1");
        myArrayList.add("Nikole2");
        myArrayList.remove(10);
        myArrayList.remove(0);
      //myArrayList.clear();// очищает коллекцию
      //myArrayList.add("Nikole");
        System.out.println("Test My ArrayList\n3-th element: "+myArrayList.get(2)+ "\nsize="+myArrayList.size());
        System.out.println(myArrayList);
//   Test LinkedList
        System.out.println("******\nTest My LinkedList");
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Tennis");
        myLinkedList.add("Baskettball");
        myLinkedList.add("Football");
        System.out.println("2-nd element: "+myLinkedList.get(1));
        myLinkedList.remove(1);
        System.out.println("After Add 3 el. and remove 1 size = "+myLinkedList.size());
        myLinkedList.clear();
        myLinkedList.add("Baskettb8all");
        System.out.println("After clear and ADD size = "+myLinkedList.size());
        System.out.println(myLinkedList);

//   Test MyQueue
        System.out.println("******\nTest My Queue");
        MyQueue <String> myQueue = new MyQueue<>();
        myQueue.add("Alex");
        myQueue.add("George");
        System.out.println(myQueue);
        myQueue.clear();
        myQueue.add("Nikole");
        myQueue.add("John");
        myQueue.add("Alex");
        myQueue.add("George");
        myQueue.add("Lilu");
        myQueue.add("Nikole");
        myQueue.remove(4);
        System.out.println("After Clear, ADD 6 elements and remove 5-th element size = "+myQueue.size());
         System.out.println("First element = "+myQueue.peek());
         System.out.println("Poll method returns "+myQueue.poll()+" and delete it");
        System.out.println("New size = "+myQueue.size());
        System.out.println(myQueue);
//   Test MyStack
        System.out.println("******\nTest My Stack");
        MyStack <String> myStack = new MyStack<>();

        myStack.push("Nikole");
        myStack.push("John");
        myStack.push("Alex");
        myStack.push("George");
        System.out.println("Stack size = "+myStack.size());
        System.out.println(myStack);
        System.out.println("First element = "+myStack.peek());
        System.out.println("Stack size = "+myStack.size());
        System.out.println("First element was: "+myStack.pop()+" when we did 'POP'");
        System.out.println("Stack size = "+myStack.size());
        System.out.println(myStack);
        myStack.clear();
        System.out.println("Stack size after 'CLEAR': "+myStack.size());
        myStack.push("Nikole");
        myStack.push("John");
        myStack.push("Alex");
        myStack.push("George");
        System.out.println(myStack);
        myStack.remove(1);
        System.out.println("Stack after remove 2-d element:\n"+myStack);
//   Test MyHashMap
        System.out.println("******\nTest My HashMap");
        MyHashMap <String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("Alex",9);
        myHashMap.put("Felix",8);
        myHashMap.put("Alex",7);
        myHashMap.put("Alex",100);
        myHashMap.put("Sasha",300);
        System.out.println("Our HashMap is:\n"+myHashMap);
        System.out.println("SiZE of HashMap is "+myHashMap.size());
        myHashMap.remove("Alex");
        System.out.println("SiZE of HashMap after REMOVE 'Alex' is "+myHashMap.size());
        System.out.println(myHashMap);
        System.out.println("We need to find a Value of key 'Sasha'\nand result = "+myHashMap.get("Sasha"));
        myHashMap.clear();
        myHashMap.put("Sally",9);
        myHashMap.put("John",8);
        myHashMap.put("John2",85);
        myHashMap.put("John3",88);
        myHashMap.put("John8",5);
        myHashMap.put("John2",855);
        myHashMap.put("Mickey",7);
        myHashMap.put("Mickey2",70);
        myHashMap.put("Mouse",109);
        myHashMap.put("Mickey",85);
        System.out.println("******My HashMap after CLEAR and add eight elements:\n"+myHashMap+ "\nsize = "+myHashMap.size());
        System.out.println("We need to find a Value of key 'John'\nand result = "+myHashMap.get("John"));
    }
}
