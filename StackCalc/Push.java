package Factory;

import java.util.List;
import java.util.logging.Level;

public class Push implements Base {
    @Override
    public void DoWork(Context context, List<String> commandArgs)throws Exception
    {
        if(commandArgs.size() != 1)
        {
            throw new StackCalculatorException("wrong number of arguments in PUSH command");
        }
        try {
            Main.LOGGER.log(Level.INFO,"get var value");
            Double num = context.getVarValue(commandArgs.get(0));
            Main.LOGGER.log(Level.INFO,"push num to stack");
            context.pushToStack(num);
        }
        catch (StackCalculatorException e)
        {
            Main.LOGGER.log(Level.INFO,"error:" + e);
            System.err.println(e);
        }
    }
}
