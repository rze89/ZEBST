
public class LinkedUnboundedQueue<T> implements UnboundedQueueInterface<T>{
 
	protected LLNode<T> front;
	protected LLNode<T> rear;
	
	public LinkedUnboundedQueue(){
		front = null;
		rear = null;
	}
	public void enqueue(T element){
		//Adds elements to the rear of the queue
		LLNode<T> newNode = new LLNode<T>(element);
		if(rear == null)
			front = newNode;
		else
			rear.setLink(newNode);
		rear = newNode;
	}

	  public T dequeue() throws QueueUnderflowException
	  // Throws QueueUnderflowException if this queue is empty;
	  // otherwise, removes front element from this queue and returns it.
	  {
	    if (isEmpty())
	      throw new QueueUnderflowException("Dequeue attempted on empty queue.");
	    else
	    {
	      T element;
	      element = front.getInfo();
	      front = front.getLink();
	      if (front == null)
	        rear = null;

	      return element;
	    }
	  }
		
	public boolean isEmpty(){
			//Returns true if this queue is empty; otherwise, returns false.
			if(front==null){
				return true;
			}
			else
				return false;
			}
		}
