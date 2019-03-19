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
	
	public static void main(String[] args) throws IOException {
		//preblock
		FileWriter o = new FileWriter(new File("src\\script.ahk"));
		o.write("coordmode, mouse, screen\n");
		o.write("J::\n");
		
		
		//repeated block
		for(int i = 0;i<5;i++) {
			for( int j = 0; j < 2; j++) {
				int xTemp = xOrigin + (xOffset * i);
				int yTemp = yOrigin + (yOffset * j);
				
				o.write(buildMouseMove(xTemp, yTemp));
				//o.write(click);
				o.write(buildSleep(10));
			}	
		}
		o.write(buildSleep(10));
		//endrepeatedblock
		
		//post block
		o.write("return\n");
		o.write("Escape::\n" + buildMouseMove(50, 50) + "ExitApp\nReturn\n");
		//end post block
		o.close();
	}
	
	public static String buildMouseMove(int x, int y) {
		return "MouseMove, " + x + ", " + y + "\n";
	}
	
	public static String buildSleep(int ms) {
		return "sleep, " + ms + "\n";
	}

}
