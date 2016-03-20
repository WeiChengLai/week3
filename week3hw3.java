import java.io.*;
import java.util.*;

public class HW {
    
    public static void main(String[] args) throws IOException {
        int op;
        String search = new String();
        String put = new String();
        String []after = new String[100];
        HashMap hm = new HashMap();
        
        //write file (first)
        FileWriter fwriter = new FileWriter("string.txt",true);
        fwriter.flush();
        fwriter.close();
        //read file
        FileReader freader = new FileReader("string.txt");
        BufferedReader breader = new BufferedReader(freader);
        while(breader.ready())
        {
            String ch = breader.readLine();
            hm.put(ch,breader.readLine());
        }
        freader.close();
        while(true)
        {
            System.out.print("1)input sentence 2)the number of string which appear  -1)End: ");
            Scanner option = new Scanner(System.in);
            op = option.nextInt();
            if(op==-1)
            {
                //write file
                FileWriter fw = new FileWriter("string.txt",true);
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
                System.out.print("Enter a sentence: ");
                Scanner input = new Scanner(System.in);
                put = input.nextLine().toLowerCase();
                after = put.split("[\n|\t|\\,|\\.|\\!|\\?|\\s]+");
                for(int i = 0; i < after.length; i++)
                {
                    boolean isNum = false;
                    for(int j =0; j < after[i].length();j++)
                    {
                        if(Character.isDigit(after[i].charAt(j)))
                        {
                            isNum = true;
                            continue;
                        }
                    }
                    if(isNum!=true)
                    {
                        if(hm.get(after[i]) == null)
                        {
                            hm.put(after[i], 1);
                        }
                        else
                        {
                            int n = Integer.parseInt(hm.get(after[i]).toString());
                            hm.put(after[i], n+1);
                        }
                    }
                }
            }
            else if(op==2)
            {
                System.out.print("Enter a string: ");
                Scanner c = new Scanner(System.in);
                search = c.nextLine();
                if(hm.get(search) == null)
                {
                    System.out.println("Can't find string "+search);
                }
                else
                {
                    System.out.println("character: "+search);
                    System.out.println("the number of "+search+" : "+hm.get(search));
                }
            }
            System.out.println();
        }
    }
}