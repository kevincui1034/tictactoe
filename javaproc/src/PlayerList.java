import java.util.*;

public class PlayerList
{
    private BinarySearchTree<String> nameList;
    private HashMap<String, Integer> ageList;

    public PlayerList()
    {
        nameList = new BinarySearchTree<>();
        ageList = new HashMap<>();
    }

    public void insert(String name, int age)
    {
        nameList.insert(name);
        ageList.put(name, age);
    }

    public boolean findAge(int age)
    {
        Integer newAge = ageList.get(age);
        if (newAge != null)
            return true;
        else
            return false;
    }

    public boolean findName(String name)
    {
        return nameList.contains(name);
    }

    public void printPlayerList()
    {
        Iterator alIterator = ageList.entrySet().iterator();
        System.out.println("====Here are the players====");

        while(alIterator.hasNext())
        {
            Map.Entry key = (Map.Entry)alIterator.next();
            System.out.printf("Player: %s%nAge: %d%n%n", key.getKey(), key.getValue());
        }
    }

}
