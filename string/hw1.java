//take an array string as input from the user and find the combined length of all those strings

import java.util.*;

public class hw1{
public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
    System.out.println("enter the size:");
     int size=sc.nextInt();

     String name[]=new String[size];

     System.out.println("enter the strings:");
     int totallength=0;
     for( int  i=0;i<size;i++){
        name[i]=sc.next();
     
         totallength+=name[i].length();
     }
     
     System.out.println(totallength);
     sc.close();



}

}
