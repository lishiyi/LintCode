Single Number

57% Accepted
Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

Have you met this question in a real interview? Yes
Example
Given [1,2,2,1,3,4,3], return 4

Challenge
One-pass, constant extra space.

public class Solution {
	/**
	 *@param A : an integer array
	 *return : a integer 
	 */
	public int singleNumber(int[] A) {

		Set<Integer> hashSet = new HashSet<Integer>();

		for(int num : A){

			if(hashSet.contains(num)){

				hashSet.remove(num);
			}
			else{

				hashSet.add(num);
			}
		}

		for(int num: hashSet){

			return num;
		}

		return 0;
	}
}
