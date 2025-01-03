import java.util.*;

public class hashmap {
    public static void main(String[] args){
        //key as country name,value as number
        HashMap<String,Integer> map=new HashMap<>();
        map.put("india",120);
        map.put("china",20);
        map.put("usa",30);
        map.put("Russia",70);

        System.out.println(map);

        //updating
        map.put("china",140);
        System.out.println("after update:"+map);

        //search
        if(map.containsKey("china")){
            System.out.println("exist");
        }
        else{
            System.out.println("not exist");
        }

        //get key value
        System.out.println("getting key value:"+map.get("india"));

        //iteration
        for(Map.Entry<String,Integer>e:map.entrySet()){
            System.out.print(e.getKey()+"=");
            System.out.print(e.getValue()+" ");
        }

        //remove
        System.out.println();
        map.remove("china");
        System.out.println("after remove:"+map);
    }
}

