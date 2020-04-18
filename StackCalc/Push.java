package Factory;

import java.util.List;

public class Push implements Base {
    @Override
    public void DoWork(Context context, List<String> commandArgs)
    {
        Double num = context.getVarValue(commandArgs.get(0));
        context.pushToStack(num);
    }
}
