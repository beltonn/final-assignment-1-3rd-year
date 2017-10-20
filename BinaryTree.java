
public class BinaryTree {
	

	private Node root;
	 
    public BinaryTree(Node r)
    {
        root = r;
    }
    public BinaryTree()
    {
        root = null;
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
     
		if(root == a || root == b)
		{
            return root;
		}
     
        Node y = lowestCommonAncestor(root.left, a, b);
        Node x = lowestCommonAncestor(root.right, a, b);
     
        if(y != null && x != null)
        {
            return root;
        }
        else if(y == null && x == null)
        {
            return null;
        }
        else
        {
            return y == null?x:y;
        }
	}     





}
