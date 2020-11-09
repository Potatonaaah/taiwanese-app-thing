import java.io.*;
import java.util.*;



public class wordGenUtils {
   

    public static WordPackage fromRaw(String filepath) throws IOException {

        ArrayList<VocabTerm> result = new ArrayList<VocabTerm>();
   

        Hashtable<String, HashSet<Integer>> wordList = new Hashtable<String, HashSet<Integer>>();



        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String[] header = br.readLine().split(",");

        int chinesePhraseInd= Arrays.asList(header).indexOf("Chinese");
        int chineseZhuyinInd= Arrays.asList(header).indexOf("zhuyin");
        int simpChinesePhraseInd= Arrays.asList(header).indexOf("simplified");
        int chinesePinyinInd= Arrays.asList(header).indexOf("mandarin pinyin");
        int engTransInd= Arrays.asList(header).indexOf("English");
        int taiwanPinyinInd= Arrays.asList(header).indexOf("Taiwanese");
        
 

        int index = 0;

        while(br.ready()) {

            String[] input = br.readLine().split(",");
            printTest(input);
            VocabTerm current = new VocabTerm(fix(input[engTransInd]), fix(input[chinesePhraseInd]), fix(input[simpChinesePhraseInd]), fix(input[taiwanPinyinInd]), fix(input[chinesePinyinInd]),fix(input[chineseZhuyinInd]), index);
            result.add(current);

            String[] englishdef = input[engTransInd].toLowerCase().replaceAll("[^A-Za-z0-9 ]", "").split(" ");
            

            

            for(int i = 0; i< englishdef.length; i++) {
                if(wordList.containsKey(englishdef[i])) {
                    wordList.get(englishdef[i]).add(index);
                }
                else {
                    wordList.put(englishdef[i], new HashSet<Integer>());
                    wordList.get(englishdef[i]).add(index);
                }
            }
            index++;

        }

        return new WordPackage(result, wordList);
    }

    public static void printTest(String[] array) {
    	for(String i: array) {
    		System.out.print(i);
    		System.out.print(" ");
    	}
    	System.out.println();
    }




    public static String fix(String input) {
        return input.replace('@', ',');
    }








    /////////////////search//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static HashSet<Integer> lookupIndexes(String input, Hashtable<String, HashSet<Integer>> wordList){
        /**
         * string input represents what the user types in, orderedWords and wordList is from the fromExcel method
         */

        String[] keys = input.split(" ");
        HashSet<Integer> result = new HashSet<Integer>();

        for(int i = 0; i< keys.length; i++) {
            if(wordList.containsKey(keys[i])){
                if(result.size()!=0) {
                    HashSet<Integer> indexes = wordList.get(keys[i]);
                    result.retainAll(indexes);
                }
                else {
                    result = wordList.get(keys[i]);
                }
            }
        }

        return result;

    }

}
