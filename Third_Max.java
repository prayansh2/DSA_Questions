import java.util.TreeSet;

public class Third_Max {
    public int thirdMax(int[] a) {
        //for sorted order i take a TreeSet
        TreeSet<Integer> t=new TreeSet<>();
        for(int i:a)
            t.add(i);
//        if size is less then three
        if(t.size()<3)
        {
            return t.pollLast();
        }
        else{
            int ans=0;
            int i=1;
            //iterate while the size of set is 3 only
            while(i!=4)
            {
                ans=t.pollLast();
                i++;
            }
            return ans;
        }
    }
}
