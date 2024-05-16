public class Reshape_the_Matrix {


    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        int row = mat.length;
        int col = mat[0].length;

        if((row * col) != (r * c)) return mat;

        int[][] arr = new int[r][c];
        int rowNum = 0;
        int colNum = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[rowNum][colNum] = mat[i][j];
                colNum++;
                if(colNum == c){
                    colNum = 0;
                    rowNum++;
                }
            }
        }
        return arr;

    }

    public static void main(String[] args) {
        int a[][]={{1,2},{3,4}};
        int b[][]=matrixReshape(a,4,1);
        for(int i=0;i<b.length;i++)
        {
            for(int j=0;j<b[0].length;j++)
            {
                System.out.print(b[i][j]+"  ");
            }
            System.out.println();
        }
    }

}
