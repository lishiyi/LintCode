N-Queens

21% Accepted
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that 
no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens'           '
placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Have you met this question in a real interview? Yes
Example
There exist two distinct solutions to the 4-queens puzzle:

[

    [".Q..", // Solution 1

     "...Q",

     "Q...",

     "..Q."],

    ["..Q.", // Solution 2

     "Q...",

     "...Q",

     ".Q.."]

]

Challenge
Can you do it without recursion?

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        //1. Create a arraylist for all the cases.
    	ArrayList<ArrayList<String>> result = new ArrayList();
    	//2. Create a arraylist for one case.
    	ArrayList<String> list = new ArrayList();
    	dfs(result, list, n);
    	return result;

    }

    private void dfs(ArrayList<ArrayList<String>> result, ArrayList<String> list, int n){
    	//3. If a case if finished, add it to the result.
    	if(list.size() == n){
    		result.add(new ArrayList(list));
    		return;
    	}
    	//4. Iterate for each colum(The children for the node. For example, 
    	//   n=4, at the first time, we need 4 chidren [Q...][.Q..][..Q.][...Q])
    	for(int col = 1; col <= n; col++){
    		//5. The New Queen is safe or not.
    		if(isSafe(list, col, n)){
    			//6. If it is safe, add the new Queen to this case.
    			list.add(drawLine(col, n));
    			//7. Go on for next row. We do NOT need to +1 because the size of
    			// list has already +1
    			dfs(result, list, n);
    			//8. Backtrack.
    			list.remove(list.size() - 1);
    		}

    	}
    }

    private boolean isSafe(ArrayList<String> list,int col, int n){

    	//9. At the first line, any Queen will be safe
    	if(list.size() == 0){

    		return true;
    	}
    	//10. The total row we already have in the list
    	int row = list.size();
    	//11. The current row is the row we have + 1
    	int thisRow = row + 1;
    	//12. Iterate for each block we already have in the list
    	for(int i = 0; i < row; i++){

    		for(int j = 0; j < n; j++){
    			//13. It the block has a QUEEN
    			if(list.get(i).charAt(j) == 'Q'){
    				//14. If in the same colum, return false
    				//    We do not need to check row, because we use this for row + 1
    				if(j == col - 1){

    					return false;
    				}
    				//15. If the 2 Queens in the same 1-9(4-8, 2-6) diagonal, return false 
    				if(i + j == ( thisRow - 1) + (col - 1) ){

    					return false;
    				}
    				//16. If the 2 Queens in the same 7-3(4-2, 8-6) diagonal, return false
    				if(i - j == thisRow - col){

    					return false;
    				}
    				//17. In this raw, the Queen occurs, we do not need the remaining.
    				//(If the case is true) so break
    				break; 
    			}

    		}
    	}

    	return true;
    }
    //18. The function to draw a line.
    private String drawLine(int col, int n){

    	String line = ""; 
    	for(int i = 0; i < n; i++){

    		if(i == col - 1){

    			line += "Q";
    		}
    		else{

    			line += ".";
    		}
    	}

    	return line;
    }

};