import java.util.HashMap; 
import java.util.Set;
/**
 * Classe Item
 *
 * @author Mezouar Mikael
 * @version 31/12/2021
 */
public class Item
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int aPoids;
    private String aDescription; 
    

    /**
     * Constructeur d'objets de classe Items
     */
    public Item(final int pPoids, final String pDescription)
    {
        // initialisation des variables d'instance
        this.aPoids=pPoids;
        this.aDescription=pDescription;
    } //Item()
    
    /**
     * Methode qui affiche le poids de l'item
     * @return le poids de l'item
     */
    public int getPoids(){
        return this.aPoids;
    } //getPoids()
    
    /**
     * Methode qui affiche la description l'item
     * @return la description de l'item
     */
    public String getDescription(){
        return this.aDescription;
    } //getDescription()

} //Item
