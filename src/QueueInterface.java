
public interface QueueInterface<T>{

	T dequeue() throws QueueUnderflowException;

	boolean isEmpty();
}
