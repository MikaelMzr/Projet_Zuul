/**
 * Classe Game
 *
 * @author Mezouar Mikael
 * @version 31/12/2021
 */
public class Game
{
	private UserInterface aGui;
	private GameEngine aEngine;

    /**
     * Create the game and initialise its internal map. Create the inerface and link to it.
     */
    public Game() 
    {
        this.aEngine = new GameEngine();
        this.aGui = new UserInterface( this.aEngine );
        this.aEngine.setGUI( this.aGui );  
    }// Game() 
} // Game  