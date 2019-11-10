package password_crackers;

import java.io.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.*;

public class Dictionary_Generator {

    public List<String> getUniqueBibleWords(String fileName){

        FileInputStream fis = null;
        DataInputStream dis = null;
        BufferedReader br = null;
        List<String> wordList = new ArrayList<String>();
        try {
            fis = new FileInputStream(fileName);
            dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));
            String line = null;
            while((line = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(line, " ,.;:\"");
                while(st.hasMoreTokens()){
                    String tmp = st.nextToken().toLowerCase();
                    if(!wordList.contains(tmp)){
                        wordList.add(tmp);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{if(br != null) br.close();}catch(Exception ex){}
        }
        return wordList;
    }

    public static void main(String a[]) throws IOException {

        Dictionary_Generator distinctFileWords = new Dictionary_Generator();
        List<String> wordList = distinctFileWords.getUniqueBibleWords("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/PA4_Word_List.txt");
        BufferedWriter uniqueBibleWordList = new BufferedWriter(new FileWriter("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/uniqueBibleWordList.txt"));

        for(String str : wordList){
            uniqueBibleWordList.write(str);
        }
        uniqueBibleWordList.close();
    }

}
