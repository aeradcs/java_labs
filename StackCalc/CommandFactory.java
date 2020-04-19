package Factory;
import java.io.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;

public class CommandFactory {
    private static Properties properties = new Properties();
    private static HashMap<String, Base> cacheForComs = new HashMap<>();

    CommandFactory()
    {
        try
        {
            Main.LOGGER.log(Level.INFO,"load properties");
            InputStream inputStream = CommandFactory.class.getResourceAsStream("coms.properties");
            properties.load(inputStream);
        }
        catch (Exception e)
        {
            Main.LOGGER.log(Level.INFO,"error: " + e);
            System.err.println("Bad properties" + e);
        }
    }
    public static Base create(String comName)
    {
        Base baseCom = null;
        try
        {
            Main.LOGGER.log(Level.INFO,"create new instance of object");
            String className = properties.getProperty(comName);
            baseCom = (Base)Class.forName(className).getDeclaredConstructor().newInstance();

        }
        catch(Exception e)
        {

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
