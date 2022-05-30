public class Utils {
    public static int GetFirstTwo(int n)
    {
        while (n >= 100)
            n /= 10;
        return n;
    }
}
