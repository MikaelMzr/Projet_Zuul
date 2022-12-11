import java.util.Scanner;  
import java.util.Stack;
import java.io.File;
/**
 * Classe GameEngine
 *
 * @author Mezouar Mikael
 * @version 31/12/2021
 */
public class GameEngine
{
    private Player aP;
    private Parser aParser;
    private UserInterface aGui;
    private int aCompteur; //compteur de commande

    /**
     * Constructeur d'objets de classe GameEngine
     */    
    public GameEngine(){
        createRooms();
        this.aParser=new Parser();
        this.aCompteur=0;
    } // GameEngine()
    
    /**
     * Procedure de la creation de l'interface graphique
     * @param pUserInterface 
     */    
    public void setGUI(final UserInterface pUserInterface)
    {
        this.aGui=pUserInterface;
        this.printWelcome();
    }
    
    /**
     * Procedure qui crée toute les Rooms avec leur liens , ainsi que leur items
     */
    private void createRooms(){

        //declaration des lieux
        Room vTribuneB=new Room("Tribune Est","tribuneB.jpg");
        Room vTribuneA=new Room("Tribune Nord","tribuneA.jpg");
        Room vTribuneC=new Room("Tribune Sud","tribuneC.jpg");
        Room vTerrain=new Room("Terrain","terrain.jpg");
        Room vCouloir1=new Room("Couloir 1","couloir1.jpg");
        Room vBureauArbitre=new Room("Bureau des arbitres","b_arbitre.jpg");
        Room vHall=new Room("Hall du stade","hall.jpg");
        Room vVestiaireE=new Room("Vestiaire Extérieur","vestaireE.jpg");
        Room vVestiaireD=new Room("Vestiaire Domicile","VestD.jpg");
        Room vDouche=new Room("Douche","douche.jpg");
        Room vSalleDeSoin=new Room("Salle de Soin","salleDEsoin.jpg");
        Room vCouloir2=new Room("Couloir 2","couloir2.jpg");
        Room vAccueil=new Room("Accueil","accueil.jpg");
        Room vSalleDeSecu=new Room("Salle de Sécurité","secuRoom.jpg");
        Room vPresse=new Room("Salle de presse","pressRoom.jpg");
        Room vSalleDesTrophee=new Room("Salle des Trophée","tropheeRoom.jpg");
        

        //Positionner les sorties
        vTribuneB.setExit("east",vTerrain);
        vTribuneA.setExit("south",vTerrain);
        vTribuneC.setExit("north",vTerrain);
        
        vTerrain.setExit("north",vTribuneA);
        vTerrain.setExit("south",vTribuneC);
        vTerrain.setExit("east",vCouloir1);
        vTerrain.setExit("west",vTribuneB);
        
        vHall.setExit("north",vVestiaireE);
        vHall.setExit("south",vVestiaireD);
        vHall.setExit("east",vCouloir2);
        vHall.setExit("west",vCouloir1);
        
        vCouloir1.setExit("north",vBureauArbitre);
        vCouloir1.setExit("west",vTerrain);
        vCouloir1.setExit("east",vHall);
        
        vCouloir1.setExit("south",vSalleDeSoin);
        
        vVestiaireE.setExit("south",vHall);
        vDouche.setExit("north",vVestiaireD);
        vSalleDeSoin.setExit("east",vVestiaireD);
        
        vSalleDeSoin.setExit("north",vCouloir1);
        
        vVestiaireD.setExit("north",vHall);
        vVestiaireD.setExit("south",vDouche);
        vVestiaireD.setExit("west",vSalleDeSoin);
        
        vCouloir2.setExit("west",vHall);
        vCouloir2.setExit("east",vAccueil);
        
        vAccueil.setExit("north",vSalleDeSecu);
        vAccueil.setExit("south",vPresse);
        vAccueil.setExit("west",vCouloir2);
        
        vSalleDeSecu.setExit("south",vAccueil); 
        
        vPresse.setExit("north",vAccueil);
        vPresse.setExit("south",vSalleDesTrophee);
        
        vSalleDesTrophee.setExit("north",vPresse);
        
        vBureauArbitre.setExit("south",vCouloir1);
        
       
        //vLab.setExit("north",vOutside);
        //vOutside.setExit("south",vLab);
        
        
        //initialiser le lieu courant
        //this.aCurrentRoom=vOutside;
        this.aP=new Player(vHall,"Mikael");
        this.aP.setCurrentRoom(vHall);
        // this.aRoomPrecedente=null;
        
        //déclaration des items
        
        Item vI=new Item(1,"cle");
        Item vI2=new Item(1,"Ballon");
        Item vI3=new Item(1,"carte");
        Item vI4=new Item(1,"gourde");
        Item vI5=new Item(1,"serviette");
        Item vI6=new Item(100,"spot");
        Item vI7=new Item(1,"cookie");
        
        
        
        vHall.getItem().addItem(vI3);
        vTribuneB.getItem().addItem(vI); 
        vTerrain.getItem().addItem(vI2);
        vTerrain.getItem().addItem(vI4);
        vTerrain.getItem().addItem(vI6);
        vTerrain.getItem().addItem(vI7);
        
        vVestiaireD.getItem().addItem(vI4);
        vVestiaireD.getItem().addItem(vI5);

    } // createRoom()

