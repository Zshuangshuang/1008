/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-08
 * Time:9:10
 **/
class Node {
    private Node next;
    private int data;

    public Node(int data) {
        this.next = null;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
public class MyLinkedList {
    public Node head;

    public MyLinkedList() {
        this.head = head;
    }
    public void addLast(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.getNext() != null){
            cur = cur.getNext();
        }
        cur.setNext(node);
    }
    public void display(){
        Node cur  = this.head;
        while(cur != null){
            System.out.print(cur.getData()+"  ");
            cur = cur.getNext();
        }
        System.out.println();
    }
    public Node findToRemove(int toRemove){
        Node cur = this.head;
        while (cur.getNext() != null){
            if (cur.getNext().getData() == toRemove){
                return cur;
            }
            cur = cur.getNext();
        }
        return  null;
    }
    public void remove(int toRemove){
        if (this.head == null){
            return;
        }
        if (this.head.getData() == toRemove){
            this.head = this.head.getNext();
            return;
        }
        if (findToRemove(toRemove) == null){
            return;
        }
        Node prev = findToRemove(toRemove);
        Node del = prev.getNext();
        prev.setNext(del.getNext());
    }
    public void removeAllKey(int toRemove){
        Node prev = this.head;
        Node cur  = this.head.getNext();
        while(cur != null){
            if (cur.getData() == toRemove){
                prev.setNext(cur.getNext());
                cur = cur.getNext();
            }else {
                prev = cur;
                cur = cur.getNext();
            }
        }
        if (this.head.getData() == toRemove){
            this.head = this.head.getNext();
        }
    }
    public int size(){
        int count = 0;
        Node cur = this.head;
        while(cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }
    public void addFirst(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            return;
        }
        node.setNext(this.head);
        this.head = node;
    }
    private boolean checkPos(int pos){
        if (pos < 0  || pos > size()){
            return true;
        }
        return false;
    }
    public Node findPrev(int pos){
        Node cur  = this.head;
        while(pos-1 > 0){
            cur = cur.getNext();
            pos--;
        }
        return cur;
    }
    public void addIndex(int pos,int data){
        if (checkPos(pos)){
            return;
        }
        if (pos == 0){
            addFirst(data);
            return;
        }
        if (pos == size()){
            addLast(data);
            return;
        }
        Node node = new Node(data);
        Node prev = findPrev(pos);
        node.setNext(prev.getNext());
        prev.setNext(node);
    }

    public Node reverse(){
        if (this.head == null){
            return null;
        }
        Node prev = null;
        Node cur = this.head;
        Node newHead = null;
        while(cur != null){
            Node curNext = cur.getNext();
            if (curNext == null){
                newHead = cur;
            }
            cur.setNext(prev);
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    public void display2(Node newHead){
        Node cur = newHead;
        while(cur != null){
            System.out.print(cur.getData()+"  ");
            cur = cur.getNext();
        }
        System.out.println();
    }
    public Node middleNode(){
       Node slow = this.head;
       Node fast = this.head;
       while(fast != null && fast.getNext() != null){
           fast = fast.getNext().getNext();
           slow = slow.getNext();
       }
       return slow;
    }
    public Node findNum(int k){
       if (k < 0){
           return null;
       }
       if (this.head == null){
           return null;
       }
       Node fast = this.head;
       Node slow = this.head;
       while((k-1) > 0){
           if (fast.getNext() != null){
               fast = fast.getNext();
               k--;
           }else {
               System.out.println("没有当前节点");
               return null;
           }
       }
       while (fast.getNext() != null){
           fast = fast.getNext();
           slow = slow.getNext();
       }
       return slow;
    }
    public Node partition(int x){
       if (this.head == null){
           return null;
       }
       Node bs = null;
       Node be = null;
       Node as = null;
       Node ae = null;
       Node cur  =this.head;
       while(cur != null){
           if (cur.getData() <= x){
               if (bs == null){
                   bs = cur;
                   be = cur;
               }else {
                   be.setNext(cur);
                   be = be.getNext();

               }

           }else {
               if (as == null){
                   as = cur;
                   ae = cur;
               }else {
                   ae.setNext(cur);

                   be = be.getNext();
               }

           }
           cur = cur.getNext();
       }
       if (bs == null){
           return as;
       }else {
           be.setNext(as);
       }
      return as;
    }
    public Node removeALL(int key){
        if (this.head == null){
            return null;
        }
        Node newHead = new Node(-1);
        Node cur = this.head;
        Node tmp = newHead;
        while(cur != null){
            if (cur.getNext() != null && cur.getData() == cur.getNext().getData()){
               while(cur.getNext() != null && cur.getData() == cur.getNext().getData()){
                   cur = cur.getNext();
               }
               cur = cur.getNext();
            }else {
                tmp.setNext(cur);
                tmp = tmp.getNext();
                cur = cur.getNext();
            }
        }
        tmp.setNext(null);
        return newHead.getNext();
    }
    public boolean chkPalindrome(){
        if (this.head == null){
            return false;
        }
        if (this.head.getNext() == null){
            return true;
        }
        //1、找到中间节点
        Node slow = this.head;
        Node fast = this.head;
        while(fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        //2、反转slow后面的节点
        Node cur = slow.getNext();
        while(cur != null){
            Node curNext = cur.getNext();
            cur.setNext(slow);
            slow = cur;
            cur = curNext;
        }
        while(slow != this.head){
            if (slow.getData() != this.head.getData()){
                return false;
            }
            if (this.head.getNext() == slow){
                return true;
            }
            slow = slow.getNext();
            this.head = this.head.getNext();
        }
        return true;
    }
    public boolean isCycle(){
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.getNext()!= null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
    public Node deCycle(){
        if (this.head == null ){
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow){
                break;
            }
        }
        if (fast == null || fast.getNext() == null){
            return null;
        }
        fast = this.head;
        while(fast != slow){
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return slow;

    }

}
