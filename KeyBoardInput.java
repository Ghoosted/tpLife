/**
 * Represents the keyboard input.  Used for getting input from keyboard in console applications.
 * 
 * @author Paul Paiement 
 * @version 1.0
 */
import java.io.*;
public class KeyBoardInput
{
    // properties
    private BufferedReader br;
    private String inputLine;    

    /**
     * Initializes the keyboard.
     */
    public KeyBoardInput()
    {
        br = new BufferedReader(new InputStreamReader(System.in) );
    }
    
    /**
     * Displays a prompt and reads a character string from the keybooard until [ENTER] key is hit.
     */
    public String readString(String prompt)
    {
        System.out.print(prompt);
        try
        {
            inputLine = br.readLine(); 
        }
        catch( Exception e )
        {
            inputLine = e.getMessage();
            e.printStackTrace();
        }
        return inputLine;
    }
    
    /**
     * Displays a prompt and reads a double value from the keybooard.
     */
    public double readDouble( String prompt )
    {
        double value=0.0;
        try
        {
            value = Double.parseDouble( readString( prompt ) );
        }
        catch ( NumberFormatException e )
        {
            e.printStackTrace();
        }
        return value;
    }
    
    /**
     * Displays a prompt and reads an integer value from the keybooard.
     */
    public int readInt( String prompt )
    {
        int value=0;
        try
        {
            value = Integer.parseInt( readString( prompt ) );
        }
        catch ( NumberFormatException e )
        {
            e.printStackTrace();
        }
        return value;
    }
    /**
     * Displays a prompt and reads an boolean value from the keybooard.
     */
    public boolean readBoolean( String prompt )
    {
        boolean value=false;
		String s = readString( prompt );
		if( s.compareToIgnoreCase( "true" ) == 0)
		{
			value = true;
		} 
		else if ( s.compareToIgnoreCase( "false" ) != 0) 
		{
		  new Exception( "Invalid boolean value" ).printStackTrace();
		}		
        return value;
    }

    /**
     * Displays a prompt and reads a character from the keybooard.
     */
    public char readChar( String prompt )
    {
		char c = '\0';
		String s = readString( prompt );
		if( s.length() > 0)
		{
			c = s.charAt(0);
		} 
		else
		{
		  new Exception( "Input is not a single character" ).printStackTrace();
		}		
        return c;
    }
	
    /* used for debugging only */
    public static void main( String [] args )
    {
        KeyBoardInput kb = new KeyBoardInput();
        System.out.println( kb.hashCode() );
        String line;
        double dblVal;
        int intVal;
		boolean boolVal;
		char charVal;
        line = kb.readString( "Entrez une chaine: ");
        System.out.println( line );
        dblVal = kb.readDouble( "Entrez une valeur reel: " );
        System.out.println( dblVal );
        intVal = kb.readInt( "Entrez une valeur entiere: " );
        System.out.println( intVal );
        boolVal = kb.readBoolean( "Entrez true ou false: " );
        System.out.println( boolVal );
        charVal = kb.readChar( "Entrez un caractere: " );
        System.out.println( charVal );

    }
}