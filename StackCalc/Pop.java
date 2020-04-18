package Factory;

import java.util.List;

public class Pop implements Base {
    @Override
    public void DoWork(Context context, List<String> commandArgs)
    {
        context.popFromStack();
    }
}
