import java.util.*;

public class BST {
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
//construct BST
    static node insert(node root,int val){
        if(root==null){
            root=new node(val);
        }
        else if(val<root.data){
            root.left=insert(root.left,val);
        }
        else{
            root.right=insert(root.right,val);
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


    //searching the key
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
            //key>root.data
            return search(root.right,key);
        }
    }

    //deleting the node
    static node delete(node root,int n){
        //searchinfg for node to delete
        if(n<root.data){
          root.left=delete(root.left,n);
        }

        else if(n>root.data){
            root.right=delete(root.right,n);
        }

        else{//root.data=n

            //case 1
            if(root.left==null && root.right==null){
                return null;
            }

            //case 2
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            //case 3

        node IS=inorder_sucessor(root.right);
        root.data=IS.data;
        root.right=delete(root.right,IS.data);

        }  
        return root;  
    }

    static node inorder_sucessor(node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    //range value
    static void range(node root,int x,int y){
        if(root==null){
            return;
        }
        
        if(x<=root.data && y>=root.data){
            range(root.left,x,y);
            System.out.print(root.data+" ");
            range(root.right,x,y);
        }
        else if(x>=root.data){
            range(root.right,x,y);
        }
        else if(y<=root.data){
            range(root.left,x,y);
        }
    }

    //root to leaf path
    static void root_to_leaf(node root,ArrayList<Integer> path){
        if(root==null){
            return;
    }
//fallowing preorder method
    path.add(root.data);

    if(root.left==null && root.right==null){//reaching leaf node
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }
    else{
       root_to_leaf(root.left,path);
       root_to_leaf(root.right,path);
    }
 
    path.remove(path.size()-1);//remove node from the list once reach leaf node

    }

    public static void main(String[] args){
        int val[]={8,5,3,1,4,6,10,11,14};

        node root=null;

        for(int i=0;i<val.length;i++){
            root=insert(root,val[i]);
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

    System.out.print("\nrange:");
    range(root,1,6);

    System.out.print("\nroot to leaf path:");
    root_to_leaf(root,new ArrayList<>());//otput not same as in vedio since we perform delete method in same code

}

}





























