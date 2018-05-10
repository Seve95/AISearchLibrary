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
		recursiveSearch(0,this.tree ,limit);
		return this.sr;
	}
	
	private void recursiveSearch(int level, TreeSearch tree, int limit) {
		
		if(!limitReached) { //first phase
			if(level < limit) {
				TreeSearch newTree = tree;
				newTree.addNewSingleNode();
				recursiveSearch(level + 1, newTree, limit);
			} else {
				limitReached = true;
				recursiveSearch(level - 1, tree, limit);
			}
		} else { //second phase
			
		}
		
	}
}
