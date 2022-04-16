import java.util.Collections;
import java.util.Stack;

public class Deck {
	private static Deck instance=null;
	private String[] suits= {"Diamonds ", "Hearts ", "Spades ", "Clubs "};
	private String[] vals= {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	private Stack<String> cards= new Stack<>();
	
	private Deck() {
		for(int i=0; i<suits.length; i++)
		{
			for(int j=0; j<vals.length; j++)
			{
				cards.push(suits[i]+vals[j]);
			}
		}
	}
	
	public static Deck getInstance() {
		if (instance == null)
		{
		    instance = new Deck ();
		}		
		return instance;
	}
	
	private void shuffleCards()
	{
		Collections.shuffle(cards);
	}
	
	public Stack<String> get21Cards()
	{
		shuffleCards();
		Stack<String> temp= new Stack<>();
		for(int i=0; i<21; i++)
			temp.add(cards.get(i));
		return temp;
	}
}
