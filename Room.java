import java.util.HashMap; 
import java.util.Set;
/**
 * Classe Room
 *
 * @author Mezouar Mikael
 * @version 31/12/2021
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> aexits;
    private String aImageName;
    private ItemList aItems;
    
    /**
     * Constructeur d'objets de classe Room
     */    
    public Room(final String pD,final String pImage){
        this.aDescription=pD;
        this.aexits= new HashMap<String, Room>();
        this.aImageName=pImage;
        this.aItems= new ItemList();
    }// Room()

    /**
     * Accesseur de la liste d'Item
     * @return la liste d'item de la Room
     */    
    public ItemList getItem(){
        return this.aItems;
    }// getItem()
    
    /**
     * Accesseur de la description Room
     * @return la description de la Room
     */    
    public String getDescription(){ 
        return this.aDescription; 
    } // getDescription() 

    /**
     * Procedure pour mettre en place les exits des Room
     * @param pDirection la direction 
     * @param pRoom_suivante la Room dans la direction mis en 1er paramètre
     */    
    public void setExit(final String pDirection,final Room pRoom_suivante){
        this.aexits.put(pDirection,pRoom_suivante);
    }//setExits()
    
    /**
     * Methode qui recupere la Room dans la direction en paramtre
     * @param pdirection une direction
     * @return la Room dans cette direction
     */    
    public Room getExit(final String pdirection){
        return this.aexits.get(pdirection);
    } // getExit()
    
    /**
     * Methode qui affiche les sorties d'une Room
     * @return une String des sorties de la salle courante
     */
    public String getExitString ()
    {
       String vReturn="Exits :";  
       for(String vexit : this.aexits.keySet()){  //parcours les directions de la Room
           vReturn+=' '+ vexit;
       }
       return vReturn;
        
    } //getExitString()
    
    /**
     * Methode qui affiche une description d'une Room
     * @return une String avec le nom de la Room, ses sorties et les items
     * qui s'y trouvre
     */   
    public String getLongDescription()
    {
    return "You are " + this.aDescription + ".\n" + getExitString()+".\n"
    +aItems.getItemString();
    }// getLongDescription()
    
    /**
     * Accesseur de l'image de la Room
     * @return le nom de l'image
     */
    public String getImageName()
    {
         return this.aImageName;
    }// getImageName()

} // Room
