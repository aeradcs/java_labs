package Factory;

import java.util.List;
import java.lang.Math;

public class Sqrt implements Base {
    @Override
    public void DoWork(Context context, List<String> commandArgs)
    {
        Double numberFromStack = context.popFromStack();
        Double res = Math.sqrt(numberFromStack);
        context.pushToStack(res);
        //context.changeVariable();

    }
}
