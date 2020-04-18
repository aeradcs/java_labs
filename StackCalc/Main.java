package Factory;

import java.util.*;
import java.io.*;

public class Main {

    static Context context = new Context();

    public static void main(String[] args)throws Exception {

        if(args.length == 0)
        {
            Scanner inputStream = new Scanner(System.in);

            String str = inputStream.nextLine();
            String[] splitedLine;
            ArrayList<String> commandArguments = new ArrayList<String>();

            CommandFactory commandFactory = new CommandFactory();
            while (!str.equals(""))
            {
                splitedLine = str.split(" ", 0);
                for (int i = 1; i < splitedLine.length; i++)
                {
                    if(splitedLine[i] != "")
                    {
                        commandArguments.add(splitedLine[i]);
                    }
                }
                if(!CommandFactory.findComInCache(splitedLine[0]))
                {
                    Base command = CommandFactory.create(splitedLine[0]);
                    command.DoWork(context, commandArguments);
                    CommandFactory.pushComToCache(splitedLine[0], command);
                }
                else
                {
                    Base command = CommandFactory.getInstance(splitedLine[0]);
                    command.DoWork(context, commandArguments);
                }

                context.printStack();
                context.printVars();

                commandArguments.clear();
                str = inputStream.nextLine();
            }

            inputStream.close();
        }
        else if(args.length == 1)
        {
            String path = "C:\\Users\\User\\IdeaProjects\\StackCalculator\\src\\Factory\\" + args[0];
            File inputFile = new File(path);
            Scanner inputStream = new Scanner(inputFile);

            String str = null;
            String[] splitedLine;
            ArrayList<String> commandArguments = new ArrayList<String>();

            CommandFactory commandFactory = new CommandFactory();
            while (inputStream.hasNext())
            {
                str = inputStream.nextLine();

                splitedLine = str.split(" ", 0);
                for (int i = 1; i < splitedLine.length; i++)
                {
                    if(splitedLine[i] != "")
                    {
                        commandArguments.add(splitedLine[i]);
                    }
                }
                if(!CommandFactory.findComInCache(splitedLine[0]))
                {
                    Base command = CommandFactory.create(splitedLine[0]);
                    command.DoWork(context, commandArguments);
                    CommandFactory.pushComToCache(splitedLine[0], command);
                }
                else
                {
                    Base command = CommandFactory.getInstance(splitedLine[0]);
                    command.DoWork(context, commandArguments);
                }

                context.printStack();
                context.printVars();

                commandArguments.clear();
                //str = inputStream.nextLine();
                //System.out.println(str);
            }

            inputStream.close();
        }
        else
        {
            //exeption
        }
    }


}