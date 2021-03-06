package LeetCode;

import java.util.ArrayList;
import java.util.Date;

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

    /**
     * <h2>Time and Space Complexity Analysis</h2>
     * <p>Time Complexity: O(n). It is one time pass. We need to pass only one time through list to reverse nodes. </p>
     * <p>Space Complexity: O(1). If not counting the initial memory required for linked list then it is constant amount of memory </p>
     * */

    public static ListNode swapPairs2(ListNode head){
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode prev = null;
        ListNode newHead = null;
        while (node1 != null && node2 != null){
            ListNode temp = node2.next;

            if (prev != null) prev.next = node2;
            if (newHead == null) newHead = node2;
            node2.next = node1;
            node1.next = temp;
            prev = node1;
            // System.out.println(":" + node1.val);
            // System.out.println("node1:" + node1.val);
            // System.out.println("node2:" + node2.val);
            node1 = temp;
            if (temp != null) node2 = temp.next;

        }

        if (node1 != null) prev.next = node1;

        return newHead;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Date date = new Date();
        String nullVal = null;
        if (nullVal == null) System.out.println("null");
        System.out.println(date);
        int  b = 5;
        b =  b << 3;
        System.out.println(b);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        swapPairs2(node1);
    }
}



