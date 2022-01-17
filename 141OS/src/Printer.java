import java.io.*;
import java.nio.file.Path;

public class Printer {
	Path printerPath;
	String PrinterI;
    
    public Printer(String name){
        PrinterI = name;
    }

    public void print(StringBuffer data){
        try{
        	Thread.sleep(2750*Main.speed);
        }     
		catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}

		try{
			FileWriter file = new FileWriter(PrinterI,true);
        	BufferedWriter writer = new BufferedWriter(file);
        	writer.write(data.toString()+"\n");
			writer.flush();
        	writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
