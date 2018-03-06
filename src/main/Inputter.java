package maze;

import java.io.*;
import java.util.Scanner;

public class Inputter{
    private Scanner source;
    public Inputter(String type){                                               //Constructor for console reading
        if(type.equals("IO"))
            source = new Scanner(System.in);
        else if(type.equals("document"))
            System.err.println("Use other constructor");
    }
    public Inputter(String type, String filename){                              //Constructor for file reading
        if(type.equals("document"))
            try{
                source = new Scanner(new File(filename+".txt"));
            }catch(Exception e){
                System.err.println("File not found");
            }
        else if(type.equals("IO"))
            System.err.println("Use other constructor");
    }
    public String inputLine(){                                                  //Gets next line of input
        return source.nextLine();
    }
    public boolean close(){                                                     //Closes the scanner
        source.close();
        return true;
    }
    public static String consoleInput(){                                        //Completely separate input system - does everything in one step rather than three
        Scanner scan = new Scanner(System.in);
        String out = scan.nextLine();
        scan.close();
        return out;
    }
}
