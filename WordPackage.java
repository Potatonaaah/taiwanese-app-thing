package com.example.taiwaneseappv1;



import java.util.*;
import java.io.*;


public class WordPackage implements Serializable {

    public Hashtable<String, HashSet<Integer>> indexes;
    public ArrayList<VocabTerm> termList;

    public WordPackage(ArrayList<VocabTerm> result, Hashtable<String, HashSet<Integer>> wordList) {
        this.indexes = wordList;
        this.termList = result;

    }

}
