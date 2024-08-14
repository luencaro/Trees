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
    Node Root;
    
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
    
    public void AddRecursively(Node node, Node newnode){
        
        if (node.data > newnode.data) {
            if (node.Left == null){
                node.Left = newnode;
            } else {
                AddRecursively(node.Left, newnode);
            }
        } else {
            if (node.Right == null){
                node.Right = newnode;
            } else {
                AddRecursively(node.Right, newnode);
            }
        }
    }
    
    public void imprimir (Node n1 ,int lvl ){
        if ( n1 != null ){
            imprimir ( n1.Right , lvl+1 );
            for (int i = 0; i < lvl; i++){
                System.out.print ("      ");
            }
            System.out.println(n1.data );
            imprimir (n1.Left , lvl+1 );
           
        }
    }
    
    public void PreOrder(Node node) {
        
        if (node == null) {
            return;
        }
        System.out.print(node.data + " -> ");
        PreOrder(node.Left);
        PreOrder(node.Right);
    
    }
    
    public void InOrder(Node node) {
        
        if (node == null) {
            return;
        }
        InOrder(node.Left);
        System.out.print(node.data + " -> ");
        InOrder(node.Right);
    
    }
    
    public void PosOrder(Node node) {
        
        if (node == null) {
            return;
        }
        PosOrder(node.Left);
        PosOrder(node.Right);
        System.out.print(node.data + " -> ");
    
    }
}
