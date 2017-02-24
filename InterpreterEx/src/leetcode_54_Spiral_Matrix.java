import java.util.LinkedList;
import java.util.List;

public class leetcode_54_Spiral_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] matrix = {{ 1, 2, 3 }, { 4, 5, 6 },{ 7, 8, 9 } };
		//int[][] matrix = {{ 1, 2, 3, 4 }, { 5, 6, 7, 8 },{ 9, 10, 11, 12 } };
		//int[][] matrix = {{ 1,2,3,4,5,6,7,8,9,10 }};
		//int[][] matrix = {{ 1 }, { 1 }, { 1 }, { 1 }, { 1 }, { 1 }, { 1 }, { 1 }, { 1 }, { 1 } };
		int[][] matrix = {{ 1, 2, 3 }, { 4, 5, 6 },{ 7, 8, 9 } ,{ 10, 11, 12 } };
		spiralOrder(matrix);
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		
		List<Integer> result = new LinkedList<Integer>();
		int countLimit = matrix.length;
		
		if(matrix.length == 0)
			return result;
		
		int rowlastIdx = matrix.length - 1;
		int collastIdx = matrix[0].length - 1;
		//countLimit = Math.min(rowlastIdx, collastIdx);
		if(countLimit%2 == 0)
			countLimit = countLimit/2;
		else 
			countLimit = countLimit/2 + 1;
		int x = 0;
		for(int count = 0 ; count < countLimit; count++) {
			for(x = count ; x <= collastIdx - (count); x++){
				if(result.size() < (rowlastIdx+1) * (collastIdx+1))
					result.add(matrix[count][x]);
			}
			for(x = count + 1 ; x <= rowlastIdx - (count) ; x++){
				if(x <= rowlastIdx && (collastIdx - count > -1) && result.size() < (rowlastIdx+1) * (collastIdx+1))
					result.add(matrix[x][collastIdx - count]);
			}
			for(x = collastIdx - (count + 1); x >= count + 1 ; x--){
				if(rowlastIdx != 0 && result.size() < (rowlastIdx+1) * (collastIdx+1))
					result.add(matrix[rowlastIdx - count][x]);
			}
			for(x = rowlastIdx - (count); x >= count + 1 ; x--){
				if(collastIdx != 0 && result.size() < (rowlastIdx+1) * (collastIdx+1))
					result.add(matrix[x][count]);
			}
				
		}
		
//		if(collastIdx == rowlastIdx){
//			result.add(matrix[collastIdx/2][rowlastIdx/2]);
//		}
		
        return result;
    }
}
