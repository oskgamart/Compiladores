public class Main {
    public static void main(String[] args) {
        // Test Stack
        System.out.println("STACK");
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Stack peek: " + stack.peek()); //20
        stack.push(30);
        System.out.println("Current Size: " + stack.getSize()); //3
        System.out.println("Stack pop: " + stack.pop());//30
        System.out.println("Stack pop: " + stack.pop());//20
        System.out.println("Stack pop: " + stack.pop()); // 10
        //System.out.println("Stack pop: " + stack.pop()); //Exception

        System.out.println("----------------------------");
        // Test Queue
        System.out.println("QUEUE");
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Queue dequeue: " + queue.dequeue());//1
        queue.enqueue(4);
        System.out.println("Current Size: " + queue.getSize()); //3
        System.out.println("Queue Peek: " + queue.peek()); //2
        System.out.println("Queue dequeue: " + queue.dequeue()); //2
        System.out.println("Queue dequeue: " + queue.dequeue()); //3
        System.out.println("Queue dequeue: " + queue.dequeue()); //4
        //System.out.println("Queue dequeue: " + queue.dequeue());


        System.out.println("----------------------------");
        // Test Table
        System.out.println("TABLE");

        Table<String, Integer> table = new Table<>();

        table.put("Alice", 25);
        table.put("Bob", 30);
        table.put("Charlie", 35);

        System.out.println("Edad de Alice: " + table.get("Alice")); // 25
        System.out.println("Edad de Bob: " + table.get("Bob")); // 30

        table.remove("Alice");
        //table.remove("Andrea");
        String response = (table.containsKey("Alice") != -1) ? "yes" : "no";
        System.out.println("¿Alice está en la tabla?: " + response ); // no
    }
}
