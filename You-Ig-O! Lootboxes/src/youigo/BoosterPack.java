package youigo;

import java.util.Random;

public class BoosterPack {

	private Card[] cards= new Card[10];
	
	private int level;
	
	//Should point to the Random in YouIgOTester
	private Random random;
	
	private ProbabilityGrid grid;
	
	public BoosterPack(int lvl,Random r,ProbabilityGrid g) {
		level=lvl;
		random=r;
		grid=g;
		fillArray();
	}
	
	private void fillArray() {
		
		for(int i=0;i<cards.length-1;i++) {
			double roll=random.nextDouble();
			
			double prob = grid.getProbablity(level, i%5);
			
			if(prob>=roll) {
				//Add card 
			}
		}
		
	}

	public void print() {
		System.out.println("---------------------------------");
		for(Card c: cards) {
			System.out.println(c.toString());
		}
		System.out.println("---------------------------------");
	}

	public int getLevel() {
		return level;
	}

	public double getTotalValue() {
		double toRet=0;
		for(Card c: cards) {
			toRet+=c.getValue();
		}
		return toRet;
	}

}
