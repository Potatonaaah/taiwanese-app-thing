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
	
}
