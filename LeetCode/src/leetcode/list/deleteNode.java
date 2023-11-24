package leetcode.list;

public class deleteNode {
    //面试题 02.03. 删除中间节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
