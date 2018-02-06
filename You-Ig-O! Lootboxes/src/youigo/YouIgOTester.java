package youigo;

import java.util.Random;
import java.util.Scanner;

public final class YouIgOTester {

	private static boolean running=true;
	
	private static final Random rand= new Random();
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		System.out.println("Preforming setup...");
		ProbabilityGrid grid = new ProbabilityGrid(5, 5, "probabilites.txt");
		while(grid.isReady()) {}
		System.out.println("Setup complete!");
		
		do {
			int packLevel=-1;
			do {
				System.out.println("What level of Pack would you like?");
				packLevel=s.nextInt();
			}while(packLevel<=0||packLevel>5);
			
			//Minus 1 to have users see 1-5 but computer see 0-4
			BoosterPack pack = new BoosterPack(packLevel-1, rand, grid);
			
			//Open and display
			//Go again?
			
		}while(running);
		s.close();
	}

}
