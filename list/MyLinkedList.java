package list;
class Node{
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class MyLinkedList {
    public Node head;
    //原链表
    public void addVal(){
        this.head = new Node(1);
        Node nod1 = new Node(2);
        Node nod2 = new Node(3);
        Node nod3 = new Node(4);
        this.head.next = nod1;
        nod1.next = nod2;
        nod2.next = nod3;
    }

    //打印
    public void disPlay(){
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    //头插
    public void headInsert(int val){
        Node node = new Node(val);
        if(this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    //尾插
    public void tailInsert(int val){
        Node node = new Node(val);
        if(this.head.next == null) {
            this.head.next = node;
            return;
        }
        Node cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    public int size(){
        int count = 0;
        Node cur = this.head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    //任意位置插入
    public void insert(int index,int val) {
        if(index <= 0 || index > size()) return;
        if(index == 1){
            headInsert(val);
            return;
        }
        if(index == size()) {
            tailInsert(val);
            return;
        }
        Node node = new Node(val);
        Node cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
            if(count == index - 1){
                break;
            }
        }
        node.next = cur.next.next;
        cur.next = node;

    }

    //查找元素
    public Node findNode(int index){
        if(index < 0 || index > size()) return null;
        if(this.head == null) return null;
        Node cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //删除节点
    public void delNode(int val){
        if(this.head == null) return;
        if(this.head.val == val) {
            this.head = this.head.next;
            return;
        }
        Node cur = this.head;
        while(cur.next != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next;

            }
            cur = cur.next;
        }
        return;
    }
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.addVal();
        myList.disPlay();
        System.out.println();
        myList.headInsert(0);
        myList.tailInsert(5);
        myList.disPlay();
       // System.out.println(myList.findNode(0).val);
        myList.delNode(0);
        myList.disPlay();


    }

}
