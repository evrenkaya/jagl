package ca.cglab.jagl.graph;

import java.util.Collection;

/**
 * In graph theory, a graph G is defined as a non-empty set of vertices and a set of edges.
 * This interface specifies possible operations on all types of graphs.
 * All graphs should be able to add/remove vertices/edges, provide an
 * iterator over the collection of vertices and edges, and keep track of
 * the vertex and edge count. The storing of the vertices and edges is
 * left up to all implementing classes.
 * <br>
 * <br>
 * Created on June 26, 2015
 * 
 * @author Evren Kaya
 */
public interface Graph
{
	/**
	 * Adds the given vertex to the graph.
	 * 
	 * @param v A vertex
	 */
	void addVertex(DefaultVertex v);
	
	/**
	 * Adds the given edge to the graph.
	 * 
	 * @param e An edge
	 */
	void addEdge(DefaultEdge e);
	
	/**
	 * @param v A vertex
	 */
	void removeVertex(DefaultVertex v);
	
	/**
	 * @param e An edge
	 */
	void removeEdge(DefaultEdge e);
	
	void removeAllVertices();
	
	void removeAllEdges();
	
	/**
	 * @return Number of vertices currently in this graph
	 */
	int numVertices();
	
	/**
	 * @return Number of edges currently in this graph
	 */
	int numEdges();
	
	/**
	 * @param v A vertex
	 * @return True if vertex is in the graph, false if it is not contained or it is null
	 */
	boolean containsVertex(DefaultVertex v);
	
	/**
	 * @param e An edge
	 * @return True if edge is in the graph, false if it is not contained or it is null
	 */
	boolean containsEdge(DefaultEdge e);
	
	/**
	 * @return A collection of all vertices in this graph.
	 */
	Collection<DefaultVertex> getVertices();
	
	/**
	 * @return A collection of all edges in this graph
	 */
	Collection<DefaultEdge> getEdges();
	
	/**
	 * @param v The vertex to get the neighbors of
	 * @return A collection view of all the traversable vertex neighbors of <code>v</code>
	 */
	Collection<DefaultVertex> getNeighborsOf(DefaultVertex v);
}
