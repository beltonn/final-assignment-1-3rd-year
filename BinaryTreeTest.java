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
               
        
        Node lca = bt.lowestCommonAncestor(root, node2, node3);
        assertEquals("The lowest common ancestor:", root, lca);
        
        lca = bt.lowestCommonAncestor(root, node4, node5);
        assertEquals("The lowest common ancestor:", node2, lca);
        
        lca = bt.lowestCommonAncestor(root, node5, node6);
        assertEquals("The lowest common ancestor:", node5, lca);
        
        lca = bt.lowestCommonAncestor(root, node4, node6);
        assertEquals("The lowest common ancestor:", node2, lca);
        
        

    }
	@Test
    public void lcaRoot() //finding the lowest common ancestor of the root and another node
    {
		
    }
	@Test
    public void lcaRightNodeNull() //finding the lowest common ancestor of a non-existent node and another node
    {
		
    }
	@Test
    public void lcaLeftNodeNull() //finding the lowest common ancestor of a non-existent node and another node
    {
		
    }
	@Test
    public void lcaOneNodeTree() //finding the lowest common ancestor of a one node tree
    {
		
    }
	@Test
    public void lcaOfEmptyTree() //finding the lowest common ancestor of an empty tree
    {
		
    }
	@Test
    public void isEmpty() 
	{
		BinaryTree bt = new BinaryTree();
		boolean treeEmpty = true;
        assertEquals("The tree is empty", treeEmpty, bt.isEmpty());

	}

}
