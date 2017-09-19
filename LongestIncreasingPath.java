
public class LongestIncreasingPath 
{
	/* Need to update the code */
	public int longestIncreasingPath(int[][] matrix) 
	{
		int maxCount = Integer.MIN_VALUE;
		
		for(int row = 0; row < matrix.length; ++row)
		{
			for(int col = 0; col < matrix[0].length; ++col)
			{
				if(isMinElem(matrix, row, col))
				{
					maxCount = Math.max(getPathLen(matrix, row, col, 0, false), maxCount);
				}
			}
		}
		
		return maxCount;
    }

	

	private int getPathLen(int[][] matrix, int row, int col, int prevValue, boolean isPrevValueValid) 
	{
		if(!isValidIdx(matrix, row, col)) 					  return 0;
		if(isPrevValueValid && matrix[row][col] <= prevValue) return 0;
		
		int curValue = matrix[row][col];
		
		matrix[row][col] = Integer.MIN_VALUE;
		
		int leftCount = getPathLen(matrix, row, col - 1, curValue, true);
		int rightCOunt = getPathLen(matrix, row, col + 1, curValue, true);
		int topCount = getPathLen(matrix, row - 1, col, curValue, true);
		int bottomCount = getPathLen(matrix, row + 1, col, curValue, true);
		
		int curPathCount = 1 + Math.max(leftCount, Math.max(rightCOunt, Math.max(topCount, bottomCount)));
		
		matrix[row][col] = curValue;
		
		return 1 + curPathCount;
	}

	private boolean isMinElem(int[][] matrix, int row, int col) 
	{
		return (isValidIdx(matrix, row - 1, col)     && matrix[row - 1][col]     > matrix[row][col]) ||
			   (isValidIdx(matrix, row + 1, col)     && matrix[row + 1][col]     > matrix[row][col]) ||
			   (isValidIdx(matrix, row,     col - 1) && matrix[row]    [col - 1] > matrix[row][col]) ||
			   (isValidIdx(matrix, row,     col + 1) && matrix[row]    [col + 1] > matrix[row][col]) ;
	}

	private boolean isValidIdx(int[][] matrix, int row, int col) 
	{
		return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length; 
	}

	public static void main(String[] args)
	{
		int[][] matrix = {{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}};
		
		System.out.println(new LongestIncreasingPath().longestIncreasingPath(matrix));
	}
}
