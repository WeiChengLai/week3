import java.io.*;
import java.util.*;

public class HW {
    
    public static void main(String[] args) throws IOException {
        int op;
        String character = new String();
        String put = new String();
        String []after = new String[100];
        HashMap hm = new HashMap();
        
		//write file (first)
        FileWriter fwriter = new FileWriter("char.txt",true);
        fwriter.flush();
        fwriter.close();
        //read file
        FileReader freader = new FileReader("char.txt");
        BufferedReader breader = new BufferedReader(freader);
        while(breader.ready())
        {
            String ch = breader.readLine();
            hm.put(ch,breader.readLine());
        }
        freader.close();
        while(true)
        {
            System.out.print("1)input string 2)the number of character which appear  -1)End: ");
            Scanner option = new Scanner(System.in);
            op = option.nextInt();
            if(op==-1)
            {
                //write file
                FileWriter fw = new FileWriter("char.txt",true);
                for (Object key : hm.keySet())
                {
                    fw.write(key+"\n"+hm.get(key)+"\n");
                }
                fw.flush();
                fw.close();
                break;
            }
            else if(op==1)
            {
                System.out.print("Enter a string: ");
                Scanner input = new Scanner(System.in);
                put = input.nextLine().toLowerCase();
                after = put.split("[\n|\t|\\,|\\.|\\!|\\?|\\s]+");
                for(int i = 0; i < after.length; i++)
                {
                    for(int j = 0; j < after[i].length(); j++)//look for a character
                    {
                        if(hm.get(after[i].charAt(j)) == null)
                        {
                            hm.put(after[i].charAt(j), 1);
                        }
                        else
                        {
                            int n = Integer.parseInt(hm.get(after[i].charAt(j)).toString());
                            hm.put(after[i].charAt(j), n+1);
                        }
                    }
                }
            }
            else if(op==2)
            {
                System.out.print("Enter a character: ");
                Scanner c = new Scanner(System.in);
                character = c.nextLine();
                if(hm.get(character) == null)
                {
                    System.out.println("Can't find character "+character);
                }
                else
                {
                    System.out.println("character: "+character);
                    System.out.println("the number of "+character+" : "+hm.get(character));
                }
            }
            System.out.println();
        }
    }
}