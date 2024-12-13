// input a string from the user and creat a new string called "result" in which you relace letter 'e' in the original string wih letter 'i'
import java.util.*;
public class hw2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the string:");
        String str=sc.next();

        String result=" ";

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='e'){
                result+='i';

            }
            else{
                result+=str.charAt(i);
            }
        }
        System.out.println("result string is:"+result);
        sc.close();


    }
}