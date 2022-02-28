import java.util.*;
class Binarytre {
    //Preorder- visit root then all nodes on left and all nodes on right, used to creates copy of tree, count number of nodes, count leaf nodes, can be used to convert expression tree to prefix notation
    //Inorder- visit left side of root, visit root the visit right side of root. gives sorted output
    //Postorder-visit all on left, visit all on right, visit root, can be used to delete nodes
    public static void main(String[] args){
       Binarytre obj=new Binarytre();
       int n,num;
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter count of numb to be inputte: ");
       n=sc.nextInt();
       for(int i=0; i<n; i++){
           System.out.println("Enter number"+(i+1)+": ");
           num=sc.nextInt();
           obj.insertinto(num);
       }
       System.out.println("insert done");
       System.out.println("enter search: ");
       num=sc.nextInt();
       if(obj.search1(num)!=null){
           System.out.println("found");
       }
       else{
           System.out.println("not pre");
       }
       System.out.println("Inorder");
       obj.inorder1();
       System.out.println();
       obj.preorder1();
       System.out.println();
       obj.delete1(1);
       obj.postorder1();
       obj.delete1(1);
       sc.close();
    }

    class Node{ //defining nodes with left right and data
        int data;
        Node left, right;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }

    Node root;
    Binarytre(){
        root=null;
    }

    Node insert(Node root, int insert1){
        if(root==null){
            root=new Node(insert1);
            return root;
        }
        if(root.data>insert1){
            root.left=insert(root.left, insert1); //recursive until first if case is executed
        }
        else if(root.data<insert1){
            root.right=insert(root.right, insert1);
        }
        return root;
    }

    Node search(Node root, int search2){
        if(root==null || root.data==search2){
            return root;
        }
        if(root.data>search2){
            return search(root.left, search2); //recursive until first id case executed, similar for below
        }       
        //else
        return search(root.right, search2);
    }

    void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left); //use inorder(root.left) if postorder doesnt work similarlt for below line and preorder funct
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public Node delete(Node node, int val) {
        if(node == null) {
          return node;
        }
        
        if(val < node.data) {
          node.left = delete(node.left, val);
        } else if(val > node.data) {
          node.right = delete(node.right, val);
        } else {
          if(node.left == null || node.right == null) {
            Node temp = node.left != null ? node.left : node.right;
    
            if(temp == null) {
              return null;
            } else {
              return temp;
            }
          } else {
            Node successor = getSuccessor(node);
            node.data = successor.data;
            
            node.right = delete(node.right, successor.data);
            return node;
          }
        }
        
        return node;
      }
      
      public Node getSuccessor(Node node) {
        if(node == null) {
          return null;
        }
        
        Node temp = node.right;
        
        while(temp.left != null) {
          temp = temp.left;
        }
        
        return temp;
      }

    void insertinto(int datains){
        root= insert(root, datains);
    }

    Node search1(int datase){
        return search(root, datase);
    }

    void inorder1(){
        inorder(root);
    }

    void preorder1(){
        preorder(root);
    }

    void postorder1(){
        postorder(root);
    }

    void delete1(int n){
        root=delete(root, n);
    }
}