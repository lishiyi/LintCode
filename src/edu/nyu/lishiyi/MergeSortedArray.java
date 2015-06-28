/*
* Merge Sorted Array

Given two sorted integer arrays A and B, merge B into A as one sorted array.

Example
A = [1, 2, 3, empty, empty], B = [4, 5]

After merge, A will be filled as [1, 2, 3, 4, 5]

Note
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional 
elements from B. The number of elements initialized in A and B are m and n respectively.
*/

class mergeSortedArray {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(i >= 0 && j >= 0){

        	if(A[i] > B[j]){

        		A[k] = A[i];
        		i -= 1;
        		k -= 1;
        	}
        	else{

        		A[k] = B[j];
        		j -= 1;
        		k -= 1;
        	}
        }

        while(i >= 0){

        	A[k] = A[i];
    		i -= 1;
    		k -= 1; 
        }
        while(j >= 0){

    		A[k] = B[j];
    		j -= 1;
    		k -= 1;
        }
    }
}