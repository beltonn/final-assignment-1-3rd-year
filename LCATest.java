import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LCATest {

	@Test
	public void checkEmptyDAG() 
	{
		Node a = new Node(1);
		Node b = new Node(2);
		ArrayList<Node> DAG = new ArrayList<Node>();
	    assertEquals("Testing empty DAG", null, LCA.LowestCommonAncestor(null, null, null));
	    assertEquals("Testing empty DAG", null, LCA.LowestCommonAncestor(DAG, a, b));


	}
	@Test
	public void checkNodeNonExistent() 
	{
		Node a = new Node(1);
		Node b = new Node(2);
		ArrayList<Node> DAG = new ArrayList<Node>();
		DAG.add(b);
	    assertEquals("Testing empty DAG", null, LCA.LowestCommonAncestor(DAG, a, b));
	    assertEquals("Testing empty DAG", null, LCA.LowestCommonAncestor(DAG, b, a));

	}
	@Test
	public void checkCyclicalTrue() 
	{
		Node<Integer> a = new Node<Integer>(0);
		Node<Integer> b = new Node<Integer>(1);
		Node<Integer> c = new Node<Integer>(2);
		Node<Integer> d = new Node<Integer>(3); 
		ArrayList<Node> DAG = new ArrayList<Node>();
		DAG.add(a);
		DAG.add(b);
		DAG.add(c);
		DAG.add(d);
		a.connect(b);
		b.connect(c);
		c.connect(d);
		d.connect(a);
	    assertEquals("Testing for a cycle", true, LCA.isCyclicUtil(DAG));

		
	}
	@Test
	public void checkCyclicalFalse() 
	{
		Node<Integer> a = new Node<Integer>(0);
		Node<Integer> b = new Node<Integer>(1);
		Node<Integer> c = new Node<Integer>(2);
		Node<Integer> d = new Node<Integer>(3);
		Node<Integer> e = new Node<Integer>(4);
		Node<Integer> f = new Node<Integer>(5);
		ArrayList<Node> DAG = new ArrayList<Node>();
		DAG.add(a);
		DAG.add(b);
		DAG.add(c);
		DAG.add(d);
		DAG.add(e);
		DAG.add(f);
		f.connect(c);
		c.connect(d);
		d.connect(b);
		e.connect(b);
		e.connect(a);
		f.connect(a);
	    assertEquals("Testing for a cycle", false, LCA.isCyclicUtil(DAG));
	}
	@Test
	public void checkRootsNoEdges() 
	{
		Node<Integer> a = new Node<Integer>(0);
		Node<Integer> b = new Node<Integer>(1);
		Node<Integer> c = new Node<Integer>(2);
		Node<Integer> d = new Node<Integer>(3); //not connected to the DAG
		Node<Integer> e = new Node<Integer>(4);
		Node<Integer> f = new Node<Integer>(5);
		ArrayList<Node> DAG = new ArrayList<Node>();
		DAG.add(a);
		DAG.add(b);
		DAG.add(c);
		DAG.add(d);
		DAG.add(e);
		DAG.add(f);
		f.connect(c);
		c.connect(e);
		e.connect(b);
		e.connect(a);
		f.connect(a);
	    assertEquals("Testing a node in the DAG, not connected", null, LCA.LowestCommonAncestor(DAG, c, f));
	    assertEquals("Testing a node in the DAG, not connected", null, LCA.LowestCommonAncestor(DAG, c, d));


	}

	@Test
	public void checkLCA() 
	{
		Node<Integer> a = new Node<Integer>(0);
		Node<Integer> b = new Node<Integer>(1);
		Node<Integer> c = new Node<Integer>(2);
		Node<Integer> d = new Node<Integer>(3);
		Node<Integer> e = new Node<Integer>(4);
		Node<Integer> f = new Node<Integer>(5);
		ArrayList<Node> DAG = new ArrayList<Node>();
		DAG.add(a);
		DAG.add(b);
		DAG.add(c);
		DAG.add(d);
		DAG.add(e);
		DAG.add(f);
		f.connect(c);
		c.connect(d);
		d.connect(b);
		e.connect(b);
		e.connect(a);
		f.connect(a);
	   // assertEquals("Testing LCA", c, LCA.LowestCommonAncestor(DAG, c, d));
	    assertEquals("Testing LCA", e, LCA.LowestCommonAncestor(DAG, a, b));
	    assertEquals("Testing LCA", f, LCA.LowestCommonAncestor(DAG, d, f));
	    assertEquals("Testing No common ancestors", null, LCA.LowestCommonAncestor(DAG, e, c));



	}

}
