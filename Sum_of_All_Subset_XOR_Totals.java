import java.util.ArrayList;

public class Sum_of_All_Subset_XOR_Totals {



    public ArrayList<ArrayList<Integer>> l=new ArrayList<>();

    //backtracking function of finding all subsets and stored in my clss variable 'l'
    public void subset(int a[], ArrayList<Integer> list, ArrayList<ArrayList<Integer>> l, int index)
    {
        l.add(new ArrayList<>(list));
        for(int i=index;i<a.length;i++)
        {
            list.add(a[i]);
            subset(a,list,l,i+1);
            list.remove(list.size()-1);
        }
    }
    public int subsetXORSum(int[] nums) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        subset(nums,list,l,0);
        //initalize a sum with 0
        int sum=0;
        //traverse all subsets one by one
        for(ArrayList<Integer> lis:l)
        {
            // 'ls' from each level sum
            int ls=0;
            if(lis.size()!=0)
            {
                for(int i:lis)
                {
                    //performing XOR
                    ls=ls^i;
                }
            }
            // adding each level sum in whole sum
            sum=sum+ls;
        }
        return sum;
    }


}
