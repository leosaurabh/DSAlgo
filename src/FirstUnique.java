// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.

import java.util.*;

class FirstUnique {

    public static void main(String args[]) {
        Integer[] arr = new Integer[]{4,2,1,9,1,9,2};

        Node root = null;
        for(int num =0; num < arr.length; ++num) {
            root = sort(root, arr[num], num);
        }

        System.out.println(firstUnique(root));
    }

    private static Node sort(Node root, int num, int index) {
        if (root == null) {
            root = new Node(num, index);
            return root;
        } else {
            Node temp = root;
            while (true) {
                if (num <= temp.value) {
                    if (temp.left == null) {
                        temp.left = new Node(num, index);
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else {
                    if (temp.right == null) {
                        temp.right = new Node(num, index);
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }
        return root;
    }

    private static int firstUnique(Node root) {
        Stack stack = new Stack();
        Node current = root;

        int finalIndex = Integer.MAX_VALUE;
        int count = 0;

        Node last = null;
        int finalNum = 0;

        while(!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();

                if (last == null) {
                    ++count;
                } else {
                    if (current.value == last.value) {
                        ++count;
                    } else {
                        if (count == 1 && last.index < finalIndex) {
                            finalIndex = last.index;
                            finalNum = last.value;
                        }
                        count = 1;
                    }
                }
                last = current;

                current = current.right;
            }
        }

        if (count == 1 && last.index < finalIndex) {
            finalNum = last.value;
        }

        return finalNum;
    }
}