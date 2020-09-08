package com.example.taiwaneseappv1;

import java.util.*;
import java.io.*;
import android.content.Context;

public class wordGenUtils {
    /**
     public static ArrayList<VocabTerm> fromExcel(String filepath) throws IOException {//reads in csv file to create list of VocabTerms
     ArrayList<VocabTerm> result = new ArrayList<VocabTerm>();
     File fileDir = new File("D:\\Temp\\Taiwanese App Thing.csv");//fill in with filepath of csv file. Download the google sheets of the taiwanese app thing, then convert to a csv file using online tool or something i dunno figure it out
     BufferedReader br = new BufferedReader(
     new InputStreamReader(
     new FileInputStream(fileDir), "UTF8"));

     String[] header = br.readLine().split(",");
     int chinesePhraseInd= Arrays.asList(header).indexOf("Traditional Chinese Phrase");
     int chineseZhuyinInd= Arrays.asList(header).indexOf("Chinese Zhuyin");
     int simpChinesePhraseInd= Arrays.asList(header).indexOf("Simplified Chinese Phrase");
     int chinesePinyinInd= Arrays.asList(header).indexOf("Chinese Pinyin");
     int engTransInd= Arrays.asList(header).indexOf("English Translation");
     int taiwanPinyinInd= Arrays.asList(header).indexOf("Taiwanese Pinyin");
     int audioInd= Arrays.asList(header).indexOf("Audio Clip (Weslet Cut from filmora u idiot)");

     while(br.ready()) {
     String[] input = br.readLine().split(",");
     VocabTerm current = new VocabTerm(input[engTransInd], input[chinesePhraseInd], input[simpChinesePhraseInd], input[taiwanPinyinInd], input[chinesePinyinInd],input[chineseZhuyinInd], input[audioInd]);
     result.add(current);
     }
     br.close();
     return result;
     }

     public static ArrayList<VocabTerm> fromArray(String[] englishDef, String[] chineseTraditionalDef, String[] chineseSimplifiedDef, String[] taiwanesePinyin, String[] chinesePinyin, String[] zhuyin, String[] soundFileName){
     ArrayList<VocabTerm> result = new ArrayList<VocabTerm>();
     try {

     for(int i = 0; i< englishDef.length; i++) {
     result.add(new VocabTerm(englishDef[i], chineseTraditionalDef[i], chineseSimplifiedDef[i], taiwanesePinyin[i], chinesePinyin[i], zhuyin[i], soundFileName[i]));
     }
     return result;
     }
     catch(Exception E){
     System.out.println("error processing vocabterms from array, make sure each array is the same length.");
     return result;
     }
     }
     **/

    public static WordPackage fromRaw(Context c) throws IOException {

        ArrayList<VocabTerm> result = new ArrayList<VocabTerm>();
        // File fileDir = new File(R.raw.taiwanese_app_thing);//fill in with filepath of csv file. Download the google sheets of the taiwanese app thing, then convert to a csv file using online tool or something i dunno figure it out


        Hashtable<String, HashSet<Integer>> wordList = new Hashtable<String, HashSet<Integer>>();

        // BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(R.raw.taiwanese_app_thing), "UTF8"));
        InputStream is = c.getResources().openRawResource(R.raw.taiwanese_dictionary_v1);//replace this with the new csv file
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String[] header = br.readLine().split(",");

        System.out.println("after buffered");

        int chinesePhraseInd= Arrays.asList(header).indexOf("Chinese");
        int chineseZhuyinInd= Arrays.asList(header).indexOf("zhuyin");
        int simpChinesePhraseInd= Arrays.asList(header).indexOf("simplified");
        int chinesePinyinInd= Arrays.asList(header).indexOf("mandarin pinyin");
        int engTransInd= Arrays.asList(header).indexOf("English");
        int taiwanPinyinInd= Arrays.asList(header).indexOf("Taiwanese");

        System.out.println(chinesePhraseInd + "traditional chinese index");
        System.out.println(engTransInd + "english index");
        int index = 0;

        while(br.ready()) {

            String[] input = br.readLine().split(",");

            VocabTerm current = new VocabTerm(fix(input[engTransInd]), fix(input[chinesePhraseInd]), fix(input[simpChinesePhraseInd]), fix(input[taiwanPinyinInd]), fix(input[chinesePinyinInd]),fix(input[chineseZhuyinInd]),"", c);
            result.add(current);

            String[] englishdef = input[engTransInd].toLowerCase().replaceAll("[^A-Za-z0-9 ]", "").split(" ");

            System.out.println("current line number: " + index);

            for(int i = 0; i< englishdef.length; i++) {
                if(wordList.contains(englishdef[i])) {
                    wordList.get(englishdef[i]).add(i);
                }
                else {
                    wordList.put(englishdef[i], new HashSet<Integer>());
                    wordList.get(englishdef[i]).add(i);
                }
            }
            index++;

        }

        ArrayList<String> words = new ArrayList<String>(wordList.keySet());

        Collections.sort(words);

        return new WordPackage(result, wordList);
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
            if(wordList.contains(keys[i])){
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
