package Trees;

import java.util.*;

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


    public void inverted(Tree_Traversals.Node root)
    {
        if(root==null || root.left==null&&root.right==null)
            return;
            inverted(root.left);
            inverted(root.right);
            Tree_Traversals.Node t=root.left;
            root.left=root.right;
            root.right=t;
    }

    public int secMax(Tree_Traversals.Node root)
    {
        Queue<Integer> q=new PriorityQueue<>(2, Collections.reverseOrder());
        secMaxHealper(root,q);
        return q.peek();
    }

    public void secMaxHealper(Tree_Traversals.Node root,Queue<Integer> q)
    {
        if(root==null)
            return;
        if(q.size()==2)
        {
            if(q.peek()>root.val)
            {
                q.remove();
                q.add(root.val);
            }
        }
        else
        q.add(root.val);
        secMaxHealper(root.left,q);
        secMaxHealper(root.right,q);
    }


    public boolean symtric(Tree_Traversals.Node root)
    {
        System.out.println("pk");
        Queue<Tree_Traversals.Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        String s="";
        while(!q.isEmpty())
        {
            Tree_Traversals.Node curr=q.remove();
            if(curr==null)
            {

                StringBuilder bs=new StringBuilder(s);
                if(!s.equals(bs.reverse().toString()))
                    return false;

                s="";
                if(q.isEmpty())
                    break;
                else
                    q.add(null);

            }
            else{
                if(curr.left!=null) {
                    q.add(curr.left);
                    s=s+curr.left.val+"";
                }
                if(curr.right!=null) {
                    q.add(curr.right);
                    s=s+curr.right.val+"";
                }
            }
        }
        return true;
    }


    public boolean subTree(Tree_Traversals.Node root, Tree_Traversals.Node subroot)
    {
        if(root==null)
            return false;

       if(checkSubTree(root,subroot))
           return true;

            return subTree(root.left,subroot) || subTree(root.right,subroot);
    }

    public boolean checkSubTree(Tree_Traversals.Node root, Tree_Traversals.Node subroot)
    {
        if(subroot==null && root==null)
            return true;
        if(root==null||subroot==null)
            return false;

       if(root.val!=subroot.val)
           return false;

           return checkSubTree(root.left,subroot.left) && checkSubTree(root.right,subroot.right);
    }



}