    /** 
     * Procedure qui essaye d'aller dans une direction passé en paramètre
     * @param pCommand qui est la direction vers laquelle on veut se diriger
     */    
    private void goRoom( final Command pCommand ) 
    {
        if ( ! pCommand.hasSecondWord() ) {
            // if there is no second word, we don't know where to go...
            this.aGui.println( "Go where?" );
            return;
        }

        String vDirection = pCommand.getSecondWord();

        // // Try to leave current room.
        // //this.aRoomPrecedente=this.aCurrentRoom;
        Room vNextRoom = this.aP.getCurrentRoom().getExit( vDirection );
        
        if (vNextRoom.getDescription().equals("Salle des Trophée") && this.aP.getItems().estPresent("cle")==false){
            this.aGui.println( "la porte est fermé, il faut une cle, elle se trouve dans une des tribunes!" );
        }
       

        if (aP.goRoom(pCommand) && vNextRoom==null)
            this.aGui.println( "There is no door!" );
            
        
            
        else{
            this.aCompteur+=1;
            if(this.aCompteur==25){
                this.aGui.println("vous avez perdu , le match a commencé");
                this.endGame(); //mettre fin au jeu 
            }
            else{
                
                this.aGui.println( this.aP.getCurrentRoom().getLongDescription() );
                if ( this.aP.getCurrentRoom().getImageName() != null ) 
                    this.aGui.showImage( this.aP.getCurrentRoom().getImageName() );
            }
            
            this.gagner();
        }
    }// goRoom()
    
    /**
     * Procedure qui affiche un message pour le joueur au début du jeu (intro)
     */
    private void printWelcome(){
        this.aGui.println("Welcome to the Un joueur perdu à Anfield!");
        this.aGui.println("Un joueur est enfermé dans la salle des trophée");
        this.aGui.println("trouvez le joueur avant le coup d'envoi !");
        this.aGui.println("Type 'help' if you need help.\n");
        this.aGui.println("");
        this.printLocationInfo();
        if(this.aP.getCurrentRoom().getImageName()!=null)
            this.aGui.showImage(this.aP.getCurrentRoom().getImageName() );
    } // printWelcome()

    /**
     * Procedure qui affiche les informations pouvant aider le joueur
     * (les commandes possibles)
     */
    private void printHelp(){
        this.aGui.println("You are lost. You are alone.");
        this.aGui.println("You wander around at the university.\n");
        this.aGui.println("Your command words are:"+this.aParser.getCommandString() );
        
    } // printHelp()
    
    /**
     * Fonction qui permet de quitter le jeu
     * @return true si on quitte le jeu sinon false
     */   
    private boolean quit(final Command pCommand){
        if (pCommand.hasSecondWord()==true){
            System.out.println("Quit what ??");
            return false;}
        return true;   
    } // quit()
    
    /**
     * Fonction qui appelle la bonne méthode en fonction de la commande 
     * en parametre
     * @return un booleen 
     */     
    private boolean processCommand(final Command pCommand){
        if (pCommand.isUnknown()==true){
            this.aGui.println("I don't know what you mean...");
            return false; }
        
        else{
            if(pCommand.getCommandWord().equals("quit")){
                return this.quit(pCommand);}

            if(pCommand.getCommandWord().equals("go")){
                this.goRoom(pCommand);
                return false;}

            if(pCommand.getCommandWord().equals("help")){
                this.printHelp();
                return false;}     
                
            if(pCommand.getCommandWord().equals("look")){
                this.look();
                return false;}      
             
            if(pCommand.getCommandWord().equals("eat")){
                this.eat(pCommand);
                return false;}      
            
            if(pCommand.getCommandWord().equals("back")){
                this.back();
                return false;}
                
            if(pCommand.getCommandWord().equals("inventaire")){
                this.inventaire2();
                return false;}            
              
            else{
                return false; }
        
            
        }
    }// processCommand()
    
    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public void interpretCommand( final String pCommandLine ) 
    {
        this.aGui.println( "> " + pCommandLine );
        Command vCommand = this.aParser.getCommand( pCommandLine );

        if ( vCommand.isUnknown() ) {
            this.aGui.println( "I don't know what you mean..." );
            return;
        }

        String vCommandWord = vCommand.getCommandWord();
        if ( vCommandWord.equals( "help" ) )
            this.printHelp();
        else if ( vCommandWord.equals( "go" ) )
            this.goRoom( vCommand );
        else if ( vCommandWord.equals( "quit" ) ) {
            if ( vCommand.hasSecondWord() )
                this.aGui.println( "Quit what?" );
            else
                this.endGame();
        }
        else if ( vCommandWord.equals( "look" ) )
            this.look();
            
        else if ( vCommandWord.equals( "eat" ) )
            this.eat(vCommand);
        
        else if ( vCommandWord.equals( "back" ) )
            this.back();
            
        else if ( vCommandWord.equals( "take" ) )
            this.take(vCommand);
            
        else if ( vCommandWord.equals( "drop" ) )
            this.drop(vCommand);
            
        else if ( vCommandWord.equals( "test" ) )
            this.testF(vCommand.getSecondWord()+".txt");
            
        else if ( vCommandWord.equals( "inventaire" ) )
            this.inventaire2();
    } //interpretCommand()
    
