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

    public List<String> getUniqueBibleWords(String fileName) {

        FileInputStream fis = null;
        DataInputStream dis = null;
        BufferedReader br = null;
        List<String> wordList = new ArrayList<String>();
        try {
            fis = new FileInputStream(fileName);
            dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));
            String line = null;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " ,.;:\"");
                while (st.hasMoreTokens()) {
                    String tmp = st.nextToken().toLowerCase();
                    if (!wordList.contains(tmp)) {
                        wordList.add(tmp);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (Exception ex) {
            }
        }
        return wordList;
    }

    public void appendSymbolsToWords(String fileName) throws IOException {
        /*
            String[] symbolsToAppend = {!,@,#,$,%,^,&,*,(,),_};

            BufferedWriter writer = new BufferedWriter(
                                        new FileWriter("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/symbolAppendedWordList.txt"", true)  //Set true for append mode
                                    );
            // For every line of the file, add the symbol to the end of that line.
            while(fileName.hasNext()){
            for (int i = 0; i < symbolsToAppend.length(); i ++){
            // Append the ith symbol in the array to every line in the file
            writer.write(symbolsToAppend[i]);
                }
            }
            writer.close();
        */
    }

    public void prependSymbolsToWords(String fileName) throws IOException {
        // For every line of the file, add the symbol to the beginning of that line.
    }

    public void l33tSp34kTranslation(String fileName){
        // Search in given file and replace E -> 3,  o -> 0, a -> @, $" for "s", "1" for "l" and so on
        /*
        Path path = Paths.get(fileName);
        Charset charset = StandardCharsets.UTF_8;

        String content = new String(Files.readAllBytes(path), charset);
        content = content.replaceAll("foo", "bar");
        Files.write(path, content.getBytes(charset));

        OR

         BufferedWriter writer = new BufferedWriter(
                                        new FileWriter("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/l33tSp34kTranslationWordList.txt"", true)  //Set true for append mode
                                    );
        for (String fn : fileName) {
            String s = new String(Files.readAllBytes(Paths.get(fn)));
            s = s.replace("E", "3");
                writer.write(s);
            }
        }
         */
    }

    public static void main(String a[]) throws IOException {

        Dictionary_Generator distinctFileWords = new Dictionary_Generator();
        List<String> wordList = distinctFileWords.getUniqueBibleWords("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/PA4_Word_List.txt");
        BufferedWriter uniqueBibleWordList = new BufferedWriter(new FileWriter("/Users/yiradz/College/JUN_SEM1/SECURITY/PA4/src/password_crackers/uniqueBibleWordList.txt"));

        for (String str : wordList) {
            uniqueBibleWordList.write(str);
            uniqueBibleWordList.write("\n");
        }
        uniqueBibleWordList.close();
    }

}
