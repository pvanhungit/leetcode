

public class App {

    public static void main(String[] args) throws Exception {
        ListNode l1 = new ListNode(3);
        l1 = new ListNode(4, l1);
        l1 = new ListNode(2, l1);

        ListNode l2 = new ListNode(4);
        l2 = new ListNode(6, l2);
        l2 = new ListNode(5, l2);

        Solution solution = new Solution();

        ListNode rs = solution.addTwoNumbers(l1, l2);

        l1 = new ListNode(9);
        l1 = new ListNode(9, l1);
        l1 = new ListNode(9, l1);

        l2 = new ListNode(9);

        solution = new Solution();

        rs = solution.addTwoNumbers(l1, l2);

        System.out.println("done");
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode nextNode = new ListNode(0);
        ListNode result = nextNode, curL1 = l1, curL2 = l2;
        int ship = 0;
        while (curL1 != null || curL2 != null) {
            int val1 = curL1 != null ? curL1.val : 0;
            int val2 = curL2 != null ? curL2.val : 0;

            int totalVal = val1 + val2 + ship;
            int val = totalVal % 10;
            ship = totalVal / 10;
            nextNode.next = new ListNode(val);

            if (curL1 != null)
                curL1 = curL1.next;
            if (curL2 != null)
                curL2 = curL2.next;
            nextNode = nextNode.next;
        }

        if (ship > 0) {
            nextNode.next = new ListNode(ship);
        }

        return result.next;
    }
}
