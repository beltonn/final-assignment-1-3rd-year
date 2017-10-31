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
    
    

	/*public void delete(ArrayList<Node<T>> DAG) {
		
		if(DAG.contains(this))
    	{
    		if(this == DAG.get(0))
    		{
    			for(int i =0; i < this.edgesTo.size(); i++)
    			{
    				edgesTo.get(i).indegree--;
    				DAG.remove(this);
    			}
    			this.data = null;
    			this.edgesTo = null;
    			this.indegree = 0;
    			this.outdegree = 0;
    		}
    		else
    		{
			    for(int i = 0; i < DAG.size(); i++)
			    {
			        Node<T> current = DAG.get(i);
			        if(current.edgesTo.contains(this))
			        {
			        	System.out.println(DAG.get(current.edgesTo.indexOf(this)).data.toString());
		                current.edgesTo.remove(this);
		                DAG.remove(this);
				    	System.out.println("here, i = " + i);
			        }
			    }
			    this.edgesTo = null;
    		}
    		
		    
    	}
		// TODO Auto-generated method stub
		
	} */
	
	


}