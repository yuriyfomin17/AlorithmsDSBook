package LeetCode;

import java.util.ArrayList;

public class SwapNodesInPairs {
    /**
     * <h2>Time and Space Complexity Analysis</h2>
     * <p> One time pass through the list to collect nodes and second time pass through the list to reconstruct them. Hence,
     * it is O(2N)</p>
     * <p>Space Analysis: O(N) since we need to store nodes</p>
     **/

    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        else if (head.next == null) return head;
        ArrayList arrayList = new ArrayList();
        ListNode node = head;
        while (node!= null){
            ListNode newNode = node;
            arrayList.add(newNode);
            // System.out.println("newNode.val:" + newNode.val );
            node = node.next;
        }
        ListNode prev = null;
        ListNode node1 = null;
        ListNode node2 = null;
        ListNode newHead = null;
        for (int i = 0; i < arrayList.size(); i++) {
            if(i % 2 == 0) node1 = (ListNode) arrayList.get(i);
            else if (i % 2 == 1) node2 = (ListNode) arrayList.get(i);

            if (node1 != null && node2 != null){
                // System.out.println("node1.val:" + node1.val );
                // System.out.println("node2.val:" + node2.val );
                if (prev != null) prev.next = node2;
                if (newHead == null) newHead = node2;
                node2.next = node1;
                prev = node1;
                prev.next= null;
                node1 = null;
                node2 = null;
            }
        }
        if(node1 != null) prev.next = node1;
        else if(node2 != null) prev.next = node2;

        return newHead;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}



