import java.util.Stack;

public class Dealer {
	private static Dealer instance=null;
	private Deck deck=Deck.getInstance();
	private Stack<String> cards=new Stack<>();
	private Stack<String> s1=new Stack<>();
	private Stack<String> s2=new Stack<>();
	private Stack<String> s3=new Stack<>();
	private Logger log=gameLogger.getInstance();


	private Dealer()
	{
		cards=deck.get21Cards();
		log.startLogger();
	}
	public static Dealer getInstance()
	{
		if (instance == null)
		{
		    instance = new Dealer ();
		}		
		return instance;
	}
	
	
	public void splitInto3()
	{
		while(!cards.isEmpty())
		{
			s1.push(cards.pop());
			s2.push(cards.pop());
			s3.push(cards.pop());
		}
	}
	
	
	public void dealCards()
	{
		int i;
		System.out.println("Stack (1) \tStack (2) \tStack (3)");
		log.logMessage("Stack (1) \tStack (2) \tStack (3)\n");
		splitInto3();
		for(i=0; i<s1.size(); i++)
		{
			System.out.println();
			log.logMessage("\n");
			System.out.print(s1.get(i) +" \t");
			log.logMessage(s1.get(i) +" \t");
			System.out.print(s2.get(i)+" \t");
			log.logMessage(s2.get(i) +" \t");
			System.out.print(s3.get(i)+" \t");
			log.logMessage(s3.get(i) +" \t");
		}
		System.out.println("\n");
		log.logMessage("\n\n");
	}
	
	
	public void stacksTogether(int num)
	{
		switch(num)
		{
			case 1: {
				while(!s2.isEmpty())
					cards.push(s2.pop());
				while(!s1.isEmpty())
					cards.push(s1.pop());
				while(!s3.isEmpty())
					cards.push(s3.pop());
			break;
			}
			case 2:{
				while(!s1.isEmpty())
					cards.push(s1.pop());
				while(!s2.isEmpty())
					cards.push(s2.pop());
				while(!s3.isEmpty())
					cards.push(s3.pop());
			break;
			}
			case 3:{
				while(!s2.isEmpty())
					cards.push(s2.pop());
				while(!s3.isEmpty())
					cards.push(s3.pop());
				while(!s1.isEmpty())
					cards.push(s1.pop());
			break;
			}
		}
	}
	public String cardGuess()
	{
		return cards.get(10);
	}

}
