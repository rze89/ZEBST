
public class ZEBSTNode <T extends Comparable<T>>{

	//USed to hold references to BST nodes for the linked implementation
	protected T info;					//The info in a BST node
	protected ZEBSTNode<T> left;		//A link to the left child node
	protected ZEBSTNode<T> right;		//A link to the right child node
	
	public ZEBSTNode(T info){
		this.info = info;
		left = null;
		right = null;
	}
	
	public void setInfo(T info){
		//Sets info of this BSTNode
		this.info = info;
	}
	public T getInfo(){
		//Returns info of this BSTNode
		return info;
	}
	public void setLeft(ZEBSTNode<T> link){
		//Sets left link of this BSTNode
		left = link;
	}
	public void setRight(ZEBSTNode<T> link){
		//Sets right link of this BSTNode
		right = link;
	}
	public ZEBSTNode<T> getLeft(){
		//Returns left link of this BSTNode
		return left;
	}
	public ZEBSTNode<T> getRight(){
		//Returns right link of this BSTNode
		return right;
	}
}
