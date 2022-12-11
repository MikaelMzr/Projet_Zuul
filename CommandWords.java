 /**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2019.09.25
 */
public class CommandWords
{
    // a constant array that will hold all valid command words
    private final String[] aValidCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        this.aValidCommands = new String[10];
        this.aValidCommands[0] = "go";
        this.aValidCommands[1] = "help";
        this.aValidCommands[2] = "quit";
        this.aValidCommands[3] = "look";
        this.aValidCommands[4] = "eat";
        this.aValidCommands[5] = "back";
        this.aValidCommands[6] = "take";
        this.aValidCommands[7] = "drop";
        this.aValidCommands[8] = "test";
        this.aValidCommands[9] = "inventaire";
    } // CommandWords()

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand( final String pString )
    {
        for ( int i=0; i<this.aValidCommands.length; i++ ) {
            if ( this.aValidCommands[i].equals( pString ) )
                return true;
        } // for
        // if we get here, the string was not found in the commands
        return false;
    } // isCommand()
    
    
    /**
     * Fonction qui return une liste des commandes qui sont valides
     */
    
    public String getCommandList()
    {
        String vCommande="";
        for(String command: this.aValidCommands){
            vCommande+=(command+" ");
        }
        return vCommande;
    } // getCommandList()
    
} // CommandWords 