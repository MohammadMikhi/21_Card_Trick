import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class gameLogger implements Logger{
	private String logFileName= ""+System.currentTimeMillis()/1000+".dat";
	BufferedWriter out;
	private static gameLogger instance=null;
	private gameLogger()
	{
		
	}
	public static gameLogger getInstance() {
		if (instance == null)
		{
		    instance = new gameLogger ();
		}		
		return instance;
	}
	public void startLogger ()
	{
		try
		{
		    out= new BufferedWriter (new OutputStreamWriter (new FileOutputStream (new File (logFileName), true)));
		}
		catch (IOException fileException)
		{
		    System.out.println ("Error in log file!");
		}
	}

	public void endLogger ()
	{
		try
		{
		    out.close ();
		}
		catch (IOException fileException)
		{
		    System.out.println ("Error in log file!");
		}
	}

	public void logMessage (String message)
	{
		try
		{
		    out.write (message);
		}
		catch (IOException fileException)
		{
		    System.out.println ("Error in log file!");
		}
	}
}
