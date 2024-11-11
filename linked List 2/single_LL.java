import java.util.*;
class ll{
    class node{
        int data;
        node next;
        node(int data){
            this.data=data;
            this.next=null;

        }

    }
    int count=0;
    node head=null,tail=null,temp;

    void insert_beg(int data){
        node newnode= new node(data);
        if(head==null){
            head=tail=newnode;
        }
        else{
            newnode.next=head;
            head=newnode;
            count++;
        }
    }

    void insert_end(int data){
        node newnode=new node(data);
        if(head==null){
            head=tail=null;
        }
        else{
            tail.next=newnode;
            tail=newnode;
            count++;
        }
    }

    void insert_pos(int pos,int data){
        

        

        if(pos<1||pos>count+1){
            System.out.println("invalid...!");
        }
        else if(pos==1){
            insert_beg(data);
        }
        else{
            node newnode=new node(data);
          temp=head;
          int i=1;
          while(i<pos-1){
            
            temp=temp.next;
            i++;
          }
          newnode.next=temp.next;
          temp.next=newnode;
          if(newnode.next==null){
            tail=newnode;
          }
          count++;
        }
    }

    void delete_beg(){
        if(head==null){
            System.out.println("list empty");
        }
        else{
            temp=head;
            head=head.next;
            temp=null;
            count--;
        }
    }

    void delete_end(){
        node prev=null;
        if(head==null){
            System.out.println("list empty");
        }
        else{
            temp=head;
            while(temp.next!=null){
                prev=temp;
                temp=temp.next;
            }
            prev.next=null;
            tail=prev;
            temp=null;
            count--;
        }
    }

    void delete_pos(int pos){
        node nextnode=null;
        if(pos<1){
            System.out.println("invalid position");
        }
        else{
            temp=head;
            int i=1;
            while(i<pos-1){
                temp=temp.next;
                i++;
            }
            int val=temp.data;
             nextnode=temp.next;/*it should be same order */
            temp.next=nextnode.next;
            nextnode=null;
            
            count--;

        }
    }

    void display(){
        int count=0;
        temp=head;
        while(temp!=null){
            count++;
            System.out.print(temp.data+"->");
             temp=temp.next;
        }
        System.out.println();
        System.out.println("number of node:"+count);

    }
}




public class single_LL {
    public static void main(String[] args){
        ll obj=new ll();
        obj.insert_beg(1);
        obj.insert_beg(2);
        obj.insert_beg(3);
        obj.insert_beg(4);

        obj.display();

        obj.insert_end(6);
        obj.insert_end(8);
        obj.insert_end(7);

        obj.display();

        obj.delete_beg();
        obj.delete_end();

        obj.display();

        obj.delete_pos(2);

        obj.display();

        obj.delete_pos(4);

        obj.display();

        obj.insert_pos(2,4);
        obj.display();

    }
}
