package ca.cglab.jagl.graph;

import java.util.Collection;

public interface DirectedGraph extends Graph
{
	/**
	 * A direct predecessor of a vertex is another vertex that
	 * is at the tail of a directed edge connecting the two vertices.
	 * 
	 * @param v A vertex
	 * @return A Collection view of the direct predecessors of <code>v</code>
	 */
	Collection<DefaultVertex> getPredecessorsOf(DefaultVertex v);
}