    /**
     * Procedure qui permet d'avoir l'information de la Room dans laquelle 
     * on se trouve
     */    
    private void printLocationInfo(){
        this.aGui.println(this.aP.getCurrentRoom().getLongDescription());
    } // printLocationInfo()
    
    /**
     * Procedure qui permet de regarder et d'avoir des info sur la salle 
     * actuelle 
     */       
    public void look(){
        this.aGui.println(this.aP.getCurrentRoom().getLongDescription());
    } // look()
    
    /**
     * Procedure qui permet de manger
     * @param pCommand qui est l'item qu'on veut manger
     */     
    public void eat(final Command pCommand){
        if ( ! pCommand.hasSecondWord() ) {
            // if there is no second word, we don't know where to go...
            this.aGui.println( "eat what?" );
            return;
        }
        String vItem = pCommand.getSecondWord();
        if (aP.getCurrentRoom().getItem().estPresent(vItem) && vItem.equals("cookie")){
            
            aP.getCurrentRoom().getItem().removeItem(vItem); //suppresion de l'item de la salle
            aP.setPoidsMax(200);
            this.aGui.println( "tu viens de manger un cookie magique" );
            
        }
        
        else{
            this.aGui.println("tu ne peut pas manger cet objet");
        }
    }// eat() 
    
    /**
     * Procedure qui met fin au jeu 
     */ 
    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." );
        this.aGui.enable( false );
    }// endGame()
    
    /**
     * Procedure qui permet de revenir en arriere
     */    
    public void back(){
        if(!this.aP.back()){
            this.aGui.println("pas de Room Precedente");
        }
        
        else{
            
            this.aGui.println( this.aP.getCurrentRoom().getLongDescription() );
            if ( this.aP.getCurrentRoom().getImageName() != null ) 
                this.aGui.showImage( this.aP.getCurrentRoom().getImageName() );
        }
    }// back()
    
    /**
     * Procedure qui permet de prendre un item
     * @param pCommand qui est l'item qu'on veut prendre
     */     
    public void take(final Command pCommand ){
        if ( ! pCommand.hasSecondWord() ) {
            // if there is no second word, we don't know where to go...
            this.aGui.println( "take what?" );
            return;
        }
        String vItem = pCommand.getSecondWord();
        
        if(!this.aP.PoidsValable(aP.getCurrentRoom().getItem().getItem(vItem).getPoids())){
            this.aGui.println("Objet est trop lourd \n");
            return;
        }       
        
       
        if (aP.getCurrentRoom().getItem().estPresent(vItem)){
            
            aP.getItems().addItem(aP.getCurrentRoom().getItem().getItem(vItem)); //ajoute de l'élément a la liste 
            aP.getCurrentRoom().getItem().removeItem(vItem); //suppresion de l'item de la salle
            this.aGui.println( "take fais" );
            this.aGui.println(this.aP.inventaire() + "\n");
        }
    } // take()
    
    /**
     * Procedure qui permet de lacher un item
     * @param pCommand qui est l'item qu'on veut lacher
     */      
    public void drop(final Command pCommand ){
        if ( ! pCommand.hasSecondWord() ) {
            // if there is no second word, we don't know where to go...
            this.aGui.println( "drop what" );
            return;
        }
        String vItem = pCommand.getSecondWord();
        if (aP.getItems().getItem(vItem).getDescription().equals(vItem)){
            
            aP.getCurrentRoom().getItem().addItem(aP.getItems().getItem(vItem)); //ajout dans de l'item dans la salle
            aP.getItems().removeItem(vItem); //suppresion de l'item de la liste
            this.aGui.println( "drop fais" );
            this.aGui.println(this.aP.inventaire() + "\n");
        }
    } // drop()    

    /**
     * Fonction test 
     */   
    private void test(final String pS) throws Exception{
        Scanner vScan= new Scanner(new File(pS));
        while(vScan.hasNextLine()){
            String vLine=vScan.nextLine();
            this.interpretCommand(vLine);
        }
    } // test()
    
    /**
     * Fonction test 
     */   
    private void testF(final String pS)
    {
        try{
            this.test(pS);
           }
        catch(Exception pE){
            this.aGui.println("Aucun fichier de ce nom");
        }
    } // testF()
    
    /**
     * Procedure qui vérifie si le joueur a gagné  
     */    
    private void gagner(){
        if(aP.getCurrentRoom().getDescription().equals("Salle des Trophée")){
            this.aGui.println("vous avez gagné , joueur retrouvé!");
            this.endGame();
        }
        else
            return;
    } // gagner()
    
    /**
     * Procedure qui affiche l'inventaire du joueur  
     */    
    private void inventaire2(){
        this.aGui.println(this.aP.inventaire());
    } //inventaire2()
} // Game
