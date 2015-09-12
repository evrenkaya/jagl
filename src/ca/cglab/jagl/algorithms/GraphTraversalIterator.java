package ca.cglab.jagl.algorithms;

import java.util.Collection;

import ca.cglab.jagl.graph.DefaultVertex;
import ca.cglab.jagl.graph.Graph;

/**
 * An abstract class to represent any kind of graph traversal object 
 * that advances in its iteration only when told to.
 * 
 * Created on June 26, 2015
 * 
 * @author Evren Kaya
 */
public abstract class GraphTraversalIterator
{
	protected final Graph graph;
	
	public GraphTraversalIterator(Graph graph)
	{
		this.graph = graph;
	}
	
	public abstract boolean hasNext();
	
	public abstract DefaultVertex next();
	
	public abstract Collection<DefaultVertex> getVisitedVertices();

}
