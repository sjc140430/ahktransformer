import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class LambaTest {

	private Node head;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader reader = new BufferedReader(new FileReader("src\\lego.txt"));
		List<String> arr = new ArrayList<String>(2538);

		int count = 0;
		String str;	
		while((str = reader.readLine()) != null) {
			arr.add(str);
			count++;

		}
		System.out.println("\n" + count + " lines read.");
		reader.close();

		int i;
		while(true) {
		i = (int) (Math.random() * (arr.size()-1));
		System.out.println(arr.get(i));
		Thread.sleep(100);
		
		}	
	}
	
	
	class InnerClass implements Iterable{

		@Override
		public Iterator<LambaTest> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	class Node<T> {
		ArrayList<T> data;
		Node<T> next;
		
		public Node(ArrayList<T> arr) {
			data = arr;
		}
	}

}
