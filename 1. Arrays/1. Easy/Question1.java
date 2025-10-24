// ------------------------------------------------------------
// 🧮 Question 1: Find Largest Element in Array
// ------------------------------------------------------------
// 🧩 Find and return the maximum value in an array
// 🔑 Linear Scan - iterate once, track maximum seen so far
// 💡 Compare each element with current max, update if larger
//
// Pattern: Single Pass Array Traversal
// Level: 🟢 Easy
// Tags: #Arrays #LinearSearch #MaxFinding
// ------------------------------------------------------------

public class Question1 {

  // WHY: Find maximum value by scanning entire array
  // WHAT: arr = input array, n = number of elements
  // HOW: Track max value, update whenever larger element found
  public static int largest(int[] arr, int n) {

    // WHY: Initialize max to smallest possible value
    // WHAT: Integer.MIN_VALUE = -2,147,483,648 (guaranteed smaller than any array
    // element)
    // HOW: Ensures first array element will become initial max
    int max = Integer.MIN_VALUE;

    // Alternative initialization (if array guaranteed non-empty):
    // int max = arr[0]; // Start with first element as max

    // WHY: Check every element to find maximum
    // WHAT: Iterate through entire array from index 0 to n-1
    // HOW: Compare each element with current max, update if larger
    for (int i = 0; i < n; i++) {

      // WHY: Update max whenever we find a larger element
      // WHAT: If current element exceeds max, it becomes new max
      // HOW: Simple comparison and assignment
      if (arr[i] > max) {
        max = arr[i]; // Found new maximum
      }
    }

    return max; // Return largest element found
  }

  public static void main(String[] args) {
    int arr[] = { 1, 8, 7, 56, 90 };
    int n = arr.length;
    int max = largest(arr, n);
    System.out.println("The largest element in the array is: " + max);
    // Output: The largest element in the array is: 90
  }
}

