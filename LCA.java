import java.util.ArrayList;

public class LCA {
	
	public static Node LowestCommonAncestor(ArrayList<Node> DAG, Node a, Node b)
    {
		if(validate(DAG, a, b))
    	{
	    	ArrayList<Node> roots = new ArrayList<Node>();
	    	ArrayList<Node> ancestorsOfA = new ArrayList<Node>();
	    	ArrayList<Node> ancestorsOfB = new ArrayList<Node>();
	    	ArrayList<Node> ancestorsAB = new ArrayList<Node>();
	    	
	        for(int i = 0; i < DAG.size(); i++)
	        {
	        	if(DAG.get(i).indegree == 0)
	        	{
	        		roots.add(DAG.get(i));
	        	}
	        }
	        
	        
	        ancestorsOfA.add(a);
	        ancestorsOfB.add(b);
	        
	       
		   for(int i = 0; i < roots.size(); i++)
		   {
		      	if(validateRoot(roots.get(i)))
		       	{
		        	findAncestors(roots.get(i), ancestorsOfA, ancestorsOfB);
		        	
		       	}
		      	else
		      	{
		      		return null;
		      	}
		   }
        	
	        
	        ancestorsAB = common(ancestorsOfA, ancestorsOfB);
	        
	        
        	

	        if(ancestorsAB.size() == 0)
	        {
	        	return null;
	        }
	
	        boolean valid = true;
	        while (ancestorsAB.size() != 0) 
	        {
				for (int i = 0; i < ancestorsAB.size(); i++) 
				{
					for (int j = 0; j < ancestorsAB.size(); j ++) 
					{
						Node current = ancestorsAB.get(j);
						if (common(ancestorsAB, current.edgesTo).size() > 0)
						{
							valid = false;
						}
					}
					if(valid)
	            	{
	            		return ancestorsAB.get(0);
	            	}
            		else if(common(ancestorsAB, ancestorsAB.get(i).edgesTo).size() > 0)
					{
						ancestorsAB.remove(i);
					}
					
				}
			} 
	        return ancestorsAB.get(0);
    	}
    	return null;
        
    }

	public static boolean validate(ArrayList<Node> DAG, Node a, Node b)
    {
		if(DAG == null || a == null || b ==null || !DAG.contains(a) || !DAG.contains(b))
		{
			return false;
		}
		return true;
    }
	public static boolean validateRoot(Node root)
    {
	
		if(root.edgesTo == null || root.edgesTo.size() == 0)
		{
			System.out.print("here");
			return false;
		}
		
		return true;
	
    }
	
	
	public static void findAncestors(Node root, ArrayList<Node> ancestorsOfA, ArrayList<Node> ancestorsOfB)
    {
		Node<Integer> b = new Node<Integer>(1);

		for(int i = 0; i < root.edgesTo.size(); i++)
    	{
			
    		Node current = (Node) root.edgesTo.get(i);
    		if(!(ancestorsOfA.contains(current) || ancestorsOfB.contains(current)))
    		{
    			findAncestors(current, ancestorsOfA, ancestorsOfB);
    		}
    		if(ancestorsOfA.contains(current))
    		{
    			ancestorsOfA.add(root);
    		}
    		if(ancestorsOfB.contains(current))
    		{
    			ancestorsOfB.add(root);	
    		}
    	}
    }
	
	public static ArrayList<Node> common(ArrayList<Node> ancestorsOfA, ArrayList<Node> ancestorsOfB) 
	{
		ArrayList<Node> common = new ArrayList<Node>();
		for(int i =0; i < ancestorsOfA.size(); i++)
		{
			if(ancestorsOfB.contains(ancestorsOfA.get(i)))
			{
				common.add(ancestorsOfA.get(i));
			}
		}
		return common;
	}
	

	
	public static Boolean isCyclicUtil(ArrayList<Node> list, Node tmp, ArrayList<Node> visited, ArrayList<Node> stack, boolean hasCycle)
    {
		visited.add(tmp);
		stack.add(tmp);
		
		for(int i = 0; i < tmp.edgesTo.size(); i++)
		{
			Node a = (Node) tmp.edgesTo.get(i);
			if(!visited.contains(a)) 
			{
				hasCycle = hasCycle || isCyclicUtil(list, a, visited, stack, hasCycle);
			}
			else if(stack.contains(a))
			{
				hasCycle = true;
				return hasCycle;
			}
		}
		stack.remove(tmp);
		return hasCycle;
    }
 
    public static Boolean isCyclic(ArrayList<Node> DAG)
    {
				
				for(int i = 0; i < DAG.size(); i++)
				{
					ArrayList<Node> visited = new ArrayList<Node>();
					ArrayList<Node> stack = new ArrayList<Node>();
					Node src = DAG.get(i);
					boolean hasCycle = false;
					hasCycle = isCyclicUtil(DAG, src, visited, stack, hasCycle);
					if(hasCycle)
					{
						return true;
					}
				}
		        return false;
		    }
	}


