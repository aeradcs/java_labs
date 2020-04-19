package Factory;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("C:\\Users\\User\\IdeaProjects\\StackCalculator\\src\\Factory\\log.txt")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Main.class.getName());
        } catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    static Context context = new Context();

    public static void main(String[] args)throws Exception {
        LOGGER.log(Level.INFO,"start main");

        if(args.length == 0)
        {
            try {
                Scanner inputStream = new Scanner(System.in);

                String str = inputStream.nextLine();
                String[] splitedLine;
                ArrayList<String> commandArguments = new ArrayList<String>();

                CommandFactory commandFactory = new CommandFactory();
                while (!str.equals("")) {
                    splitedLine = str.split(" ", 0);
                    for (int i = 1; i < splitedLine.length; i++) {
                        if (splitedLine[i] != "") {
                            commandArguments.add(splitedLine[i]);
                        }
                    }
                    if (!CommandFactory.findComInCache(splitedLine[0])) {
                        try {
                            LOGGER.log(Level.INFO,"create command " + splitedLine[0]);
                            Base command = CommandFactory.create(splitedLine[0]);
                            if(command == null)
                            {
                                throw new StackCalculatorException("Bad command");
                            }
                            LOGGER.log(Level.INFO,"execute command " + splitedLine[0]);
                            command.DoWork(context, commandArguments);
                            LOGGER.log(Level.INFO,"push " + splitedLine[0] + " command to cache");
                            CommandFactory.pushComToCache(splitedLine[0], command);
                        }
                        catch (StackCalculatorException e)
                        {
                            LOGGER.log(Level.INFO,"error: " + e);
                            System.err.println(e);
                        }
                    } else {
                        try {
                            LOGGER.log(Level.INFO,"get instance of existing command " + splitedLine[0]);
                            Base command = CommandFactory.getInstance(splitedLine[0]);
                            LOGGER.log(Level.INFO,"execute command " + splitedLine[0]);
                            command.DoWork(context, commandArguments);
                        }
                        catch (StackCalculatorException e)
                        {
                            LOGGER.log(Level.INFO,"error: " + e);
                            System.err.println(e);
                        }
                    }

                    //context.printStack();
                    //context.printVars();

                    commandArguments.clear();
                    str = inputStream.nextLine();
                }

                inputStream.close();
            }
            catch (Exception e)
            {
                LOGGER.log(Level.INFO,"error: " + e);
                System.err.println(e);
            }
        }
        else if(args.length == 1)
        {
            try {
                LOGGER.log(Level.INFO,"open file " + args[0]);
                String path = "C:\\Users\\User\\IdeaProjects\\StackCalculator\\src\\Factory\\" + args[0];
                File inputFile = new File(path);
                Scanner inputStream = new Scanner(inputFile);

                String str = null;
                String[] splitedLine;
                ArrayList<String> commandArguments = new ArrayList<String>();

                CommandFactory commandFactory = new CommandFactory();
                while (inputStream.hasNext()) {
                    str = inputStream.nextLine();

                    splitedLine = str.split(" ", 0);
                    for (int i = 1; i < splitedLine.length; i++) {
                        if (splitedLine[i] != "") {
                            commandArguments.add(splitedLine[i]);
                        }
                    }
                    if (!CommandFactory.findComInCache(splitedLine[0])) {

                        try {
                            LOGGER.log(Level.INFO,"create command " + splitedLine[0]);
                            Base command = CommandFactory.create(splitedLine[0]);
                            LOGGER.log(Level.INFO,"execute command " + splitedLine[0]);
                            command.DoWork(context, commandArguments);
                            LOGGER.log(Level.INFO,"push " + splitedLine[0] + " command to cache");
                            CommandFactory.pushComToCache(splitedLine[0], command);
                        }
                        catch (StackCalculatorException e)
                        {
                            LOGGER.log(Level.INFO,"error: " + e);
                            System.err.println(e);
                        }

                    } else {
                        try {
                            LOGGER.log(Level.INFO,"get instance of existing command " + splitedLine[0]);
                            Base command = CommandFactory.getInstance(splitedLine[0]);
                            LOGGER.log(Level.INFO,"execute command " + splitedLine[0]);
                            command.DoWork(context, commandArguments);
                        }
                        catch (StackCalculatorException e)
                        {
                            LOGGER.log(Level.INFO,"error: " + e);
                            System.err.println(e);
                        }
                    }

                    commandArguments.clear();
                }

                inputStream.close();
            }
            catch (Exception e)
            {
                LOGGER.log(Level.INFO,"error: " + e);
                System.err.println(e);
            }
        }
        else
        {
            LOGGER.log(Level.INFO,"error: wrong number of arguments");
            throw new Exception("Wrong number of arguments");
        }
    }

}