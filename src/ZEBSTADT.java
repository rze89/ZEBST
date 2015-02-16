
public class ZEBSTADT <T extends Comparable<T>>implements ZEBSTInterface<T>{

	protected ZEBSTNode<T> root;		//reference to the root of this BST
	boolean found;						//used by remove
	
	//for traversals
	protected LinkedUnboundedQueue<T> inOrderQueue;
	protected LinkedUnboundedQueue<T> preOrderQueue;
	protected LinkedUnboundedQueue<T> postOrderQueue;
	
	public ZEBSTADT(){
		//creates an empty ZEBSTADT object
		root = null;
	}
	public boolean isEmpty(){
		//Returns true if this BST is empty; otherwise, returns false;
		return (root == null);
	}
	public int size(){
		//Returns the number of elements in this BST
		return recSize(root);
	}
	public int recSize(ZEBSTNode<T> tree){
		if(tree == null){
			return 0;
		}
		else{
			return recSize(tree.getLeft()) + recSize(tree.getRight()) +1;
		}
	}
	private boolean recContains(T element, ZEBSTNode<T> tree){
		//Returns true if tree contains an element e such that
		//e.compareTo(element) ==0; otherswise, returns false.
		if(tree ==null)
			return false;			//element is not found
		else if (element.compareTo(tree.getInfo()) < 0)
			return recContains(element, tree.getLeft());	//search left subtree
		else if(element.compareTo(tree.getInfo()) > 0)
			return recContains(element, tree.getRight());	//search right subtree
		else
			return true;
		}
	public boolean contains(T element){
		//Returns true if this BST contains an element e such that
		//e.compareTo(element) == 0; otherwise, returns fasle;
		return recContains(element, root);
	}
	private T recGet( T element, ZEBSTNode<T> tree){
		if(tree == null)
			return null;
		else if (element.compareTo(tree.getInfo())<0)
			return recGet(element, tree.getLeft());
		else
			if(element.compareTo(tree.getInfo())>0)
				return recGet(element, tree.getRight());
			else
				return tree.getInfo();
		}
	public T get(T element){
		//Returns an element e from this ZEBST such that e.compareTo(element)==0;
		//if no such element exists, returns null;
		return recGet(element, root);
	}
	public void add (T element){
		//Adds element to thsi BST. The tree retains its BST property.
		root = recAdd(element, root);
	}
	private ZEBSTNode<T> recAdd(T element, ZEBSTNode<T> tree){
		//Adds element to tree; tree retains BST proeprty
		if(tree == null)
			//Addition place found
			tree = new ZEBSTNode<T>(element);
		else if(element.compareTo(tree.getInfo()) <= 0)
				tree.setLeft(recAdd(element, tree.getLeft()));
		else 
			tree.setRight(recAdd(element, tree.getRight()));  //Add in right subtree
		return tree;
			
		}
	public boolean remove(T element){
		//Removes an element e from this BST such that e.compareTo(element) ==0
		//and returns true; if no such element exists, returns false
		root = recRemove(element, root);
		return found;
	}
	 private ZEBSTNode<T> recRemove(T element, ZEBSTNode<T> tree){
	  // Removes an element e from tree such that e.compareTo(element) == 0
	  // and returns true; if no such element exists, returns false. 
	  
	    if (tree == null)
	      found = false;
	    else if (element.compareTo(tree.getInfo()) < 0)
	      tree.setLeft(recRemove(element, tree.getLeft()));
	    else if (element.compareTo(tree.getInfo()) > 0)
	      tree.setRight(recRemove(element, tree.getRight()));
	    else  
	    {
	      tree = removeNode(tree);
	      found = true;
		 }
	    return tree;
	  }
	private ZEBSTNode<T> removeNode(ZEBSTNode<T> tree){
		// Removes the information at the node referenced by tree.
		// The user's data in the node referenced by tree is no
		// longer in the tree.  If tree is a leaf node or has only
		// a non-null child pointer, the node pointed to by tree is
		// removed; otherwise, the user's data is replaced by its
		// logical predecessor and the predecessor's node is removed.
		T data;

	    if (tree.getLeft() == null)
	      return tree.getRight();
	    else if (tree.getRight() == null) 
	      return tree.getLeft();
	    else
	    {
	      data = getPredecessor(tree.getLeft());
	      tree.setInfo(data);
	      tree.setLeft(recRemove(data, tree.getLeft()));  
	      return tree;
	    }
	}
	    private T getPredecessor(ZEBSTNode<T> tree)
	    // Returns the information held in the rightmost node in tree
	    {
	      while (tree.getRight() != null)
	        tree = tree.getRight();
	      return tree.getInfo();
	    }
	    public int reset(int orderType){
	    	//Initializes current position for an iteration through this BST
	    	//in orderType order. Returns current number of nodes in the BST
	    	int numNodes = size();
	    	if(orderType ==INORDER){
	    		inOrderQueue = new LinkedUnboundedQueue<T>();
	    		inOrder(root);
	    	}
	    	else{
	    	if(orderType == PREORDER){
	    		preOrderQueue = new LinkedUnboundedQueue<T>();
	    		preOrder(root);
	    	}
	    	if(orderType == POSTORDER){
	    		postOrderQueue = new LinkedUnboundedQueue<T>();
	    		postOrder(root);
	    	}
	    	}
	    	return numNodes;
	    }

