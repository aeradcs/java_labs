package Factory;

import java.util.List;
import java.util.logging.Level;

public class Pop implements Base {
    @Override
    public void DoWork(Context context, List<String> commandArgs)throws Exception
    {
        if(commandArgs.size() != 0)
        {
            throw new StackCalculatorException("wrong number of arguments in POP command");
        }
        try
        {
            Main.LOGGER.log(Level.INFO,"pop from stack");
            context.popFromStack();
        }
        catch (StackCalculatorException e)
        {
            Main.LOGGER.log(Level.INFO,"error:" + e);
            System.err.println(e);
        }
    }
}
