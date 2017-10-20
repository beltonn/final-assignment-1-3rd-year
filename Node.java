
public class Node {
	
	Node left, right;
    int data;

    
    
    public Node(int n)
    {
	   data = n;
	   right = null;
	   left = null;
    }
   
 
    public void setLeft(Node n)
    {
      left = n;
    }
 
    public void setRight(Node n)
    {
    	right = n;
    }
  
    public Node getLeft()
    {
    	if(left.equals(null))
    	{
    		return null;
    	}
      return left;
    }

    public Node getRight()
    {
    	if(right.equals(null))
    	{
    		return null;
    	}
       return right;
    }
    
    public void setData(int d)
    {
    	data = d;
    }
   
    public int getData()
    {
    	return data;
    }     

}
