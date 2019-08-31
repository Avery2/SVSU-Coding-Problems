import java.util.Random;

public class Baloni {

	public static void main(String[] args) {
		Random rand = new Random();

		// create inputs
		final int NUM_BLOONS = 100;
		final int MAX_HEIGHT = 50;
		int n = rand.nextInt(NUM_BLOONS);
		int[] h = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = rand.nextInt(MAX_HEIGHT);
		}
		
		//show inputs
		System.out.printf("n %d\n",n);

		//visual
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < h[i]; j++) {
				System.out.print(" ");
			}
			System.out.println("O");
		}
	}

}
