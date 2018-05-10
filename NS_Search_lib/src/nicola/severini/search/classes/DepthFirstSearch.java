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
	
//	public SearchResult search(int limit) {
//		recursiveSearch(0,limit);
//		return this.sr;
//	}
	
//	private void recursiveSearch(int level, int limit) {
//		System.out.println(level);
//		if(level<limit) {
//			boolean res = tree.addFirstNode(level);
//			if(tree.getFrontier(level).get(tree.getFrontier(level).size() - 1).getState().isGoalTest()) {
//				sr.setState(tree.getFrontier(level).get(tree.getFrontier(level).size() - 1).getState());
//				return;
//			} else {
//				if(res == false) recursiveSearch(level - 1, limit);
//				else recursiveSearch(level + 1, limit);
//			}
//		} else {
//			recursiveSearch(level - 1, limit);
//		}
//	}
	public SearchResult search() {
		try {
			recursiveSearch(tree.getFrontier().get(0));
		} catch (GoalFoundException e) {
			System.out.println("FOUND!");
		}
		return this.sr;
	}
	
	private void recursiveSearch(Node n) throws GoalFoundException {
		System.out.println(n.getState());
		if(n.getState().isGoalTest()) {
			this.sr.setState(n.getState());
			throw new GoalFoundException("Found it");
		} 
		for(Node s : n.getSons()) {
			recursiveSearch(s);
		}
	}
}
