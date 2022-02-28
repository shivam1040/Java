class Avl {
    //self balancing, information either in 0,1 or-1. This information is called balance factor. calculated by height of right subtree-height of left subtree, for height edge lines are counted    
    //avl converts list looking bst to binary tree
    //for every node to be balanced, either needs to be 1,-1,0
    //L means clockwise, R means anti clockwise rotations
    //LL rotation done when insertion is on left of left, similarly for RR
    //for LR, rotatation, left wrt first imbalance node, the 
    //for RL rotation, right rotate wrt to child of first imbalance node in th path of inserted node and then left rotate wrt to first imbalance(previous one) node
    //to check if RL is required, check for insertion ways from first imbalance node, in RL, first movement should be on right side then on left side
    
    public static void main(String[] args) {
        Avl obj=new Avl();
        obj.insertinto(33);
        obj.insertinto(99);
        obj.insertinto(11);
        obj.insertinto(11);
        obj.insertinto(55);
        obj.insertinto(2);
        obj.inorder1();
    }
    
    class Node{
        Node left, right;
        int data, height;

        Node(int value){
            data=value;
            height=1;
            this.left=this.right=null;
        }
    }
    Node root;
    Node insert(Node root, int value){
        if(root==null){
            return new Node(value);
        }
        else if(value<root.data){
            root.left=insert(root.left, value);
        }
        else if(value>root.data){
            root.right=insert(root.right, value);
        }
        root.height=max(height(root.left), height(root.right))+1;       
        int fac=balancefac(root);
        if(fac>1){
            if(value<root.left.data){ //RR
                return rightr(root);
            } //RL= LL+RR
            else if(value>root.left.data){
                root.left=leftr(root.left);
                return rightr(root);
            }
        }
        if(fac<-1){ //LL
            if(value>root.right.data){
                return leftr(root);
            }
            else if(value<root.right.data){ //LR=RR+LL
                root.right=rightr(root.right);
                return leftr(root);
                }
            }
            return root;
        }
    

    int height(Node h){
        if(h==null){
            return 0;
        }
        return h.height;
    }

    int balancefac(Node n){
        if(n==null){
            return 0;
        }
        else
        return height(n.left)-height(n.right);
    }
    
    int max(int a, int b){
        if(a>b){
            return a;
        }
        return b;
    }    

    Node leftr(Node a){

        Node b=a.right;
        Node c=b.left;
        b.left=a;
        a.right=c;
        a.height=max(height(a.right), height(a.left))+1;
        b.height=max(height(b.right), height(b.left))+1;
        return b;
    }

    Node rightr(Node a){
        Node b=a.left;
        Node c=b.right;
        b.right=a;
        a.left=c;
        a.height=max(height(a.left), height(a.right))+1;
        b.height=max(height(b.left), height(b.right))+1;
        return b;
    }

    void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    void insertinto(int datains){
        root= insert(root, datains);
    }

    void inorder1(){ //wrapper classes to make it easy for user data entry
        inorder(root);
    }

}

