package ca.cglab.jagl.graph;

public class DirectedMultiGraph extends AbstractDirectedGraph
{
	// This method allows multi edges and loops
	public void addEdge(DefaultEdge e)
	{
		edges.add(e);
	}
}
