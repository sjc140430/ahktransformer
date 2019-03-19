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
		writeAll(output);
		output.close();
	}
	

	private static void writeAll(FileWriter o) throws IOException {
		
		//preblock
		o.write("coordmode, mouse, screen\n");
		o.write("J::\n");
		//endpreblock
		
		//repeated block
		int xTemp;
		int yTemp;
		for(int i = 0;i<5;i++) {
			for( int j = 0; j < 2; j++) {
				xTemp = xOrigin + (xOffset * i);
				yTemp = yOrigin + (yOffset * j);
							
				o.write( //concat series of method calls or final strings
					buildMouseMove(xTemp, yTemp)+
					click+ 
					buildSleep(10)			
				);	
			}	
		}
		o.write(buildSleep(10));
		//endrepeatedblock
		
		//post block
		o.write("return\n");
		
		o.write("Escape::\n" + buildMouseMove(50, 50) + "ExitApp\nReturn\n");
		//end post block		
	}


	public static String buildMouseMove(int x, int y) {
		return "MouseMove, " + x + ", " + y + "\n";
	}
	
	public static String buildSleep(int ms) {
		return "sleep, " + ms + "\n";
	}


	
}
