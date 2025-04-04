public class Stack<T>{
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> top;
    private int size;

    //constructor
    public Stack(){
        this.top = null;
        this.size = 0;
    }

    //agregar un elemento hasta arriba

    public void push(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    //quitar y ver el elemento de hasta arriba
    public T pop(){
        if (isEmpty()) throw new RuntimeException("Stack vacío");
        T data = top.data;
        top = top.next;
        size --;
        return data;
    }

    // ver el elemento de hasta arriba
    public T peek(){
        if (isEmpty()) throw new RuntimeException("Stack vacío");

        return top.data;
    }

    //identifica si esta vacia la pila
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    //Regresa el tamaño de la pila
    public int getSize() {
        return size;
    }
}