/**
* Find Peak Element
* There is an integer array which has the following features:
*
* The numbers in adjacent positions are different.
* A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
* We define a position P is a peek if:
* 
* A[P] > A[P-1] && A[P] > A[P+1]
* Find a peak element in this array. Return the index of the peak.
* Example
* Given [1, 2, 1, 3, 4, 5, 7, 6]
* Return index 1 (which is number 2) or 6 (which is number 7)
* 
* Note
* The array may contains multiple peeks, find any of them.
* 
* Challenge
* Time complexity O(logN)
*
*/
class FindPeakElement {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
    	if(A.length == 3){

    		return 1;
    	}

    	int start = 0;
    	int end = A.length - 1;
    	int mid;

    	while(start + 1 < end){

    		mid = start + (end - start) / 2;

    		if(isPeak(A, mid) == 7){

    			return mid;
    		}
    		else if(isPeak(A, mid) == 1){

    			start = mid;
    		}
    		else{

    			end = mid;
    		}
    	}

    	if(isPeak(A, start) == 7){
    		return start;
    	}
    	else if(isPeak(A, end) == 7){

    		return end;
    	}

    	return -1;

    }

    private int isPeak(int[] A, int pos){

    	//Is the peak
    	if(A[pos - 1] < A[pos] && A[pos] > A[pos + 1]){

    		return 7;
    	}
    	//Is valley
    	else if(A[pos - 1] > A[pos] && A[pos] < A[pos + 1]){

    		return 0;
    	}
    	//
    	else if(A[pos - 1] < A[pos] && A[pos] < A[pos + 1]){

    		return 1;
    	}
    	//
    	else if(A[pos - 1] > A[pos] && A[pos] > A[pos + 1]){

    		return -1;
    	}

    	return -1;

    }
}
