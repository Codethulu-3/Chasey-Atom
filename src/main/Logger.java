package maze;

import java.util.Date;
import java.io.*;
import java.text.SimpleDateFormat;

public class Logger{
    PrintWriter writer;
    public Logger(){
        try{
            writer = new PrintWriter("log"+".txt", "UTF-8");
        }catch(IOException e){
            System.err.println("Logging failed");
        }
        Date now = new Date();
        SimpleDateFormat dF1 = new SimpleDateFormat("EEEE, MMMM d, yyyy 'in' zzz");
        writer.println("Labryntheon GameLog for playsession starting on "+dF1.format(now));
        append("Session started");
    }
    public boolean append(String in){
        Date now = new Date();
        SimpleDateFormat dF2 = new SimpleDateFormat("hh:mm:ss a");
        writer.println(dF2.format(now) +"\t"+ in);;
        return true;
    }
    public boolean close(){
        writer.close();
        return true;
    }
}
