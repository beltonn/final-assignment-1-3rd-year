import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
    public void lowerCommonAncestor() 
	{
		Node root = new Node(1);
        BinaryTree bt = new BinaryTree(root);
        
      
       
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
       
       
        
        
        Node lca = bt.lowestCommonAncestor(root, node4, node2);
        assertEquals("The lowest common ancestor:", root, lca);   
        
    }

}
