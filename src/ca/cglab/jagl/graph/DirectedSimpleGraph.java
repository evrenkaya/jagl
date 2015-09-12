package ca.cglab.jagl.graph;

public class DirectedSimpleGraph extends AbstractDirectedGraph
{
	public void addEdge(DefaultEdge e)
	{
		if(e.getFirstVertex().equals(e.getSecondVertex()))
		{
			throw new IllegalArgumentException("Loops are not allowed");
		}
		edges.add(e);
	}
}
