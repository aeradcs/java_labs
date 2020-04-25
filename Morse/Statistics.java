public class Statistics implements Comparable<Statistics> {
    char ch;
    int counter = 1;

    public int hashCode()
    {
        return ch;
    }
    Statistics(char ch)
    {
        this.ch = ch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Statistics that = (Statistics) o;
        that.counter++;
        return ch == that.ch/* && counter == that.counter*/;
    }
    public int GetCount()
    {
        return this.counter;
    }
    public char GetCh()
    {
        return this.ch;
    }

    @Override
    public int compareTo(Statistics statistics) {


            if (this.counter == statistics.counter) {
                return 0;
            } else if (this.counter < statistics.counter) {
                return -1;
            } else
            {
                return 1;
            }

    }
}
