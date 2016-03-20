import java.io.*;
import java.util.*;

public class HW {
    
    public static void main(String[] args) {
        int op,count=0;//op決定輸入或印出，count計數輸入幾串字串
        String []put = new String[100];//存放每次輸入的字串
        String []after = new String[100];//存放分解過後的字串
        int i,j,q,w;
        
        while(true)
        {
            System.out.print("1)input string 2)print & sort & count number -1)End:");
            Scanner option = new Scanner(System.in);
            op = option.nextInt();
            ArrayList<String> al = new ArrayList<String>();    //arraylist al 
            int number=0;//累計數字字串
            if(op == -1)
                break;
            else if(op == 1)
            {
                System.out.print("Enter a string:");
                Scanner input = new Scanner(System.in);
                put[count++] = input.nextLine().toLowerCase(); 
            }
            else if(op == 2)
            {
                int hot=0;
                for(i = 0 ; i < count ; i++)
                {
                    after = put[i].split("[\n|\t|\\,|\\.|\\!|\\?|\\s]+");
                    for (j = 0 ; j < after.length ; j++)
                    {
                        boolean isNumber=false;
                        int isN=0;
                        for(w = 0;w < after[j].length(); w++)//判斷是否含有數字
                        {
                            if(Character.isDigit(after[j].charAt(w)))//每次抓一個字元
                            {
                                isNumber=true;
                                isN++;//判斷是否為數字字串
                            }
                        }
                        if(isN==after[j].length())
                        {
                                number += Integer.parseInt(after[j]);//累計數字字串
                        }
                        if(isNumber!=true)
                        {
                            if(al.size() == 0)//第一次不用判斷是否重複
                            {	
                                            al.add(after[j]);
                            }
                            else  //判斷重複              
                            {
                                hot=0;
                                for(q = 0 ; q < al.size() ; q++)
                                {
                                    if(after[j].equals(al.get(q))==true)
                                    {
                                                    hot = 1;
                                                    break;
                                    }
                                }
                                if(hot == 0)
                                {
                                                al.add(after[j]);
                                }
                            }
                        }                        
                    }
                }
                Collections.sort(al);
                System.out.println(al);
                System.out.println("數字累加："+number);
            }
            else
                continue;
            
            System.out.println("");
        } 
    }
}