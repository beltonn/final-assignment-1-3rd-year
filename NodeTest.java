import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class NodeTest {

	@Test
	public void checkConnect() 
	{
		Node<Integer> a = new Node<Integer>(1);
		Node<Integer> b = new Node<Integer>(2);
		Node<Integer> c = new Node<Integer>(3);
		Node<Integer> d = new Node<Integer>(4);

		a.connect(b);
		a.connect(c);
		a.connect(d);

	    assertTrue("Testing connecting nodes", a.edgesTo.size() == 3);

	}
	
	
	
	@Test
	public void checkNullChildNode() 
	{
		Node<Integer> a = new Node<Integer>(1);
		a.connect(null);
	    assertTrue("Testing connecting a null Node", a.edgesTo.size() == 0);

	}
	
	@Test
	public void checkDisconnect() 
	{
		Node<Integer> a = new Node<Integer>(1);
		Node<Integer> b = new Node<Integer>(2);
		Node<Integer> c = new Node<Integer>(3);
		Node<Integer> d = new Node<Integer>(4);

		a.connect(b);
		a.connect(c);
		a.connect(d);
		a.disconnect(d);

	    assertTrue("Testing connecting nodes", a.edgesTo.size() == 2);

	}
	
	@Test
	public void checkNonConnectedNode() 
	{
		Node<Integer> a = new Node<Integer>(1);
		Node<Integer> b = new Node<Integer>(2);
		Node<Integer> c = new Node<Integer>(3);
		Node<Integer> d = new Node<Integer>(4);

		a.connect(b);
		a.connect(c);
		a.disconnect(d);

	    assertTrue("Testing connecting nodes", a.edgesTo.size() == 2);

	}
	
	@Test
	public void checkRemove() 
	{
		ArrayList<Node<Integer>> list = new ArrayList<Node<Integer>>();
		Node<Integer> a = new Node<Integer>(1);
		Node<Integer> b = new Node<Integer>(2);
		Node<Integer> c = new Node<Integer>(3);
		Node<Integer> d = new Node<Integer>(4);
		list.add(a);
		list.add(b);
		list.add(c);
		a.remove(list);


	    assertTrue("Testing connecting nodes", list.size() == 2);

	}
	
	@Test
	public void checkRemoveNull() 
	{
		ArrayList<Node<Integer>> list = new ArrayList<Node<Integer>>();
	    assertTrue("Testing connecting nodes", list.size() == 0);

	}

}
