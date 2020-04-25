import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.io.*;
import java.lang.*;

public class main {

    public static void main(String[] args)throws Exception {

        Scanner scan = new Scanner(System.in);
        System.out.println("enter command");
        String com = scan.nextLine();
        System.out.println("enter file");
        String inputFileName = scan.nextLine();

        String path = "C:\\Users\\User\\IdeaProjects\\morse\\src\\" + inputFileName;
        File inputFile = new File(path);
        scan = new Scanner(inputFile);

        File alphFile = new File("C:\\Users\\User\\IdeaProjects\\morse\\src\\alphabet.txt");
        Scanner readAlphabet = new Scanner(alphFile);
        String key, value;
        HashMap<String, String> alphabet = new HashMap<>();
        HashMap<String, String> alphabetMorse = new HashMap<>();

        File outputFile = new File("C:\\Users\\User\\IdeaProjects\\morse\\src\\out.txt");

        FileWriter outWriter = new FileWriter(outputFile);

        while(readAlphabet.hasNextLine())
        {
            key = readAlphabet.next();

            if(key.equals("-...-"))
            {
                alphabet.put(" ", key);
                alphabetMorse.put("-...-"," ");
            }
            else {
                value = readAlphabet.next();
                alphabet.put(key, value);
                alphabetMorse.put(value,key);
            }
        }

        File statPath = new File("C:\\\\Users\\\\User\\\\IdeaProjects\\\\morse\\src\\stat.txt");
        FileWriter statFile = new FileWriter(statPath);

        File compareStatFile = new File("C:\\\\Users\\\\User\\\\IdeaProjects\\\\morse\\src\\comparableStat.txt");
        FileWriter comparableStatFile = new FileWriter(compareStatFile);

        if(com.equals("code")) {
            Coder coder = new Coder();

            coder.Parse(scan, alphabet, outWriter);
            coder.PrintStat(statFile);
            coder.PrintComparableStat(comparableStatFile);
        }
        else if (com.equals("decode"))
        {
            Decoder decoder = new Decoder();

            decoder.Parse(scan, alphabetMorse, outWriter);
            decoder.PrintStat(statFile);

        }


        scan.close();
        readAlphabet.close();
        outWriter.close();
        statFile.close();
        comparableStatFile.close();
    }
}
