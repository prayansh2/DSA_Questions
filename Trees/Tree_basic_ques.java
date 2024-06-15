package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_basic_ques {

    int height=0;

    public void levelOrder(Tree_Traversals.Node root)
    {
//        System.out.println("okey");
        Queue<Tree_Traversals.Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
            Tree_Traversals.Node curr=q.remove();
            if(curr==null)
            {
                System.out.println();
                height++;
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
            }
            else{
                System.out.print(curr.val+"  ");
                if(curr.left!=null)
                q.add(curr.left);
                if(curr.right!=null)
                q.add(curr.right);
            }
        }
    }


    public  int heightOfTree(Tree_Traversals.Node root)
    {
        this.levelOrder(root);
        int h=height;
        height=0;
        return h;
    }

    public int nodeCount(Tree_Traversals.Node root)
    {
        if(root==null)
            return 0;

        int lcount=nodeCount(root.left);
        int rcount=nodeCount(root.right);
        return lcount+rcount+1;
    }


    public int sumOfNodes(Tree_Traversals.Node root)
    {
        if(root==null)
            return 0;

        int lsum=sumOfNodes(root.left);
        int rsum=sumOfNodes(root.right);
        return lsum+rsum+root.val;
    }

    public int diameter1(Tree_Traversals.Node root)
    {
        if(root==null)
            return 0;

        int d1=diameter1(root.left);
        int d2=diameter1(root.right);
        int d3=heightOfTree2(root.left)+heightOfTree2(root.right)+1;
        return Integer.max(d3,Integer.max(d1,d2));
    }


    public int heightOfTree2(Tree_Traversals.Node root)
    {
        if(root==null)
            return 0;

        int lh=heightOfTree2(root.left);
        int rh=heightOfTree2(root.right);
        return Integer.max(lh,rh)+1;
    }




}
