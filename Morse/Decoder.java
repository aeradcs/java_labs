import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

final public class Decoder implements Worker {
    private HashSet<Statistics> stat = new HashSet<>();

    public void Parse(Scanner in , HashMap<String, String > alphabetMorse,  FileWriter outWriter)
    {
        String curStr, s;
        char ch;

        while (in.hasNextLine()) {
            curStr = in.nextLine();

            if(!curStr.equals("")) {
                String[] arr = curStr.split(" ", 0);

                for (int i = 0; i < arr.length; i++) {

                    s = alphabetMorse.get(arr[i]);
                    ch = s.charAt(0);
                    Statistics objStat = new Statistics(ch);////////////////////
                    stat.add(objStat);/////////////////////

                    if (s.equals(" ")) {
                        try {
                            outWriter.write(" ");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        try {
                            outWriter.write(s);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
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
}
