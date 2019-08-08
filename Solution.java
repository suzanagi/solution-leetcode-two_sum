/******************************************************************************
 *  Compilation:  javac Solution.java
 *  Execution:    java Solution
 *
 *  Prints indices of the two numbers such that they add up to a specific
 *  target.
 *
 *  % java Solution
 *  Your Input: 
 *  [2, 7, 11, 15, ]
 *  9
 *  Output: 
 *  [0, 1, ]
 *
 *  This program is the solution for a problem in the LeetCode.
 *  Please check out the original in https://leetcode.com/problems/two-sum/
 *
 *****************************************************************************/

import java.util.HashMap;
import java.util.Map;

class Solution{
    public static void main(String[] args){
	// Prepare an array of numbers and target number given to the program
	int[] given_nums = {2, 7, 11, 15};
	int target = 9;
	// Output the input and the answer
	out(given_nums, target, twoSum(given_nums, target));
    }

    public static void out(int[] nums, int target, int[] output){
	System.out.print("Your Input: \n[");
	for(int i = 0; i < nums.length; i++)
	    System.out.print(nums[i] + ", ");
	System.out.println("]");
	System.out.println(target);
	System.out.print("Output: \n[");
	for(int i = 0; i < output.length; i++)
	    System.out.print(output[i] + ", ");
	System.out.println("]");
    }

    public static int[] twoSum(int[] nums, int target) {
        /* Add the numbers to the hash table. */
        // Prepare hash map variable
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Put the elements to the map variable
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        /* Return the answer if there's any other number corresponds 
	 * to the element i which satisfies the target number. 
	*/
        for(int i = 0; i < nums.length; i++){
            // Decide the required number corresponds to the element i
            int req = target - nums[i];
            // Return the answer if the hash map contains the required number
            if(map.containsKey(req)) {
		// The element must not be the same element to the nums[i]
		if(map.get(req) != i) {
                    int[] answer = new int[2];
                    answer[0] = i;
                    answer[1] = map.get(req);
                    return answer;
                }
            }                               
        }
        throw new IllegalArgumentException("No pairs match");
    }
}