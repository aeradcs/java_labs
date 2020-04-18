package Factory;
import java.io.*;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Properties;

public class CommandFactory {
    private static Properties properties = new Properties();
    private static HashMap<String, Base> cacheForComs = new HashMap<>();

    CommandFactory()
    {
        try
        {
            InputStream inputStream = CommandFactory.class.getResourceAsStream("coms.properties");
            properties.load(inputStream);
        }
        catch (Exception E)
        {
            System.out.println("errorr");
        }
    }
    public static Base create(String comName)
    {

        Base baseCom = null;
        try
        {
            String className = properties.getProperty(comName);
            baseCom = (Base)Class.forName(className).getDeclaredConstructor().newInstance();//кэшировать в мэп
            //название-ссылка на объетк
        }
        catch(Exception e)
        {
            System.out.println("errorrrrr");
        }
        return baseCom;
    }
    public static void pushComToCache(String comName, Base base)
    {
        cacheForComs.put(comName, base);

    }
    public static Boolean findComInCache(String comName)
    {
        if(cacheForComs.containsKey(comName))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static Base getInstance(String comName)
    {
        return cacheForComs.get(comName);
    }
}
