package ecom.Demowebshop.genericUtility;

import java.util.Random;

public class JavaUtility {
	public int randomNumber(int limit) {
		Random r = new Random();
		return r.nextInt(limit);
	}
	
	public int randomNumber() {
		return new Random().nextInt();
	}
}
