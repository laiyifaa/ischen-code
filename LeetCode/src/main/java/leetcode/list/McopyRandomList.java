package leetcode.list;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class McopyRandomList {
    //138. 复制带随机指针的链表
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(null == head)
            return null;
       Node x = head;
       Node q  = new Node(0);
       Node p = q;
       while (null != x){
           Node z = new Node(x.val);
           map.put(x,z);
           x = x.next;
           q.next = z;
           q = z;
       }
       x = head;
       q = p.next;
       while(null != x){
           Node r = x.random;
           if(map.containsKey(r)){
               q.random = map.get(r);
           }else {
               q.random = null;
           }
           x = x.next;
           q = q.next;
       }
       return p.next;
    }
}
