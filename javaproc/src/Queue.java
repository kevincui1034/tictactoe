import java.util.ArrayDeque;

public final class Queue<T> implements QueueInterface<T> {
    
    private ArrayDeque<T> queue;
    private static final int default_capacity = 50;
    private static final int max_capacity = 10000;
    private boolean integrityOk;
    
    public Queue(){
       this(default_capacity); 
    }
    
    public Queue(int initialCapacity){
        
        queue = new ArrayDeque<>(initialCapacity);
    }
    
    public void enqueue(T newEntry){
        queue.addLast(newEntry);
    }
    
    public T getFront(){
        return queue.getFirst();
    }
    
    public T dequeue(){
        T front = queue.removeFirst();
        return front;
    }
    
    public boolean isEmpty(){
        boolean empty;
        if (queue.isEmpty())
            empty = true;
        else
            empty = false;
        
        return empty;
    }
    
    public void clear(){
        queue.clear();
    }
    
}
