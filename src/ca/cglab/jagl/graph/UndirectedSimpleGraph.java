package ca.cglab.jagl.graph;

public class UndirectedSimpleGraph extends AbstractUndirectedGraph
{
	public void addEdge(DefaultEdge e)
	{
		super.addEdge(e);
		if(e.getFirstVertex().equals(e.getSecondVertex()))
		{
			throw new IllegalArgumentException("Loops are not allowed");
		}
		edges.add(e);
	}
}
