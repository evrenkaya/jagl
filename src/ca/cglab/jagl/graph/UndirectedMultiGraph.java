package ca.cglab.jagl.graph;

public class UndirectedMultiGraph extends AbstractUndirectedGraph
{
	// This method allows multi edges and loops
	public void addEdge(DefaultEdge e)
	{
		super.addEdge(e);
		edges.add(e);
	}
}
