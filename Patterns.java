public class Patterns {

    public void piramid(int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int s=0;s<n-i;s++)
            {
                System.out.print(" ");
            }
            for(int j=0;j<2*i-1;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Patterns p=new Patterns();
        p.piramid(5);
    }
}