// ------------------------------------------------------------
// ⚡ COMPLEXITY ANALYSIS
// ------------------------------------------------------------
// Time: O(n) - Single pass through array
// Space: O(1) - Only one variable (max) used
//
// ------------------------------------------------------------
// 🎯 PATTERN: Linear Scan for Extremum (Max/Min Finding)
// 🗣️ Interview: "Iterate through array once, tracking maximum seen so far.
// Update max whenever larger element found. Return max after
// complete traversal."
//
// ------------------------------------------------------------
// 🧠 Execution Trace (arr = [1, 8, 7, 56, 90])
// ------------------------------------------------------------
//
// Initialization: max = Integer.MIN_VALUE = -2,147,483,648
//
// i=0: arr[0]=1 → 1 > -2,147,483,648 ✓ → max = 1
// i=1: arr[1]=8 → 8 > 1 ✓ → max = 8
// i=2: arr[2]=7 → 7 > 8 ✗ → max = 8 (unchanged)
// i=3: arr[3]=56 → 56 > 8 ✓ → max = 56
// i=4: arr[4]=90 → 90 > 56 ✓ → max = 90
//
// Loop ends → Return max = 90 ✓
//
// ------------------------------------------------------------
// 🧠 REVISION QUESTIONS
// ------------------------------------------------------------
//
// Q1. Why use Integer.MIN_VALUE instead of 0 for initialization?
// → Array might contain only negative numbers!
// → Example: arr = [-5, -2, -10] → max should be -2
// → If initialized to 0, would incorrectly return 0
// → Integer.MIN_VALUE guarantees first element will be larger
//
// Q2. What if array is empty (n = 0)?
// → Current code would return Integer.MIN_VALUE
// → Better: Add validation check
//
// public static int largest(int[] arr, int n) {
// if (n == 0) {
// throw new IllegalArgumentException("Array is empty");
//  Or return special value like Integer.MIN_VALUE
// }
// int max = Integer.MIN_VALUE;
//  ... rest of code
// }
//
// Q3. Alternative: Start with arr[0] instead of Integer.MIN_VALUE?
// → Yes, valid approach if array guaranteed non-empty
//
// public static int largest(int[] arr, int n) {
// if (n == 0) return Integer.MIN_VALUE; // Handle empty case
//
// int max = arr[0]; // Start with first element
// for (int i = 1; i < n; i++) { // Start loop from index 1
// if (arr[i] > max) {
// max = arr[i];
// }
// }
// return max;
// }
//
// Pros: Clearer logic, one less comparison
// Cons: Requires empty check, starts from i=1
//
// Q4. How to find SECOND largest element?
// → Track two variables: largest and secondLargest
//
// public static int secondLargest(int[] arr, int n) {
// if (n < 2) return -1; // Need at least 2 elements
//
// int largest = Integer.MIN_VALUE;
// int secondLargest = Integer.MIN_VALUE;
//
// for (int i = 0; i < n; i++) {
// if (arr[i] > largest) {
// secondLargest = largest; // Old largest becomes second
// largest = arr[i]; // New largest
// } else if (arr[i] > secondLargest && arr[i] != largest) {
// secondLargest = arr[i]; // Update second largest
// }
// }
// return secondLargest;
// }
//
// Q5. How to find BOTH max and min in single pass?
// → Track two variables simultaneously
//
// public static int[] findMaxMin(int[] arr, int n) {
// int max = Integer.MIN_VALUE;
// int min = Integer.MAX_VALUE;
//
// for (int i = 0; i < n; i++) {
// if (arr[i] > max) max = arr[i];
// if (arr[i] < min) min = arr[i];
// }
//
// return new int[]{max, min}; // Return both
// }
//
// Q6. Using Java Streams (modern approach)?
//
// import java.util.Arrays;
//
// public static int largest(int[] arr) {
// return Arrays.stream(arr)
// .max()
// .orElseThrow(() -> new IllegalArgumentException("Empty"));
// }
//
// Pros: Concise, functional style
// Cons: Less efficient (creates stream object), harder to debug
//
// ------------------------------------------------------------
// 🔥 KEY INSIGHTS
// ------------------------------------------------------------
//
// 1. **Single Pass Sufficiency**
// - Only need ONE traversal to find maximum
// - Don't need sorting (which would be O(n log n))
// - Optimal: Can't do better than O(n) - must check all elements
//
// 2. **Initialization matters**
// - Integer.MIN_VALUE: Safe for all cases (including negative numbers)
// - arr[0]: Works if non-empty guaranteed, saves one comparison
// - 0: WRONG! Fails for negative-only arrays
//
// 3. **Similar problems (same pattern)**:
// - Find minimum element (change > to <)
// - Find second largest (track two variables)
// - Find max and min together (two comparisons per element)
// - Find kth largest (use priority queue or quickselect)
//
// 4. **Edge cases to consider**:
// - Empty array (n = 0)
// - Single element array (n = 1)
// - All elements same (arr = [5, 5, 5, 5])
// - All negative numbers (arr = [-1, -5, -3])
// - Integer.MAX_VALUE in array (2,147,483,647)
//
// 5. **Optimization impossible**:
// - Already O(n) time, O(1) space
// - Can't skip elements (might skip the maximum!)
// - This IS the optimal solution
//
// 6. **Interview variations**:
// - "Find largest k elements" → Use min-heap of size k
// - "Find largest in each subarray" → Sliding window maximum
// - "Find largest in rotated array" → Binary search
//
// 💡 Interview Strategy:
// "I'll do a single pass through the array, maintaining a max variable
// initialized to Integer.MIN_VALUE to handle negative numbers. For each
// element, if it's larger than current max, I update max. After the loop,
// max holds the largest element. This is optimal at O(n) time and O(1) space."
//
// 🎯 Pattern Recognition:
// - "Find largest/smallest" → Linear scan with single variable
// - "Find kth largest" → Use heap or quickselect
// - "Find in sorted/rotated array" → Use binary search
//
// 📝 Common Mistakes to Avoid:
// ❌ Initializing max to 0 (fails for negative arrays)
// ❌ Using sorting first (O(n log n) when O(n) possible)
// ❌ Not handling empty array
// ❌ Using arr.length directly without validation
// ------------------------------------------------------------
