Single Number II

39% Accepted
Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.

Have you met this question in a real interview? Yes
Example
Given [1,1,2,3,3,3,2,2,4,1] return 4

Challenge
One-pass, constant extra space.

public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        // write your code here
        /*
        	If one number occurs 3 times, it should be 0, so we use 0-1-2-0 for the XOR

				if one 0, two 0, num 1 => set one 1, two 0,  
				if one 1, two 0, num 1 => set one 0, two 1,
        		if one 0, two 1, num 1 => set one 0, two 0.

        		list a true table:

        		num one two  None Ntwo
        		 0   0   0    0    0
        		 0   1   0    1    0    *
        		 0   0   1    0    1        *
        		 0   1   1    -    -
        		 1   0   0    1    0    *
        		 1   1   0    0    1        *
        		 1   0   1    0    0
        		 1   1   1    -    -

					  _ _    __	    _     _ _             _
        		 N1 = NOT + NOT  = (NO + NO)T   = N ^ O & T
			
			Because One updated, we use the new number.
				      _ __    ___    _     _ __           __
        		 N2 = NTN1 + NTN1 = (NT + NT)N1 = N ^ T & N1
        */
        int ones = 0, twos = 0;
        for(int num : A){
        	ones = (ones ^ num) & ~twos;
        	twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}