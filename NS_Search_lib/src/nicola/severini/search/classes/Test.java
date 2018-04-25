package nicola.severini.search.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		MultiHashMap<Integer, String> m = new MultiHashMap();
		m.put(1, "test");
		m.put(1, "lmao");
		m.put(2, "test");
		m.put(2, "test");
		m.put(3, "testf");
		m.put(3, "tests");
		
		System.out.println(m.getLastValues().get(0));
		
	}

}
