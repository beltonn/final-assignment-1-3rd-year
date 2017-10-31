import java.util.ArrayList;

public class LCA {
	
	public static ArrayList<Node> LowestCommonAncestor(ArrayList<Node> DAG, Node a, Node b)
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
	        
	        if(validateRootList(roots))
        	{
		        for(int i = 0; i < roots.size(); i++)
		        {
		        	findAncestors(roots.get(i), ancestorsOfA, ancestorsOfB);
		        }
        	}
	        
	        ancestorsAB = common(ancestorsOfA, ancestorsOfB);
	        
	        if(ancestorsAB.size() == 0)
	        {
	        	return null;
	        }
	        else if(ancestorsAB.size() == 1)
	        {
	        	return ancestorsAB;
	        }
	        boolean valid = true;
	        while (ancestorsAB.size() > 1) 
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
	            		return ancestorsAB;
	            	}
            		else if(common(ancestorsAB, ancestorsAB.get(i).edgesTo).size() > 0)
					{
						ancestorsAB.remove(i);
					}
					
				}
			}
	        return ancestorsAB;
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
	public static boolean validateRootList(ArrayList<Node> roots)
    {
		for(int i = 0; i < roots.size(); i++)
		{
			if(roots.get(i).edgesTo == null || roots.get(i).edgesTo.size() == 0)
			{
				return false;
			}
		}
		return true;
	
    }
	
	
	public static void findAncestors(Node root, ArrayList<Node> ancestorsOfA, ArrayList<Node> ancestorsOfB)
    {
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
	
	public static boolean isCyclicUtil(ArrayList<Node> DAG)
    {
		
    }
	
	private static boolean isCyclic(ArrayList<Node> list, Node tmp, ArrayList<Node> visited, ArrayList<Node> stack, boolean hasCycle)
	{
		
	}

}
