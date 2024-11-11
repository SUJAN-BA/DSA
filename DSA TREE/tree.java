import java.util.*;

public class tree{
    static class node{
        int data;
        node right,left;

        node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static node construct(node root,int val){
        if(root==null){
            root=new node(val);
        }
        else if(val<root.data){
            root.left=construct(root.left,val);

        }
        else if(val>root.data){
            root.right=construct(root.right,val);
        }

        return root;

    }

    static void inorder(node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }

    static boolean search(node root,int key){
        if(root==null){
            return false;
        }
       else if(key==root.data){
            return true;
        }
        else if(key<root.data){
            return search(root.left,key);
        }
        else{
            return search(root.right,key);
        }
    }

    static node delete(node root,int n){
        
         if(n<root.data){
            root.left= delete(root.left,n);
        }
        else if(n>root.data){
            root.right= delete(root.right,n);
        }
        else{
            if(root.left==null && root.right==null){
                return null;
            }

            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            
            else{
                node IS=inorder_sucessor(root.right);
                root.data=IS.data;
                root.right=delete(root.right,IS.data);
            
            }
        }
            return root;
        }

        static node inorder_sucessor(node root){
            while(root.left!=null){
                root=root.left;
            }
            return root;
        }

        static void range(node root,int x,int y){
            if(root==null){
                return;
            }
           if (x<=root.data && y>=root.data){
                range(root.left,x,y);
                System.out.print(root.data+" ");
                range(root.right,x,y);

            }

            if(x>=root.data){
                range(root.right,x,y);
            }

            if(y<=root.data){
                range(root.left,x,y);
            }
        }

        static node path_to_leaf(node root ,ArrayList<Integer> path){
            if(root==null){
                return null;
            }
            path.add(root.data);

            if(root.left==null && root.right==null){
                for(int i=0;i<path.size();i++){
                    System.out.print(path.get(i)+"->");
                }
                System.out.println();
            }
            else{
                path_to_leaf(root.left,path);
                path_to_leaf(root.right,path);
            }

            path.remove(path.size()-1);

            return root;
        }
    
    public static void main(String[] args){
        int val[]={8,5,3,1,4,6,10,11,14};

        node root=null;

        for(int i=0;i<val.length;i++){
            root=construct(root,val[i]);
        }

        inorder(root);
     
   System.out.println();
        if(search(root,1)){
            System.out.println("key found");
        }
        else{
            System.out.println("key not found");
        }

        delete(root,3);
        System.out.println("after delete:");
        inorder(root);
        System.out.println();

        System.out.println("range:");
        range(root,1,6);

        System.out.println("path:");
        path_to_leaf(root,new ArrayList<>());
}
}
