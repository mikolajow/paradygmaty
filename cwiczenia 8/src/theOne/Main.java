package theOne;

public class Main {

	public static void main(String[] args) {
		
		
        MyQueue<String> queue = new CyclicQueue<>(3);
        
        try {
            queue.enqueue("banan");
            queue.enqueue("kiwi");
            queue.enqueue("gruszka");
            System.out.println(queue.first());
            queue.dequeue();
            queue.enqueue("ser");
            System.out.println(queue.first());
            queue.dequeue();
            queue.enqueue("wafel");
            System.out.println(queue.first());
            queue.enqueue("but");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//end of main
}//end of class
