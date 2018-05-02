package nicola.severini.search.classes;

public class DepthFirstSearch {
	
	private TreeSearch tree;
	private SearchResult sr;
	private boolean limitReached;
	
	public DepthFirstSearch(TreeSearch tree) {
		this.tree = tree;
		sr = new SearchResult();
		limitReached = false;
	}
	
	public SearchResult search(int limit) {
		recursiveSearch(0,0,limit);
		return this.sr;
	}
	
	private void recursiveSearch(int level, int numberOfNodes, int limit) {
		
		Node currentNode = tree.getFrontier(level).get(numberOfNodes);
		if(currentNode.getState().isGoalTest()) {
			System.out.println("Found!");
			sr.setState(currentNode.getState());
			return;
		} else {
			if (level < limit) {
				System.out.println("Level<limit: " + level);
				if(!limitReached) tree.addNewSingleNode();
				recursiveSearch(level+1, numberOfNodes, limit);
			} else { 
				System.out.println("Level = Limit: " + level);
				limitReached = true;
				if(tree.hasMoreBrothers(level, numberOfNodes)) {
					tree.addNewBrother(level, numberOfNodes);
					recursiveSearch(level, numberOfNodes+1, limit);
				}
				else {
					tree.addNewBrother(level-1, numberOfNodes);
					recursiveSearch(level-1, numberOfNodes+1, limit);
				}
			}
		}
	}
}
