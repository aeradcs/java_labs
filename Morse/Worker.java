import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public interface Worker {
    void Parse(Scanner in, HashMap<String, String > hashMap,  FileWriter outWriter);
}
