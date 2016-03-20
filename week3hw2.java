import java.io.*;
import java.util.*;

public class HW {
    
    public static void main(String[] args) {
        int op,sc;
        String name = new String();
        HashMap hm = new HashMap();
        
        while(true)
        {
            System.out.print("1)input student name & score 2)search by student name -1)End:");
            Scanner option = new Scanner(System.in);
            op = option.nextInt();
            if(op==-1)
                break;
            else if(op==1)
            {
                System.out.print("Name: ");
                Scanner na = new Scanner(System.in);
                name = na.nextLine();
                System.out.print("Score: ");
                Scanner s = new Scanner(System.in);
                sc = s.nextInt();
                hm.put(name,sc);//put in hashmap
            }
            else if(op==2)
            {
                System.out.print("Enter a name: ");
                Scanner na = new Scanner(System.in);
                name = na.nextLine();
                if(hm.get(name) == null)
                    System.out.println("Can't find student "+name);
                else
                {
                    System.out.println("Name: "+name);
                    System.out.println("Score: "+hm.get(name));
                }
            }
            System.out.println("");
        }
    }
}