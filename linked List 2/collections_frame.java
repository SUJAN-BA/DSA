import java.util.*;

public class collections_frame {
    public static void main(String[] args){
        LinkedList<Integer> list=new LinkedList<>();

        list.addFirst(1);
        list.addFirst(2);

        System.out.println(list);

        list.addLast(3);
        list.addLast(4);

        System.out.println(list);

        int s=list.size();
        System.out.println("size:"+s);

        for(int i=0;i<list.size();i++){
             System.out.print(list.get(i)+"->");
        }

        list.removeFirst();
        System.out.println("\n"+list);

        list.removeLast();
        System.out.println(list);

        list.remove(1);
        System.out.println(list);
    }
}
