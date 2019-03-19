import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Transformer {


	final static String click = "click\n";
	final static String nl = "\n";
	final static int xOrigin = 0; //change to first window
	final static int yOrigin = 0; //change to first window
	final static int xOffset = 500; //500
	final static int yOffset = 525; //525
	final static int xMenuOffset = 0;
	final static int yMenuOffset = 0;
	

	
	public static void main(String[] args) throws IOException {
		//preblock
		FileWriter output = new FileWriter(new File("src\\script.ahk"));	
		output.write("#singleinstance force\n");
		output.write("coordmode, mouse, screen\n");		
		writeAll(output);
		output.write("1::\n" + buildMouseMove(50, 50) + "ExitApp\nReturn\n");
		output.close();
	}
	

	private static void writeAll(FileWriter o) throws IOException {
		int xTemp;
		int yTemp;
		//----------------------------------------------------------//
		o.write("J::\n");
		for(int i = 0;i<5;i++) {
			for( int j = 0; j < 2; j++) {
				xTemp = xOrigin + (xOffset * i);
				yTemp = yOrigin + (yOffset * j);
				o.write("#-------------------\n");	
				o.write( //concat series of method calls or final strings
					buildMouseMove(xTemp, yTemp)+
					//click+ 
					buildSleep(10)			
				);
				o.write("#-------------------\n");	
			}	
		}
		o.write(buildSleep(10));
		o.write("return\n");
		o.write("#-------------------\n");
		//-----------------------------------------------------------//
	}


	public static String buildMouseMove(int x, int y) {
		return "MouseMove, " + x + ", " + y + "\n";
	}
	
	public static String buildSleep(int ms) {
		return "sleep, " + ms + "\n";
	}


	
}