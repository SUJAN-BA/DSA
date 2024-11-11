class LL{

    class node{
    int data;
    node next;

    node(int data){
        this.data=data;
        this.next=null;

    }
}

    node head=null,tail=null,temp=null;

    int count=0;

    void add_beg(int data){
        node newnode=new node(data);
        
        if(head==null){
                head=tail=newnode;

        }
        else{
        newnode.next=head;
        head=newnode;
        count++;
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
        System.out.println("\n size:"+count);

    }

    void add_end(int data){
         node newnode=new node(data);
         if(head==null){
            head=tail=newnode;
         }
         else{
            tail.next=newnode;
            tail=newnode;
            
         }
        }

         void add_pos(int pos,int data){
            node newnode=new node(data);
            
            if(pos<1 || pos>count+1){
                System.out.println("invalid ....position");
            }
            else if(pos==1){
                count++;
                add_beg(data);
            }
            else{
            
                temp=head;
                int i=1;
                while(i<pos-1){
                    temp=temp.next;
                    i++;
                }
                
                newnode.next=temp.next;
                temp.next=newnode;
                count++;
                if(newnode.next==null){
                    newnode=tail;
                }
            }

         }

    
void del_beg(){
    temp=head;
    head=head.next;
    temp=null;
    count--;
}

void del_end(){
    node prev=null;
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

void del_pos(int pos){
    node nextnode=null;
    if(pos<1){
        System.out.println("invalid...position");
    }
    else if(pos==1){
        del_beg();
    }
    else{
  temp=head;
  int i=1;
  while(i<pos-1){
    temp=temp.next;
    i++;
  }
    }
    nextnode=temp.next;
    temp.next=nextnode.next;
    nextnode=null;

    count--;

}

}

public class practice {
    public static void main(String[] args){

        LL list=new LL();

        list.add_beg(1);
        list.add_beg(2);

        list.display();
        

       list.add_end(3);
        list.add_end(4);

        list.display();

        list.add_pos(1,0);
        list.add_pos(3,5);

        list.display();

        list.del_beg();

        list.display();

        list.del_end();

        list.display();

        list.del_pos(4);

        list.display();

        



    }
}
