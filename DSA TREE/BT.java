import java.util.*; 
 
 /*class node{
    int data;
    node left;
    node right;

    node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }

}

 class binarytree{
   int idx=-1;
    node buildtree(int num[]){
        idx++;
       if(num[idx]==-1){
        return null;
       }
       node newnode =new node(num[idx]);
       newnode.left=buildtree(num);
       newnode.right=buildtree(num);

       return newnode;
    }
}*/



public class BT{
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
 //construct a binary tree
    static class binarytree{
      static int idx=-1;
       static node buildtree(int num[]){
            idx++;
           if(num[idx]==-1){
            return null;
           }
           node newnode =new node(num[idx]);
           newnode.left=buildtree(num);
           newnode.right=buildtree(num);

           return newnode;
        }
    }

    //preorder traversal
    static void preorder(node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
        
        
    }


    
 

    //inoeder traversal

    static void inorder(node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    //postorder traversal
    static void postorder(node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");

    }
    
    //level order traversal
     static void levelorder(node root){
        if(root==null){
            return;
        }
        Queue<node> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int levelsize=q.size();//current level size;

            for(int i=0;i<levelsize;i++){
                node currnode=q.remove();
                System.out.print(currnode.data+" ");
                if(currnode.left!=null){
                    q.add(currnode.left);
                }
                if(currnode.right!=null){
                    q.add(currnode.right);
                }


            }
            System.out.println();
        }
     }


     //counting nodes

     static int count(node root){
        if(root==null){
            return 0;
        }
        int leftnode=count(root.left);
        int rightnode=count(root.right);
        

        return leftnode+rightnode+1;//if in place of 1 if we give root.data it give sum all operation depends on that position
     }

     //sum of nodes

     static int sum(node root){
        if(root==null){
            return 0;
        }
        
            int leftsum=sum(root.left);
            int rightsum=sum(root.right);

            return leftsum+rightsum+root.data;
        
     }

     //height of a tree

     static int height(node root){
        if(root==null){
            return 0;
        }
        int leftheight=height(root.left);
        int rightheight=height(root.right);

        int treeheight=Math.max(leftheight,rightheight)+1;

        return treeheight;
     }

     static int diameter1(node root){
        if(root==null){
            return 0;
        }
        int d1=diameter1( root.left);
        int d2 =diameter1(root.right);
        int d3=height(root.left)+height(root.right)+1;

       int tree_diameter=Math.max(d3,Math.max(d1,d2));
       return tree_diameter;
     }


   
    public static void main(String[] args){
        int num[]={ 1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binarytree obj=new binarytree();
         


        node root=obj.buildtree(num); 

        System.out.println("preorder:");
        preorder(root);

        System.out.println("\ninorder:");
        inorder(root);

        System.out.println("\npostorder:");
        postorder(root);
    
        System.out.println("\nlevelorder:");
        levelorder(root);

        System.out.println("\nroot of tree="+root.data);

        System.out.println("number of node:"+count(root));

        System.out.println("sum of all node:"+sum(root));

        System.out.println("height of a tree:"+height(root));

        System.out.println("diameter ofa tree :"+diameter1(root));
    }
}