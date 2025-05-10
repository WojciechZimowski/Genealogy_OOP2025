import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CustomList<T> extends AbstractList<T> {

    private Node<T> head;

    private Node<T> tail;

    private int size = 0;

    @Override
    public   T get(int index) {
        if(size ==0){
            return null;
        }
        if(index>= size && size < 0){
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for(int i=0; i<index; i++){
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<T>{
        //T dlatego żeby nie ograniczać się tylko do jednej klasy
        //Zakładamy że typ jest nieznany, szablonoyw(template)
        T value;

        Node<T> next;

        Node(T value){
            this.value = value;
            this.next = null;
        }

    }

    public void addLast(T value){
        Node<T> newNode = new Node<T>(value);
        if(head == null){
            head = tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;

    }
    public boolean add(T value){
        int prevSize = size;
        addLast(value);
        return size > prevSize;

    }
    public  T removeLast(){

        if(tail != null){
            T valueToReturn = tail.value;
            if(head == tail){
                head = tail = null;
                size--;
                return valueToReturn;
            }
            Node<T> currentElement = head;
            while(currentElement.next != tail){
               currentElement = currentElement.next;
            }
            tail = currentElement;
            tail.next = null;
            size--;
            return valueToReturn;

        }
        return null;
    }
    public T getLast(){
        if(head != null)
            return tail.value;
        return null;
    }
    public T getFirst(){
        if(head != null)
            return head.value;
        return null;
    }
    public  T removeFirst(){

        if(head != null){
            T valueToReturn = head.value;
            head = head.next;
            if(head  == null){
                tail = null;
            }
            size--;
            return valueToReturn;

        }
        return null;
    }
    public  void addFirst(T value){
        Node<T> newNode = new Node<T>(value);
        if(head == null){
            head = tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        size++;

    }
    public Iterator<T> iterator(){
        return  new Iterator<T>() {
            private Node<T> current=head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                    if(!hasNext()){
                        throw new java.util.NoSuchElementException();
                    }
                    T value = current.value;
                    current = current.next;
                return value;
            }
        };
    }
    public Stream<T> stream(){
        Iterable<T> iterable = () -> new Iterator<T>() {
            private Node<T>current = head;
            @Override
            public boolean hasNext() {
                return current!=null;
            }

            @Override
            public T next() {
                if(!hasNext()){
                    throw  new java.util.NoSuchElementException();
                }
                T value = current.value;
                current = current.next;
                return value;


            }
        };
        return StreamSupport.stream(iterable.spliterator(),false);
    }
    //Zadanie 4 PD programowanie generyczne
    public  static <T> List<T> returnPointedClass(List<T> list, Class<?> cas){
        List<T> result = new ArrayList<>();
        for(T element : list){
            //if(element != null && element.getClass().equals(list))
            if(element != null && cas.isAssignableFrom(element.getClass())){
                result.add(element);
            }
        }
        return result;
    }
    }


