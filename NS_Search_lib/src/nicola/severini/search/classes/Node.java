package nicola.severini.search.classes;

import java.util.ArrayList;
import java.util.List;

import nicola.severini.search.interfaces.IState;

public class Node {

	private Node father;
	private IState state;
	
	public Node(IState state) {
		this.father = null;
		this.state = state;
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
}
