//Insert delete and search in O(1) time.
import java.util.ArrayList;
import java.util.HashMap;
public class FDS
{
    private ArrayList<Integer> data;
    private HashMap<Integer, ArrayList<Integer>> hash;
    FDS()
    {
        data = new ArrayList<Integer>();
        hash = new HashMap<Integer, ArrayList<Integer>>();
    }
    void add(int x, FDS obj)
    {
        obj.data.add(x);
        if(obj.hash.containsKey(x))
        {
            obj.hash.get(x).add(obj.data.size() - 1);
        }
        else
        {
            obj.hash.put(x, new ArrayList<Integer>(Arrays.asList(obj.data.size() - 1)));
        }
    }
    void del(int x, FDS obj)
    {
        if(obj.hash.containsKey(x))
        {
            if(obj.hash.get(x).size() == 1)
            {
                int index = obj.hash.get(x).get(0);
                obj.hash.remove(x);
                obj.data.remove(index);
            }
        }
        else System.out.println("Existence = NULL");
    }
    void search(int x, FDS obj)
    {
        if(obj.hash.containsKey(x))
        {
            System.out.println(obj.hash.get(x));
        }
        else System.out.println("Not Found");
    }
}