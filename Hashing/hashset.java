import java.util.*;

public class hashset {
    public static void main(String args[]){
    HashSet<Integer> set=new HashSet<>();
//insert an element

set.add(1);
set.add(2);
set.add(3);
set.add(4);
System.out.println(set);

//deleting

set.remove(1);
System.out.println("after remove:"+set);

//searching
if(set.contains(2)){
    System.out.println("2 is found");

}
if(!set.contains(1)){
    System.out.println("1 not present");
}

//size

System.out.println("size of set:"+set.size());


//iterator

Iterator it= set.iterator();

System.out.println("by using hashset:");

while(it.hasNext()){
    System.out.print(it.next()+" ");
}

    }
}
