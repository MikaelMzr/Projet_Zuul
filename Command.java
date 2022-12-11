/**
 * Classe Command
 *
 * @author Mezouar Mikael
 * @version 31/12/2021
 */ 

public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    /**
    * Constructeur d'objets de classe Command
    */
    public Command(final String pC, final String pS){
        this.aCommandWord=pC;
        this.aSecondWord=pS;
    }// Command()
    
    /**
    * Methode getCommandWord
    * @return le mot de commande
    */
    public String getCommandWord(){
        return this.aCommandWord; 
    }// getCommandWord()
    
    /**
    * Methode getSecondWord
    * @return le second mot de la commande
    */
    public String getSecondWord(){
        return this.aSecondWord;
    } // getSecondWord()
    
    /**
    * Methode hasSecondWord
    * @return True si il y a un secondWord sinon False
    */    
    public boolean hasSecondWord(){
            return this.aSecondWord!=null;
    }// hasSecondWord()
    
    /**
    * Methode isUnknown
    * @return True si la CommandWord vaut null sinon False
    */    
    public boolean isUnknown(){
            return this.aCommandWord==null;
    } // isUnknown() 
} // Command
