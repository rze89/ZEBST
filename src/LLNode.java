
public class LLNode<T> {

	private LLNode<T> link;
    
	private T info;

    public LLNode(T info)
    //constructor
    {
      this.info = info;
      link = null;
    }

    public void setInfo(T info)
    // Sets the info to the node
    {
      this.info = info;
    }

    public T getInfo()
    // Returns the info of the selected node
    {
      return info;
    }

    public void setLink(LLNode<T> link)
    // Sets the link of the selected node
    {
      this.link = link;
    }

    public LLNode<T> getLink()
    // goes and returns the lnik of the node
    {
      return link;
    }
}