	    public T getNext (int orderType) throws QueueUnderflowException
	    // Preconditions: The BST is not empty
	    //                The BST has been reset for orderType
	    //                The BST has not been modified since the most recent reset
	    //                The end of orderType iteration has not been reached
	    //
	    // Returns the element at the current position on this BST for orderType
	    // and advances the value of the current position based on the orderType. 
	    {
	      if (orderType == INORDER)
	        return inOrderQueue.dequeue();
	      else
	      if (orderType == PREORDER)
	        return preOrderQueue.dequeue();
	      else
	      if (orderType == POSTORDER)
	        return postOrderQueue.dequeue();
	      else return null;
	    }
	    private void inOrder(ZEBSTNode<T> tree){
	    	//Initializes inOrderQueue with tree elements in inOrder order
	    	if(tree !=null){
	    		inOrder(tree.getLeft());
	    		inOrderQueue.enqueue(tree.getInfo());
	    		inOrder(tree.getRight());
	    	}
	    }
	    private void preOrder(ZEBSTNode<T> tree){
	    	//Initalizes preORderQueue with tree elements in preOrder order.
	    	if(tree !=null){
	    		preOrderQueue.enqueue(tree.getInfo());
	    		preOrder(tree.getLeft());
	    		preOrder(tree.getRight());
	    	}
	    }
	    private void postOrder(ZEBSTNode<T> tree){
	    	//Initializes postOrderQueue with tree elements in postOrder order.
	    	if(tree !=null){
	    		postOrder(tree.getLeft());
	    		postOrder(tree.getRight());
	    		postOrderQueue.enqueue(tree.getInfo());
	    		
	    	}
	    }
	    public void printInorder()
	    {
	    printInOrderRec(root);
	    System.out.println("");
	    }

	    private void printInOrderRec(ZEBSTNode<T> currRoot){
	      if ( currRoot == null ){
	      return;
	     
	      }
	      printInOrderRec(currRoot.left);
	      System.out.print(currRoot.getInfo() +", ");
	      printInOrderRec(currRoot.right);
	     
	    }

	    public void printPreorder() {
	    	    printPreOrderRec(root);
	           System.out.println("");
	    	   
	         }
	    	 
	    	  
	    	  private void printPreOrderRec(ZEBSTNode<T> currRoot) {
	    	    if (currRoot == null) {	      
	           return; 
	    	    }
	    	   System.out.println(currRoot.getInfo() + ", ");
	    	    printPreOrderRec(currRoot.left);
	    	    printPreOrderRec(currRoot.right);
	    	   
	         }
	     public void printPostorder() {
	    	    printPostOrderRec(root);
	    	    System.out.println("");
	    	  }
	    	
	    	  private void printPostOrderRec(ZEBSTNode<T> currRoot) {
	    	    if (currRoot == null) {
	    	   return;
	    	    }
	    	  printPostOrderRec(currRoot.left);
	    	    printPostOrderRec(currRoot.right);
	           System.out.println(currRoot.getInfo() + ", ");
	         }
}
