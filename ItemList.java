import java.util.HashMap; 
import java.util.Set;
/**
 * Classe ItemList
 *
 * @author MEZOUAR Mikael
 * @version 16/12/2021
 */
public class ItemList
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private HashMap<String,Item> aItemList;

    /**
     * Constructeur d'objets de classe ItemList
     */
    public ItemList()
    {
        // initialisation des variables d'instance
        this.aItemList = new HashMap<String, Item>();
    } // ItemList()

    /**
     * Procedure ajout item dans hashmap
     * @param pI un Item
     */
    public void addItem(final Item pI){
        
        this.aItemList.put(pI.getDescription(),pI);
    } // addItem()
    
    /**
     * Procedure retire item dans hashmap
     * @param pN est le Nom de l'item de type string
     */
    public void removeItem(final String pN){
        this.aItemList.remove(pN);
    } // removeItem()
    
    /**
     * Methode retour Item (adresse) associé a une string
     * @param pItem nom de l'item sous forme de string
     * @return un Item
     */
    public Item getItem(final String pItem){
        return this.aItemList.get(pItem);
        
    } // getItem()
    
    /**
     * Methode retour Item présents dans une Room
     * @return l'Item de la Room
     */
    public String getItemString(){
        String vItems = "";
        Set<String> vKeys = this.aItemList.keySet();
        for(String item : vKeys)
        {
            vItems += " " + item;
        }
        return vItems;
    } // getItemString()
    
    /**
     * Methode test presence Item dans inventaire joueur
     * @param pNom Nom de l'Item a chercher
     * @return Boolean true ou false si vide ou non
     */
    public boolean estPresent(final String pN){
        return aItemList.containsKey(pN);
    } // estPresent()
    
    /**
     * Methode qui vérifie si la liste est vide
     * @return true si vide sinon false
     */
    public boolean estVide(){
        return aItemList.isEmpty();
    } // estVide()
} //ItemList
