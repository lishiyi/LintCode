class MergeSortedArrayII {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        if(A == null || A.size() == 0){

        	return B;
        }
        else if(B == null || B.size() == 0){

        	return A;
        }

        int i = 0;
        int j = 0;
        ArrayList<Integer> C = new ArrayList<Integer> ();

        while(i < A.size() && j < B.size() ){

        	if(A.get(i) < B.get(j)){

        		C.add(A.get(i));
        		i += 1;
        	}
        	else{

        		C.add(B.get(j));
        		j += 1;
        	}
        }

        while(i < A.size()){

        	C.add(A.get(i));
        	i += 1;
        }

        while(j < B.size()){

        	C.add(B.get(j));
        	j += 1;
        }

        return C;
    }
}
