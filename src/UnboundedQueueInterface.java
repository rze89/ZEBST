
public interface UnboundedQueueInterface<T> extends QueueInterface<T> {

	void enqueue(T element);
}
