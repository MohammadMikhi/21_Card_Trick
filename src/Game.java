import java.util.Scanner;

public class Game implements Playable {
	private Dealer game=Dealer.getInstance();
	private Scanner input=new Scanner(System.in);
	private Logger log=gameLogger.getInstance();
	public Game()
	{
		log.startLogger();
	}
	public void startGame()
	{
		game.dealCards();
		log.logMessage("Pick a card and memorize it!\nPress Enter to continue\n");
		System.out.println("Pick a card and memorize it!\nPress Enter to continue");
		input.nextLine();
		
	}
	public void playRound()
	{
		for(int i=0; i<3; i++)
		{
		game.dealCards();
		log.logMessage("Enter the stack number where your card is.\n");
		System.out.println("Enter the stack number where your card is.");
		int choice=input.nextInt();
		log.logMessage(Integer.toString(choice)+"\n");
		game.stacksTogether(choice);
		}
		log.logMessage("Your card is: "+game.cardGuess());
		System.out.println("Your card is: "+game.cardGuess());
		log.endLogger();
	}

}
