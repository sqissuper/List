package list;

import java.awt.dnd.DnDConstants;

class DNode{
    public int val;
    public DNode next;
    public DNode prev;

    public DNode(int val) {
        this.val = val;
    }
}
public class DoubleLinkedList {
    public DNode head;
    public DNode tail;

    public void nodeList(){
        this.head = new DNode(1);
        DNode dn1 = new DNode(2);
        DNode dn2 = new DNode(3);
        this.tail = new DNode(4);
        this.head.next = dn1;
        dn1.next = dn2;
        dn2.next = this.tail;
        this.tail.prev = dn2;
        dn2.prev = dn1;
        dn1.prev = this.head;

    }
    //打印
    public void disPlay() {
        DNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    //头插
    public void headInsert(int val) {
        DNode node = new DNode(val);
        if(this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head.prev = node;
        this.head = node;

    }
    //尾插
    public void tailInsert(int val) {
        DNode node = new DNode(val);
        if(this.head == null) return;
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;
    }

    //任意位置插入
    public void insert(int index, int val) {
        if(index < 0 || index > size()) return;
        if(index == 0) {
            headInsert(val);
            return;
        }
        if(index == size()) {
            tailInsert(val);
            return;
        }
        DNode node = new DNode(val);
        DNode cur = this.head;
        while(index - 1 != 0) {
            cur = cur.next;
            index--;
        }
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }

    public int size() {
        int count = 0;
        DNode cur = this.head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //查找下标节点
    public DNode finNode(int index) {
        if(index <= 0 || index > size()) return null;
        DNode cur = this.head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //查找关键值节点
    public DNode finKey(int key) {
        DNode cur = this.head;
        while(cur != null) {
            if(cur.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除节点
    public void delNode(int key) {
        DNode ret = finKey(key);
        if(this.head == null) return;
        if(ret == null) return;
        if(this.head == ret) {
            this.head = this.head.next;
            this.head.prev = null;
        }
        if(ret == this.tail) {
            this.tail = this.tail.prev;
            this.tail.prev.next = null;
        }
        ret.prev.next = ret.next;
        ret.next.prev = ret.prev;
    }

    //删除所有的key节点
    public void allKey(int key) {
        DNode cur = this.head;
        if(this.head == null) return;
        while(cur != null) {
            if(cur.val == key) {
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                    return;
                } else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.tail = this.tail.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }


    public static void main(String[] args) {
        DoubleLinkedList dl = new DoubleLinkedList();
        dl.nodeList();
        dl.disPlay();
        System.out.println();
        dl.headInsert(0);
        dl.headInsert(0);
        dl.tailInsert(5);
        dl.tailInsert(5);
        dl.insert(3,5);
        dl.insert(4,55);
        dl.disPlay();
        System.out.println();
        dl.allKey(5);
        dl.disPlay();
        System.out.println();
        System.out.println(dl.finNode(3).val);


    }
}
