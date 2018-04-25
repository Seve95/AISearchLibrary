package nicola.severini.search.interfaces;
import java.util.List;

public interface IState {

	boolean isGoalTest(); 
	List<IState> getSuccessors();
	
}
