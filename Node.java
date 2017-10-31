import java.util.ArrayList;

public class Node<T>
{
     
    public T data;
    public ArrayList<Node<T>> edgesTo;
    public int indegree;
    public int outdegree;
    
    public Node(T value)
    {
        data = value; 
        edgesTo = new ArrayList<Node<T>>();
        indegree = 0;
        outdegree = edgesTo.size();
    } 

    public void connect(Node<T> child)
    {
    	if(child != null)
        {
    		child.indegree++;
            this.edgesTo.add(child);
        }
    }

   
    
    public void disconnect(Node<T> child)
    {
    	if(this.edgesTo.contains(child))
    	{
    		this.edgesTo.remove(child);
    		indegree--;
    	}
    }
    
    public void remove(ArrayList<Node<T>> list)
    {
    	if(list != null)
    	{
		    for(int i = 0; i < list.size(); i++)
		    {
		        Node<T> current = list.get(i);
		        if(current.edgesTo.contains(this))
		        {
		            current.edgesTo.remove(current.edgesTo.indexOf(this));
		        }
		    }
		    this.edgesTo = null;
    	}
    }


}