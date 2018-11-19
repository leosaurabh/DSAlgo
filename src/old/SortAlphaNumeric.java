/**
 * Created by ss030277 on 6/1/15.
 */
public class SortAlphaNumeric {

    public static void main(String args[]) {
        String str = "c4h3j6r7";
        Node numRoot = null;
        Node alphaRoot = null;

        int numStart = (int) '0';
        int numEnd = (int) '9';

        for (char ch : str.toCharArray()) {
            int chVal = (int) ch;
            if (chVal <= numEnd && chVal >= numStart) {
                numRoot = insert(numRoot, ch);
            } else {
                alphaRoot = insert(alphaRoot, ch);
            }
        }

        char[] arr = new char[str.length()];
        getSortedStr(alphaRoot, arr, 0);
        getSortedStr(numRoot, arr, 1);

        for (char ch : arr) {
            System.out.print(ch);
        }
    }

    private static Node insert(Node root, char c) {
        if (root == null) {
            root = new Node(c);
            return root;
        } else {
            Node temp = root;
            while(true) {
                if (c <= temp.ch) {
                    if (temp.left == null) {
                        temp.left = new Node(c);
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else {
                    if (temp.right == null) {
                        temp.right = new Node(c);
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }
        return root;
    }

    private static void getSortedStr(Node numRoot, char[] arr, int start) {
        if (numRoot == null) {
            return ;
        }

        Stack stack = new Stack();

        Node currentNum = numRoot;

        while (!stack.isEmpty() || currentNum != null) {
            if (currentNum != null) {
                stack.push(currentNum);
                currentNum = currentNum.left;
            } else {
                currentNum = stack.pop();
                arr[start] = currentNum.ch;
                start += 2;
                currentNum= currentNum.right;
            }
        }
    }
}
