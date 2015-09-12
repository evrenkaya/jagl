package ca.cglab.jagl.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import ca.cglab.jagl.graph.DefaultVertex;
import ca.cglab.jagl.graph.Graph;
import ca.cglab.jagl.util.Stack;

public class DepthFirstIterator extends GraphTraversalIterator
{
	private final ArrayList<DefaultVertex> visitedVertices = new ArrayList<DefaultVertex>();
	private final Stack<DefaultVertex> stack = new Stack<DefaultVertex>();
	
	public DepthFirstIterator(Graph graph, DefaultVertex startingVertex)
	{
		super(graph);
		stack.push(startingVertex);
	}

	public boolean hasNext()
	{
		return !stack.isEmpty();
	}

	public DefaultVertex next() throws NoSuchElementException
	{
		DefaultVertex next = stack.pop();
		if(!visitedVertices.contains(next))
		{
			visitedVertices.add(next);
			Collection<DefaultVertex> neighbors = graph.getNeighborsOf(next);
			for(DefaultVertex v : neighbors)
			{
				stack.push(v);
			}
		}
		return next;
	}

	public Collection<DefaultVertex> getVisitedVertices()
	{
		return visitedVertices;
	}

}
