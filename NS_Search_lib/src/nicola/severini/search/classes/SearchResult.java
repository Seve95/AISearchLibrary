package nicola.severini.search.classes;


import nicola.severini.search.interfaces.IState;

public class SearchResult {
	
	private IState goalState;
	
	public SearchResult(IState goalState) {
		this.goalState = goalState;
	}

	public SearchResult() {
	}

	public IState getState() {
		return goalState;
	}

	public void setState(IState goalState) {
		this.goalState = goalState;
	}

	public String simpleToString() {
		if (this.goalState == null) {
			return "Not found";
		} else return this.goalState.toString(); 
	}
}
