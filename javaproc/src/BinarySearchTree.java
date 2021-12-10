public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{

    //Node class
    private BinaryNode<AnyType> root;
    private static class BinaryNode<AnyType>
    {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        BinaryNode(AnyType node)
        { this(node, null, null); }

        BinaryNode(AnyType node, BinaryNode<AnyType> leftChild, BinaryNode<AnyType> rightChild)
        {
            element  = node;
            left     = leftChild;
            right    = rightChild;
        }
    }

    public BinarySearchTree()
    {
        root = null;
    }

    //public usables
    public void insert(AnyType ob)
    {
        root = insert(ob, root);
    }

    public void remove(AnyType ob)
    {
        root = remove(ob, root);
    }

    public boolean contains(AnyType ob)
    {
        return contains(ob, root);
    }

    public void makeEmpty()
    {
        root = null;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public AnyType findMin()
    {
        BinaryNode<AnyType> minNode = findMin(root);
        return minNode.element;
    }

    public void printTree()
    {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    //private stuff, just implementations of above
    private BinaryNode<AnyType> insert(AnyType ob, BinaryNode<AnyType> v)
    {
        if (v == null) return new BinaryNode<>(ob, null, null);

        int compare = ob.compareTo(v.element);

        if (compare < 0)
            v.left = insert(ob, v.left);
        else if (compare > 0)
            v.right = insert(ob, v.right);
        return v;
    }

    private BinaryNode<AnyType> remove(AnyType ob, BinaryNode<AnyType> v)
    {
        if (v == null)
            return v;

        int compare = ob.compareTo(v.element);

        if (compare < 0)
            v.left = remove(ob, v.left);
        else if (compare > 0)
            v.right = remove(ob, v.right);
        else if (v.left != null && v.right != null)
        {
            v.element = findMin(v.right).element;
            v.right = remove(v.element, v.right);
        }
        else
            v = (v.left != null) ? v.left : v.right;
        return v;
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> v)
    {
        if (v == null)
            return null;
        else if (v.left == null)
            return v;
        return findMin(v.left);
    }

    private boolean contains(AnyType ob, BinaryNode<AnyType> v)
    {
        if (v == null)
            return false;

        int compare = ob.compareTo(v.element);

        if (compare < 0)
            return contains(ob, v.left);
        else if (compare > 0)
            return contains(ob, v.right);
        else
            return true;    // Match
    }

    private void printTree(BinaryNode<AnyType> v)
    {
        if (v != null)
        {
            if  ((v.left == null && v.right != null) || (v.right == null && v.left != null))
                System.out.println(v.element);
            printTree(v.left);

            printTree(v.right);

        }
    }

}

