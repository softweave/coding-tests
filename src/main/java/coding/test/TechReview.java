package coding.test;

import java.util.Observable;
import java.util.Observer;

public class TechReview implements Observer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 3;
		int y = 1;
		if (x == y) {
			System.out.println("Equal");
		} else {
			System.out.println("Not equal");
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}