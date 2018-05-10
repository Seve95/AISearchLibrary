package nicola.severini.search.test;

import nicola.severini.search.classes.*;


public class Main {

	public static void main(String[] args) {
	
		SquareState initState = new SquareState();
		
		Node root = new Node(initState);
		TreeSearch tree = new TreeSearch(root);
		
//		tree.addNewFrontier();
//		System.out.println(tree.getFrontier().size());
//		
//		tree.addNewFrontier();
//		System.out.println(tree.getFrontier().size());
//		
//		for (Node n : tree.getFrontier()) {
//			System.out.println(n.getState());
//		}
		
		//System.out.println(tree.getFrontier().get(0).getState());
		
		Long init = System.currentTimeMillis();
//		
//		BreadthFirstSearch bfs = new BreadthFirstSearch(tree);
		DepthFirstSearch dfs = new DepthFirstSearch(tree);
//		
		SearchResult res = dfs.search();
		System.out.println(res.simpleToString());
		Long fin = System.currentTimeMillis();
		
		System.out.println("Time: " + ((fin - init)/1000) + "sec");

	}

}
