package leetcode;
import java.util.*;
public class spiral_matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int width = matrix.length;
        if(width==0||matrix[0].length==0) return res;
        int length = matrix[0].length;
        int rowS = 0;
        int rowE = width-1;
        int colS = 0;
        int colE = length-1;
        while(rowS<=rowE&&colS<=colE){
            for(int i=colS;rowS<=rowE&&i<=colE;i++){
                res.add(matrix[rowS][i]);
            }
            rowS++;
            for(int i=rowS;colS<=colE&&i<=rowE;i++){
                res.add(matrix[i][colE]);
            }
            colE--;
            for(int i=colE;rowS<=rowE&&i>=colS;i--){
                res.add(matrix[rowE][i]);
            }
            rowE--;
            for(int i=rowE;colS<=colE&&i>=rowS;i--){
                res.add(matrix[i][colS]);
            }
            colS++;
            // System.out.println(rowS);
            // System.out.println(rowE);
            // System.out.println(colS);
            // System.out.println(colE);
        }
        return res;
    }

}
