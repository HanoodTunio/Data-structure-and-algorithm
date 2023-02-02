/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.binarytree;

/**
 *
 * @author Mr.Smart
 */
public class BinaryTree {

    Node root;
    int sum = 0;

    class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }

    public void insertData(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }

                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean searchData(Node root, int key) {
        boolean isTrue = false;
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (key < root.data) {
            if (root.left != null) {
                isTrue = searchData(root.left, key);
            }
        } else if (root.right != null) {
            isTrue = searchData(root.right, key);
        }

        if (isTrue) {
            // System.out.println("*--------found the Node------*");
            return isTrue;
        }

        return isTrue;

    }

    public void RangeSearch(int x, int y) {
        Node current = root;
        if (root == null) {
            return;
        }
        while (current != null) {
            if (x < current.data && y > current.data) {
                System.out.println("-the value between " + x + " and " + y + " is --->  " + current.data);
            }
            if (x < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

    }

    public int RangeSum(int x, int y, Node root) {

        if (root == null) {
            return sum;
        }

        if (x < root.data && y > root.data) {
            sum = root.data + sum;
            RangeSum(x, y, root.left);
            RangeSum(x, y, root.right);
        } else if (x < root.data) {
            RangeSum(x, y, root.left);
        } else {
            RangeSum(x, y, root.right);

        }
        return sum;
    }

    public int maxValue(Node root) {
        if (root == null) {
            return 0;
        }
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.right;
        }
        return last.data;
    }

    public int minValue(Node root) {
        if (root == null) {
            return 0;
        }
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.left;
        }
        return last.data;

    }

    public int SumofNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int lsum = SumofNodes(root.left);
        int rsum = SumofNodes(root.right);

        return root.data + lsum + rsum;
    }

    public int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int lheight = heightOfTree(root.left);
        int rheight = heightOfTree(root.right);

        if (lheight == rheight) {
            return lheight + 1;
        }

        if (lheight > rheight) {
            return lheight + 1;
        } else {
            return rheight + 1;
        }

    }

    public int NoOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        //int leftsum = SumofNodes(root.left);
        //int rightsum = SumofNodes(root.right);

        return NoOfNodes(root.left) + NoOfNodes(root.right) + 1;
    }

    public Node deltNode(int data) {
        Node item = null;
        Node parent = null;
        if (root == null) {
            return null;
        }
        Node current = root;
        while (current.data != data) {
            parent = current;
            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }

        }
        // condition for delting the leaf node
        if (current.left == null && current.right == null) {
            if (current == null) {
                root = null;
            } else if (current.left == null) {
                item = current;
                parent.left = null;
            } else if (current.right == null) {
                item = current;
                parent.right = null;
            }
        } // if no left child , replace with right subtree..
        else if (current.left == null && current.right != null) {
            if (current == null) {
                item = current;
                root = current.right;
            } else if (current.left == null) {
                item = current;
                parent.left = current.right;

            } else {
                item = current;
                parent.right = current.right;
            }

        } // if no right child , replace with left child
        else if (current.right == null && current.left != null) {
            if (current == root) {
                item = current;
                root = current.left;
            } else if (current.right == null) {
                item = current;
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } // delting a node with two children so, replace with inorder
        else {
            Node successor = getSuccesor(current);
            if (current == root) {
                root = successor;
            } else if (current.left == null) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;

        }

        return item;

    }

    public Node getSuccesor(Node current) {
        Node SP = current;
        Node S = current;
        Node curr = current.right;
        while (curr != null) {
            SP = S;
            S = curr;
            curr = curr.left;
        }
        if (S != current.right) {
            SP.left = current.right;
            S.right = S.right;
        }
        return S;
    }
    
    
    // finding the left most descendent of the entered node.............
    
    public Node Next(Node n){
        if(n.right != null)
            return leftDescendent(n);
        else
            return RightAncestor(n);
    }
    
    public Node leftDescendent(Node n){
        if(n.left == null)
            return n;
        else
            return leftDescendent(n.left);
            
    }
    
    public Node RightAncestor(Node n ){
        if (n.data < n.root.data)
            return n.root;
        else
            return RightAncestor(n.right );
    }


    public static void main(String[] args) {
        System.out.println("Hello World!");
        BinaryTree tree = new BinaryTree();

        tree.insertData(50);
        tree.insertData(25);
        tree.insertData(75);
        tree.insertData(12);
        tree.insertData(37);
        tree.insertData(43);
        tree.insertData(30);
        tree.insertData(28);
        tree.insertData(86);
        tree.insertData(93);

        System.out.println("------->" + tree.root.left.right.right.data);
        System.out.println("------->" + tree.root.left.right.data);
        System.out.println("------->" + tree.root.right.right.right.data);
        System.out.println("- number of node binary search tree ------->" + tree.NoOfNodes(tree.root));
        System.out.println("- height of binary search tree ------->" + tree.heightOfTree(tree.root));
        System.out.println("- sum of nodes in binary search tree ------->" + tree.SumofNodes(tree.root));
        System.out.println("- maxium vlue in binary search tree ------->" + tree.maxValue(tree.root));
        System.out.println("- minimum value in binary search tree ------->" + tree.minValue(tree.root));
        System.out.println("--node exist or not --->true for yes--->false for no..Answer is " + tree.searchData(tree.root, 100));
        tree.RangeSearch(25, 75);
        System.out.println("-The sum between the range is ----->" + tree.RangeSum(12, 43, tree.root));

        /*  Node node = tree.deltNode(12);
        System.out.println("Node deleted----->" + node.data);*/
        Node node1 = tree.deltNode(86);
        System.out.println("Node deleted----->" + node1.data);
        System.out.println(tree.root.right.right.right.data);

        Node node2 = tree.deltNode(30);
        System.out.println("Node deleted----->" + node2.data);
        System.out.println(tree.root.left.right.left.data);
        
        /*Node node3 = tree.deltNode(37);
        System.out.println("Node deleted----->" + node3.data);
        System.out.println(tree.root.left.right.data);*/

    }
}
