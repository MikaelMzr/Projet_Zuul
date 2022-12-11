import java.util.Stack;
import java.util.HashMap; 
/**
 * Classe Player 
 *
 * @author Mezouar Mikael
 * @version 31/12/2021
 */
public class Player
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String aNom;
    private int aPoidsPlayer;
    private int aPoidsMax;
    private Room aCurrentRoom;
    private Stack<Room> aRoomPrecedente;
    //private Item aItem;
    private ItemList aItems;
    //private ItemList aItemList;

    /**
     * Constructeur d'objets de classe Player
     */
    public Player(final Room pCurrentRoom,final String pN)
    {
        // initialisation des variables d'instance
        this.aNom=pN;
        this.aPoidsPlayer = 70; 
        this.aPoidsMax = 120;
        this.aCurrentRoom=pCurrentRoom;
        this.aRoomPrecedente=new Stack<Room>();
        // this.aItems= new HashMap<String, Item>();
        this.aItems= new ItemList();
    } // Player()
    
    /**
     * Accesseur 
     * @return la liste d'item du joueur
     */
    public ItemList getItems(){
        return this.aItems;
    } // getItems()

    /**
     * Accesseur 
     * @return le nom du joueur
     */
    public String getNom(){
        return this.aNom;
    } // getNom()
    
    /**
     * Accesseur 
     * @return la localisation du player
     */
    public Room getLocalisationP(){
        return this.aCurrentRoom;
    } // getLocalisationP()
    
    /**
     * Accesseur 
     * @return le poids que peut porter le joueur
     */
    public double getPoidsP(){
        return this.aPoidsPlayer;
    } // getPoidsP()
        
    /**
     * Accesseur 
     * @return le poids max
     */
    public double getPoidsMax(){
        return this.aPoidsMax;
    } // getPoidsMax()

    /**
     * Modificateur
     * Modifie la salle actuelle
     */
    public void setCurrentRoom(Room pR)
    {
        this.aCurrentRoom=pR;
    } // setCurrentRoom 
    
    /**
     * Accesseur 
     * @return la salle actuelle
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    } // getCurrentRoom  
    
    /**
     * Fonction qui gère la commande back
     * @return false si le back n'est pas possible , true sinon
     */
    public boolean back(){
        if(this.aRoomPrecedente.empty()){
            //this.aGui.println("pas de Room Precedente");
            return false;
        }
        
        else{
            
            this.aCurrentRoom=this.aRoomPrecedente.peek(); //renvoie le dernier element 
            this.aRoomPrecedente.pop();
            return true;
            // this.aGui.println( this.aP.getCurrentRoom().getLongDescription() );
            // if ( this.aP.getCurrentRoom().getImageName() != null ) 
                // this.aGui.showImage( this.aP.getCurrentRoom().getImageName() );
        }
    } // back
    
    /**
     * Fonction qui gère la commande goRoom et donc le déplacement
     * @return true si le déplacement n'est pas possible , false sinon
     */    
    public boolean goRoom( final Command pCommand ) 
    {
        String vDirection = pCommand.getSecondWord();

        // Try to leave current room.
        //this.aRoomPrecedente=this.aCurrentRoom;
        Room vNextRoom = this.getCurrentRoom().getExit( vDirection );

        if ( vNextRoom == null )
            return true;
        
        if (vNextRoom.getDescription().equals("Salle des Trophée") && this.aItems.estPresent("cle")==false){
            return true;
        }
        else {
            this.aRoomPrecedente.push(this.aCurrentRoom);
            this.aCurrentRoom=vNextRoom;
            
            return false;
        }
        
    } // goRoom 
    
    /**
     * Methode qui affiche l'inventaire du joueur
     * @return l'inventaire sous forme de string
     */
    public String inventaire(){
        if(this.aItems.estVide()){
            return "votre inventaire est vide";
        }
        else{ return "Vous avez: " +this.aItems.getItemString();}
    } // inventaire()
    
    /**
     * Methode qui test si le joueur peut prendre un Item par rapport au poids
     * @param pPI poids d'un item
     * @return true si le poids est valade sinon false 
     */
    public boolean PoidsValable(final double pPI){
        return this.aPoidsPlayer + pPI <= this.aPoidsMax;
    } // PoidsValable()
    
    /**
     * Modificateur
     * Modifie le poids maximum
     */
    public void setPoidsMax(int pD)
    {
        this.aPoidsMax=pD;
    } // setPoidsMax
} // Player
