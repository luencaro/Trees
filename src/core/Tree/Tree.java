/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.Tree;

/**
 *
 * @author lcabarcase
 */
public class Tree {

    public Node Root;

    public Tree() {
        this.Root = null;
    }

    public void Add(int data) {

        Node node = new Node(data);
        if (Root == null) {
            Root = node;
        } else {
            AddRecursively(Root, node);
        }
    }

    public void AddRecursively(Node node, Node newnode) {

        if (node.data > newnode.data) {
            if (node.left == null) {
                node.left = newnode;
            } else {
                AddRecursively(node.left, newnode);
            }
        } else {
            if (node.right == null) {
                node.right = newnode;
            } else {
                AddRecursively(node.right, newnode);
            }
        }
    }

    public void imprimir(Node n1, int lvl) {
        if (n1 != null) {
            imprimir(n1.right, lvl + 1);
            for (int i = 0; i < lvl; i++) {
                System.out.print("      ");
            }
            System.out.println(n1.data);
            imprimir(n1.left, lvl + 1);

        }
    }

    public void PreOrder(Node node) {

        if (node == null) {
            return;
        }
        System.out.print(node.data + " -> ");
        PreOrder(node.left);
        PreOrder(node.right);

    }

    public void InOrder(Node node) {

        if (node == null) {
            return;
        }
        InOrder(node.left);
        System.out.print(node.data + " -> ");
        InOrder(node.right);

    }

    public void PosOrder(Node node) {

        if (node == null) {
            return;
        }
        PosOrder(node.left);
        PosOrder(node.right);
        System.out.print(node.data + " -> ");

    }

    public int sum(Node node) {
        if (node == null) {
            return 0;
        }

        return node.data + sum(node.left) + sum(node.right);
    }

    public boolean search(int value, Node node) {
        if (node == null) {
            return false;
        }

        if (value == node.data) {
            return true;
        } else {
            if (value < node.data) {
                return search(value, node.left);
            } else {
                return search(value, node.right);
            }
        }
    }
    
    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        
        return Math.max(height(node.left), height(node.right));
    }
    
    public boolean isCompleted (Node node, int lvl, int n) {
        if (node == null) {
            return false;
        }
        
        if(lvl >= n) {
            return false;
        }
        
        return isCompleted(node.left, 2*lvl + 1, n) && isCompleted(node.right , 2*lvl+1, n);
    } 
}
