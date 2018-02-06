package youigo;

import java.util.ArrayList;
import java.util.Random;

public class BoosterPack {

	private Card[] cards= new Card[10];
	
	private int level;
	
	//Should point to the Random in YouIgOTester
	private Random random;
	
	private ProbabilityGrid grid;
	
	private ArrayList<Card> possibleCards = new ArrayList<>();
	
	public BoosterPack(int lvl,Random r,ProbabilityGrid g, ArrayList<Card> allCards) {
		level=lvl;
		random=r;
		grid=g;
		possibleCards=allCards;
		fillArray();
	}
	
	private void fillArray() {
		
		for(int i=0;i<cards.length-1;i++) {
			double roll=random.nextDouble();
			
			boolean inserted=false;
			do {
				Card c = getRandomCard();
				double prob = grid.getProbablity(level, c.getLevel());
			
				if(prob>=roll) {
					cards[i]=new Card(c);
					inserted=true;
				}
			}while(!inserted);
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
	
	private Card getRandomCard() {
		int slot=random.nextInt(possibleCards.size());
		return possibleCards.get(slot);
	}

}
