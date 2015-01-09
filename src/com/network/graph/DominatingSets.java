package com.network.graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Generates Dominating Sets
 * 
 */

public class DominatingSets {
	int count = 0;
	public static final int DEC_LIFE_BY = 2;
	// Function to generate Dominating Sets which is called recursively till the number of
	// dead nodes in graph is less than number of nodes in network
	public void generateDominatingSets(ArrayList<Node> graph){

		List<Integer> domList = new ArrayList<Integer>();
		for(int i = 0; i<GraphGenerator.NUMBER_OF_NODES;i++){
			Node node = graph.get(i);
			if(!(domList.contains(node.getIndex())))
			{

				if(!(domList.containsAll(node.getAdj()))){
					if(!(secondhop(node,graph,domList))){
						if(!(node.getLife()== 0)){
							domList.add(node.getIndex());
						}					
					}
				}

			}
		}
		//Checking if dominating list produced is a spanning tree
		int checkednodes = 0;
		for(int i = 0; i<domList.size(); i++){
			for(Node node: graph){
				if(domList.get(i) == node.getIndex()){

					for(int adj: node.getAdj()){
						for(int j = 1; j<domList.size(); j++){
							if(domList.get(j) == adj){
								checkednodes++;
							}
						}

					}
				}
			}
		}
		// Display Dominating Set
		if(checkednodes >= domList.size()){
			System.out.println(domList);
		}
			// Decreasing power of nodes which are in dominating set
			ArrayList<Node> new_graph = decrementing_power(graph,domList);

			// Counting the number of dead nodes in graph
			for(Node node: new_graph){
				if(node.getLife()== 0){
					count++;
				}
			}
			
			// Generate a dominating set again if the number of dead nodes in graph
			// is less than number of nodes
			if(count<GraphGenerator.NUMBER_OF_NODES){
				generateDominatingSets(new_graph);
			}
	}

	// Calculating Second hop of nodes in graph returns True if dominating Set contains 
	// nodes second hop and False if it doesn't
	public boolean secondhop(Node node, ArrayList<Node> graph,List<Integer> domList){
		List<Integer> adjList = new ArrayList<Integer>();
		List<Integer> adjList1 = new ArrayList<Integer>();
		// Nodes adjacency List
		adjList = node.getAdj();
		boolean flag = true;
		for(Integer adj: adjList){
			// Find the adjacent node in graph
			for(Node nod : graph){
				if(nod.getIndex() == adj){
					//Now taking the adjacent nodes of adjacent nodes
					adjList1 = nod.getAdj();
					// Check if each node in adjList1 is present in dominating set
					for(Integer adjN : adjList1){
						if(domList.contains(adjN) ){
							flag = true;
						}
						else{
							// If it is false even once return false and quit
							flag = false;
							return flag;
						}
					}
				}
			}
		}
		return flag;
	}

	// decrementing power of each node in dominating set by DEC_LIFE_BY 
	// and returning new graph to the function
	public ArrayList<Node> decrementing_power(ArrayList<Node> graph,List<Integer> domList){
		ArrayList<Node> copy_graph = new ArrayList<Node>(graph);
		for(Node node: graph){
			if(domList.contains(node.getIndex())){
				copy_graph.remove(node);
				node.setLife(node.getLife()- DEC_LIFE_BY);
				copy_graph.add(node);
			}
		}
		return copy_graph;
	}
}