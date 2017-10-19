
public class BinaryTree {
	

	private Node root;
	 
    public BinaryTree(Node r)
    {
        root = r;
    }
    
    
   
    public boolean isEmpty()
    {
    	return root == null;
    }

 
	public Node lowestCommonAncestor(Node root, Node a, Node b) 
	{
		if(root==null)
		{
            return null;
		}
     
       
     
        Node y = lowestCommonAncestor(root.left, a, b);
        Node x = lowestCommonAncestor(root.right, a, b);
     
        if(y != null && x != null)
        {
            return root;
        }
	}     





}
