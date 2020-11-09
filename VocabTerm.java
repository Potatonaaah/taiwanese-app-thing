import java.io.*;

public class VocabTerm implements Serializable {
    String englishDef;
    String chineseTraditionalDef;
    String chineseSimplifiedDef;
    String taiwanesePinyin;
    String chinesePinyin;
    boolean isFavorited = false;
    String soundClip;
    String zhuyin;
    String soundFileName;
    int index;

    public VocabTerm(String englishDef, String chineseTraditionalDef, String chineseSimplifiedDef, String taiwanesePinyin, String chinesePinyin, String zhuyin, int index) {//i assume the default setting for isFavorited is false, so just use this when adding new terms
        this.englishDef = englishDef;
        this.chineseTraditionalDef = chineseTraditionalDef;
        this.chineseSimplifiedDef = chineseSimplifiedDef;
        this.taiwanesePinyin =taiwanesePinyin;
        this.chinesePinyin = chinesePinyin;
        this.zhuyin= zhuyin;
        this.index = index;

    }


    public VocabTerm(String englishDef, String chineseTraditionalDef, String chineseSimplifiedDef, String taiwanesePinyin, String chinesePinyin,String zhuyin, String soundFileName, boolean isFavorited) {//this time with isFavorited
        this.englishDef = englishDef;
        this.chineseTraditionalDef = chineseTraditionalDef;
        this.chineseSimplifiedDef = chineseSimplifiedDef;
        this.taiwanesePinyin =taiwanesePinyin;
        this.chinesePinyin = chinesePinyin;
        this.isFavorited = isFavorited;
        this.zhuyin= zhuyin;
    }


    // rest of this stuff is just getters and setters///////////////////////////////////////////////////
    public String getEnglishDef() {
        return englishDef;
    }

    public void setEnglishDef(String englishDef) {
        this.englishDef = englishDef;
    }

    public String getChineseTraditionalDef() {
        return chineseTraditionalDef;
    }

    public void setChineseTraditionalDef(String chineseTraditionalDef) {
        this.chineseTraditionalDef = chineseTraditionalDef;
    }

    public String getChineseSimplifiedDef() {
        return chineseSimplifiedDef;
    }

    public void setChineseSimplifiedDef(String chineseSimplifiedDef) {
        this.chineseSimplifiedDef = chineseSimplifiedDef;
    }

    public String getTaiwanesePinyin() {
        return taiwanesePinyin;
    }

    public void setTaiwanesePinyin(String taiwanesePinyin) {
        this.taiwanesePinyin = taiwanesePinyin;
    }

    public String getChinesePinyin() {
        return chinesePinyin;
    }

    public void setChinesePinyin(String chinesePinyin) {
        this.chinesePinyin = chinesePinyin;
    }

    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean isFavorited) {
        this.isFavorited = isFavorited;
    }


}
