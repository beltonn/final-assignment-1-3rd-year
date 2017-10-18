import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeTest {

	@Test
    public void lowerCommonAncestor() 
	{
		
		Node root = new Node(1);
        BinaryTree bt = new BinaryTree(root);
        
       //building a binary search tree
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node5.setLeft(node6);
               
        
        Node lca = bt.lowestCommonAncestor(root, node4, node5);
        assertEquals("The lowest common ancestor:", node2, lca);
        
        lca = bt.lowestCommonAncestor(root, node5, node6);
        assertEquals("The lowest common ancestor:", node2, lca);
        
    }

}
