public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int n=image.length;
        for(int i=0;i<n;i++)
        {
            int m=n/2;
            int s=0;
            while(s<m)
            {
                if(image[i][s]==image[i][n-1-s])
                {
                    image[i][s]=(image[i][s]==0)?1:0;
                    image[i][n-1-s]=(image[i][n-1-s]==0)?1:0;
                }
                s++;
            }
            if(n%2!=0)
                image[i][m]=(image[i][m]==0)?1:0;
        }
        return image;
    }
    
}
