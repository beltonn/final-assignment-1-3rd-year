
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
      return left;
    }

    public Node getRight()
    {
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
