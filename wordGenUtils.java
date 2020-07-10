import java.util.*;
import java.io.*;

public class wordGenUtils {
	
	public static ArrayList<VocabTerm> fromExcel(String filepath) throws IOException {
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
			VocabTerm current = new VocabTerm(input[engTransInd], input[chinesePhraseInd], input[simpChinesePhraseInd], input[taiwanPinyinInd], input[chinesePinyinInd], input[audioInd]);
			result.add(current);
		}
		
		return result;
	}
	
	public static ArrayList<VocabTerm> fromCSV(Context c) throws IOException{
		ArrayList<VocabTerm> result = new ArrayList<VocabTerm>();


		InputStream is = c.getResources().openRawResource(R.raw.taiwanese_dictionary_v1);//replace this with the new csv file
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String[] header = br.readLine().split(",");

		int chinesePhraseInd= Arrays.asList(header).indexOf("Chinese");
		int chineseZhuyinInd= Arrays.asList(header).indexOf("zhuyin");
		int simpChinesePhraseInd= Arrays.asList(header).indexOf("simplified");
		int chinesePinyinInd= Arrays.asList(header).indexOf("mandarin pinyin");
		int engTransInd= Arrays.asList(header).indexOf("English");
		int taiwanPinyinInd= Arrays.asList(header).indexOf("Taiwanese");
		//int audioInd= Arrays.asList(header).indexOf(""); currently there are no audio files

		while(br.ready()) {

		     String[] input = br.readLine().split(",");

		     VocabTerm current = new VocabTerm(fix(input[engTransInd]), fix(input[chinesePhraseInd]), fix(input[simpChinesePhraseInd]), fix(input[taiwanPinyinInd]), fix(input[chinesePinyinInd]),fix(input[chineseZhuyinInd]), "", c);
		     result.add(current);
		}

		return result;
	}
	
	public static String fix(String input) {
		return input.replace('@', ',');
	}
	
}
