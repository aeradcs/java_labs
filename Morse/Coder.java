import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

final public class Coder implements Worker {
    private HashSet<Statistics> stat = new HashSet<>();
    private TreeSet<Statistics> stat2 = new TreeSet<Statistics>();


    public void Parse(Scanner in, HashMap<String, String > alphabet,  FileWriter outWriter)
    {
        String curStr;
        char ch;
        Integer num;

        while (in.hasNextLine())
        {
            curStr = in.nextLine();
            for (int i = 0; i < curStr.length() ; i++)
            {
                ch = curStr.charAt(i);

                Statistics objStat = new Statistics(ch);////////////////////

                stat.add(objStat);/////////////////////

                //stat2.add(objStat);

                String s = String.valueOf(ch);
                s = alphabet.get(s);

                try
                {
                    outWriter.write( s + " ");
                }
                catch(IOException ex)
                {
                    ex.printStackTrace();
                }
            }
            try
            {
                outWriter.write("\n");
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    public void PrintStat(FileWriter statFile)
    {
        char ch;
        int count;
        for (Statistics o:stat) {
            ch = o.GetCh();
            count = o.GetCount();
            try
            {
                statFile.write(ch + " " + count + "\n");
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    public void PrintComparableStat(FileWriter statFile)
    {
        char ch;
        int count;
        fillStat2();
        for (Statistics o:stat2) {
            ch = o.GetCh();
            count = o.GetCount();
            try
            {
                statFile.write(ch + " " + count + "\n");
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    public void fillStat2() {
        for (Statistics st : stat) {
            stat2.add(st);
        }
    }
}
