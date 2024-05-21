import java.util.ArrayList;
import java.util.List;

public class subset {

   public List<List<Integer>>  list=new ArrayList<>();

   //finding all subset through backtracking and recusion
    public void subsets(int a[],ArrayList<Integer> l, List<List<Integer>> list,int index)
    {
        list.add(new ArrayList<>(l));
        for(int j=index;j<a.length;j++)
        {
          l.add(a[j]);
          subsets(a,l,list,j+1);
          l.remove(l.size()-1);
        }
    }

//    healping function
    public List<List<Integer>> answer()
    {
        //value array
        int a[]={1,2,3};
        ArrayList<Integer> l=new ArrayList<Integer>();
        subsets(a,l,list,0);
        return this.list;
    }
    public static void main(String[] args) {

        subset s=new subset();
        List<List<Integer>> li=s.answer();
        System.out.println(li);
    }
}
