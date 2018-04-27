package nicola.severini.search.test;

import java.util.ArrayList;

import nicola.severini.search.classes.BreadthFirstSearch;
import nicola.severini.search.classes.Node;
import nicola.severini.search.classes.SearchResult;
import nicola.severini.search.classes.TreeSearch;

public class Test {

	public static void main(String[] args) {
		
		MyState s = new MyState(3, 2);
		Node root = new Node(s);
		TreeSearch tr = new TreeSearch(root);

		BreadthFirstSearch b = new BreadthFirstSearch(tr);
		
		SearchResult sr = b.search();
		System.out.println(sr.completeToString());
	}

}
