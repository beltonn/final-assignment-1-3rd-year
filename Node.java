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
        
    }

   
    
    public void disconnect(Node<T> child)
    {
    	
    }
    
    public void remove(ArrayList<Node<T>> a)
    {
        
    }


}