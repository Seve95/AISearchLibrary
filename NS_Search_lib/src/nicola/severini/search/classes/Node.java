package nicola.severini.search.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import nicola.severini.search.interfaces.IState;

public class Node {

	private Node father;
	private IState state;
	private boolean isVisited;
	
	public Node(IState state) {
		this.father = null;
		this.state = state;
		this.setVisited(false);
	}
	
	public Node(Node father, IState state) {
		this.father = father;
		this.state = state;
	}
	
	public Node getFather() {
		return father;
	}
	
	public IState getState() {
		return state;
	}
	
	
	public List<Node> getSons() {
		List<Node> res = new ArrayList<Node>();
		for(int i = 0; i< state.getSuccessors().size(); i++) {
			res.add(new Node(this, state.getSuccessors().get(i)));
		}
		
		return res;
	}
	
	public String toString() {
		return state.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((father == null) ? 0 : father.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (father == null) {
			if (other.father != null)
				return false;
		} else if (!father.equals(other.father))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	
	
}
