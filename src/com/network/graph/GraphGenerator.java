package com.network.graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/*
 * Generates graph 
 * 
 */

public class GraphGenerator {
	private static final int LIFE = 10;
	public static final int NUMBER_OF_NODES = 10;
	private static ArrayList<Node> graph = new ArrayList<Node>();
	public ArrayList<Node> getGraph() {
		return graph;
	}
	// Function that creates graph randomly depending upon NUMBER_OF_NODES
	public static ArrayList<Node> generateGraph(){
		for(int index = 1;index <= NUMBER_OF_NODES; index++){
			List<Integer> adjlist = new ArrayList<Integer>();
			Node node = new Node();
			node.setIndex(index);
			node.setLife(LIFE);
			Random rand = new Random();
			// Generate degree of node randomly
			int deg = rand.nextInt(5)+NUMBER_OF_NODES/10;
			// Traverse through the graph to check if the node is already
			// adjacent to any other node and add those nodes to adjacency list
			// to current node
			for(Node n: graph){
				if(n.getAdj().contains(index)){
					adjlist.add(n.getIndex());
				}
			}
			int j = adjlist.size();

			while(j < deg){
				int adjNode = rand.nextInt(NUMBER_OF_NODES-index+1)+index;
				if((adjNode != node.getIndex())&&(adjNode<=NUMBER_OF_NODES) 
						&& (adjlist.contains(adjNode)!= true))
				{
					adjlist.add(adjNode);
					j++;
				}	

				//If the adjacency list already contains the node after it
				boolean containsAllGreater = false;
				for(int i=index+1 ; i<=NUMBER_OF_NODES ; i++){
					if(adjlist.contains(i)){
						containsAllGreater = true;
					}else{
						containsAllGreater = false;
						break;
					}
				}

				//Break the loop: If the node contains all the elements greater than its value
				//Or if the degree of node is bigger that the number of elements left
				if(containsAllGreater || (deg-j)>(NUMBER_OF_NODES-index)){
					break;
				}
			}
			node.setAdj(adjlist);
			graph.add(node);	
		}
		return graph;
	}
}