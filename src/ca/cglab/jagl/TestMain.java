package ca.cglab.jagl;

import ca.cglab.jagl.algorithms.ConnectedComponentsGraphAlgorithm;
import ca.cglab.jagl.graph.DefaultEdge;
import ca.cglab.jagl.graph.DefaultVertex;
import ca.cglab.jagl.graph.UndirectedGraph;
import ca.cglab.jagl.graph.UndirectedSimpleGraph;

public class TestMain
{

	public static void main(String[] args)
	{
		final UndirectedGraph graph = new UndirectedSimpleGraph();
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++)
		{
			graph.addVertex(new DefaultVertex());
		}
		
		for(DefaultVertex first : graph.getVertices())
		{
			int counter = 0;
			for(DefaultVertex second : graph.getVertices())
			{
				if(first != second && counter % 500 == 0)
				{
					DefaultEdge e = new DefaultEdge(first, second, 1, DefaultEdge.UNDIRECTED);
					graph.addEdge(e);
				}
				counter++;
			}
			
		}
		new ConnectedComponentsGraphAlgorithm(graph).run();
		long endTime = System.currentTimeMillis();
		long elapsed = endTime - startTime;
		System.out.println("Elapsed: " + elapsed);
		System.out.println(graph.numEdges());
	}
}
