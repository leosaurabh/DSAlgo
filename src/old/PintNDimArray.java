/**
 * Created by ss030277 on 5/28/15.
 */
public class PintNDimArray {
    public static void main(String args[])
    {
        String a[][][] =
                        {
                            {
                                { "a", "b" },
                                { "c", "d" },
                                { "e", "f" } },
                            {
                                { "g", "h" },
                                { "i", "j" },
                                { "k", "l" } }
                        };
        printArray(a);
    }

    public static void printArray(Object obj)
    {
        Class cls = obj.getClass();
        Object obj1[] = (Object[]) cls.cast(obj);
        if (cls.getComponentType().isArray())
        {
            for (Object obj2: obj1)
            {
                printArray(obj2);
            }
        }
        else
        {
            System.out.print("\n");
            for (int i = 0; i < obj1.length; i++)
            {
                System.out.print(obj1[i]);
            }
        }
    }
}
