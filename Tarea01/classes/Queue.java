public class Queue<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<T> front, rear;
    private int size;

    //Constructor
    public Queue(){
        this.front = this.rear = null;
        this.size = 0;
    }

    //Agregar elemento a la fila
    public void enqueue(T data){
        Node<T> newNode = new Node<>(data);
        if(rear == null){
            rear = front = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    //Quitar y regresar el primer elemento de la lista
    public T dequeue(){
        if (isEmpty()) throw new RuntimeException("Queue vacío");
        T data = front.data;
        front = front.next;
        if(front == null) rear = null;
        size--;
        return data;
    }

    //ver el primer elemento de la lista

    public T peek(){
        if (isEmpty()) throw new RuntimeException("Queue vacío");
        return front.data;
    }

    //identifica si esta vacia la lista
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    // regresa el tamaño de la lista
    public int getSize() {
        return size;
    }
}
