
public class BST<T> {
    private BSTNode root;
    
    public BST(){
        root = null;
    }
    class BSTNode{
	Comparable data;
	BSTNode left;
	BSTNode right;
        BSTNode(Comparable data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    public void print(){
        print(root);
    }
    private void print(BSTNode node){
	if(node != null){
            print(node.left);
            System.out.println(node.data);
            print(node.right);
	}	
    }
    public void delete(Comparable value){
        root = delete(root, value);
    }
    private BSTNode delete(BSTNode node, Comparable value){
	if(node==null){
            return null;
	}
	if(node.data.compareTo(value)==0){
            if(node.left==null){
                return node.right;
            }
            else if(node.right==null){
                return node.left;
            }
            else {
                if(node.right.left==null){
                    node.data = node.right.data;
                    node.right = node.right.right;
                    return node;
                }
                else{
                    node.data = removeSmallest(node.right);
                    return node;
                }
            }
	}
	else if(node.data.compareTo(value)<0){
            node.right = delete(node.left, value);
	}
	else{
            delete(node.left,value);
	}
        return node;
    }

    Comparable removeSmallest(BSTNode node){
        if(node.left.left == null){
            Comparable smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        }
        else{
            return removeSmallest(node.left);
        }
    }
    public boolean find(Comparable value){
	return find(root, value);
    }
    private boolean find(BSTNode node, Comparable value){
        if(node==null){
            return false;
        }
        if(node.data.compareTo(value)==0){
            return true;
        }
        else if(node.data.compareTo(value)>0){
            return find(node.left,value);
        }
        else{
            return find(node.right,value);
        }
    }
    public void insert(Comparable value){
	root = insert(root, value);
    }
    private BSTNode insert(BSTNode node, Comparable value){
        if(node==null){
            BSTNode n = new BSTNode(value);
            return n;
        }
        else if(node.data.compareTo(value)>0){
            node.left = insert(node.left, value);
        }
        else{
            node.right = insert(node.right, value);
        }
        return node;
    }    
}
