package maze;

/**
*
* @author Ryan
*/

public class Menu{
	
	//THIS CLASS IS UNUSED, MAY REMOVE LATER
	
    private static int[] save = new int[13];                                                                        //The Save. This is important.
    public Menu(){                                                                                                  //Constructor
        System.out.println("Menu Options:\nNew Game\nLoad Save\nHow to Play\nCredits\n");
        boolean exitInput = false;
        while(exitInput == false){
            String selection = Inputter.consoleInput().toLowerCase();
            if(selection.equals("New Game")){
                newGame();
                exitInput = true;
            }else if(selection.equals("Load Save")){
                loadSave();
                exitInput = true;
            }else if(selection.equals("How to Play")){
                instructions();
                exitInput = false;
            }else if(selection.equals("Credits")){
                creds();
                exitInput = false;
            }else{
                System.err.println("This is not a valid selection.");
            }
        }
    }
    public static void newGame(){
        save[0] = 0;                                                    //number of rooms moved through
        save[1] = 0;                                                    //current direction
        save[2] = (int)(Math.random()*21);                              //player X position
        save[3] = (int)(Math.random()*21);                              //player Y position
        save[4] = (int)(Math.random()*3);                               //player Z position
        save[5] = 0;                                                    //player experience
        save[6] = 100;                                                  //player health
        save[7] = (int)(Math.random()*21);                              //exit X position
        while(-3 <= save[7]-save[2] && save[7]-save[2] <= 3){
            save[7] = (int)(Math.random()*21);
        }
        save[8] = (int)(Math.random()*21);                              //exit Y position
        while(-3 <= save[8]-save[3] && save[8]-save[3] <= 3){
            save[8] = (int)(Math.random()*21);
        }
        save[9] = (int)(Math.random()*3);                               //exit Z position
        System.out.println("Difficulty:\nEasy\nMedium\nMLG");           //difficulty
        String diff = Inputter.consoleInput().toLowerCase();
        if(diff.equalsIgnoreCase("Easy"))
            save[10] = 0;
        else if(diff.equalsIgnoreCase("Medium"))
            save[10] = 1;
        else if(diff.equalsIgnoreCase("MLG"))
            save[10] = 2;
        else
            System.err.println("This is not a valid selection.");
        save[11] = (int)(Math.random()*5) +8;                           //player weapon damage (between 8 and 12)
        save[12] = 5*(20-save[11]);                                     //player armor strength (blocks 90% of damage, takes 110% as much)
        save[13] = 18-save[11];                                         //player magic strength (inversely mapped to damage (8 to 10 and 12 to 6)
        System.out.println("Welcome to the maze...");
    }
    public static void loadSave(){
        
    }
    public static void instructions(){
        
        
        save[0] = -420;
    }
    public static void creds(){
        
        
        save[0] = -420;
    }
    public int getSaveInfo(int pos){
        if(pos < save.length)
            return save[pos];
        else{
            System.out.println("Problem!!");
            return -5000;
        }
    }
}
