import java.util.*;
import java.io.*;

public class WordPackage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Hashtable<String, HashSet<Integer>> indexes; 
	public ArrayList<VocabTerm> result;
	
	public WordPackage(ArrayList<VocabTerm> result, Hashtable<String, HashSet<Integer>> wordList) {
		this.indexes = wordList;
		this.result = result;

	}
	
	public static String fileName = "wordpackage.ser";

	// Serializes an object and saves it to a file
	public void saveToFile(Context context) {
	    try {
	        FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
	        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	        objectOutputStream.writeObject(this);
	        objectOutputStream.close();
	        fileOutputStream.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	// Creates an object by reading it from a file
	public static WordPackage readFromFile(Context context) {
	    WordPackage wordpackage; 
	    try {
	        FileInputStream fileInputStream = context.openFileInput(fileName);
	        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	        wordpackage = (WordPackage)objectInputStream.readObject();
	        objectInputStream.close();
	        fileInputStream.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return wordpackage;
	}
}
