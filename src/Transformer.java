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
		o.write("#SingleInstance force\n");
		o.write("coordmode, mouse, screen\n");
		o.write("J::\n");
		//endpreblock
		
		//repeated block
		int x;
		int y;
		for(int i = 0;i<5;i++) {
			for( int j = 0; j < 2; j++) {
				x = xOrigin + (xOffset * i);
				y = yOrigin + (yOffset * j);
							
				o.write( //concat series of method calls or final strings
					mm(x, y)+
					//click+ 
					sleep(10)			
				);	
			}	
		}
		o.write(sleep(10));
		//endrepeatedblock
		
		//post block
		o.write("return\n");
		
		o.write("Escape::\n" + mm(50, 50) + "ExitApp\nReturn\n");
		//end post block		
	}


	public static String mm(int x, int y) {
		return "MouseMove, " + x + ", " + y + "\n";
	}
	
	public static String sleep(int ms) {
		return "sleep, " + ms + "\n";
	}


	
}
