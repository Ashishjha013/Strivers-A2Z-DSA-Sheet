// ------------------------------------------------------------
// 🧮 Question 2: Find Second Largest Element in Array
// ------------------------------------------------------------
// 🧩 Find second maximum value in array
// 🔑 Core Concept: Track two variables in single pass
// 💡 Pattern: Two-Variable Tracking
//
// Level: 🟡 Easy-Medium
// Tags: #Arrays #TwoVariables
// ------------------------------------------------------------

import java.util.ArrayList;

public class Question2 {

  public static int getSecondLargest(int[] arr) {

    // WHY: Start with first element as largest
    // WHAT: Assume arr[0] is biggest initially
    // HOW: Will update if we find larger values
    int largest = arr[0];

    // WHY: Need minimum value to detect if second exists
    // WHAT: MIN_VALUE ensures any real element is larger
    // HOW: If stays MIN_VALUE, means no second largest found
    int secondLargest = Integer.MIN_VALUE;

    // WHY: Check every element to update our two variables
    // WHAT: Loop through all values
    // HOW: Use enhanced for-loop
    for (int value : arr) {

      // WHY: Found new biggest element
      // WHAT: Current value is larger than our current largest
      // HOW: Move old largest down to second, new value becomes largest
      if (value > largest) {
        secondLargest = largest; // Old largest becomes second
        largest = value; // New value becomes largest
      }

      // WHY: Found potential second largest
      // WHAT: Value is smaller than largest BUT bigger than current second
      // HOW: Update only secondLargest, leave largest unchanged
      else if (value < largest && value > secondLargest) {
        secondLargest = value;
      }

      // Note: Skip if value == largest (duplicate) OR value <= secondLargest
    }

    // WHY: Check if we actually found a second largest
    // WHAT: If still MIN_VALUE, no second distinct element exists
    // HOW: Return -1 to indicate "not found"
    return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
  }

  public static ArrayList<Integer> getSmallestValues(int[] arr) {

    // WHY: Start with maximum values
    // WHAT: MAX_VALUE ensures any real element is smaller
    // HOW: Will update when we find smaller values
    int small = Integer.MAX_VALUE;
    int secondSmall = Integer.MAX_VALUE;

    // WHY: Check every element to find two smallest
    // WHAT: Loop through all values
    // HOW: Similar logic as largest, but reversed comparisons
    for (int value : arr) {

      // WHY: Found new smallest element
      // WHAT: Current value is smaller than our current smallest
      // HOW: Move old smallest up to second, new value becomes smallest
      if (value < small) {
        secondSmall = small; // Old smallest becomes second
        small = value; // New value becomes smallest
      }

      // WHY: Found potential second smallest
      // WHAT: Value is larger than smallest BUT smaller than current second
      // HOW: Update only secondSmall, leave small unchanged
      else if (value != small && value < secondSmall) {
        secondSmall = value;
      }
    }

    // WHY: Return both smallest values
    // WHAT: Create list with small and secondSmall
    // HOW: Check if secondSmall was found, otherwise return [-1]
    ArrayList<Integer> ans = new ArrayList<>();
    if (secondSmall != Integer.MAX_VALUE) {
      ans.add(small);
      ans.add(secondSmall);
    } else {
      ans.add(-1);
    }

    return ans;
  }

  public static void main(String[] args) {
    int arr[] = { 12, 35, 1, 10, 34, 1 };
    System.out.println("Second largest: " + getSecondLargest(arr));
    // Output: 34

    int arr2[] = { 2, 4, 3, 5, 6 };
    System.out.println("Smallest values: " + getSmallestValues(arr2));
    // Output: [2, 3]
  }
}

// ⚡ Time: O(n) | Space: O(1)
// 🗣️ Interview: "Track two variables. If element > largest, cascade update.
// If between them, update second only."

// ------------------------------------------------------------
// 🧠 TRACE: arr = [12, 35, 1, 10, 34, 1]
// ------------------------------------------------------------
// Start: largest=12, second=MIN
// value=35: 35>12 → second=12, largest=35
// value=1: skip (too small)
// value=10: skip (10 not > 12)
// value=34: 34<35 && 34>12 → second=34 ✓
// Result: 34

// ------------------------------------------------------------
// 🔑 KEY INSIGHT: Why "value < largest"?
// ------------------------------------------------------------
// arr = [10, 20, 20, 5]
//
// WITHOUT check: second 20 becomes secondLargest ✗
// WITH check: second 20 skipped, secondLargest stays 10 ✓
//
// Prevents duplicates of largest from becoming second!

// ------------------------------------------------------------
// 🧠 EDGE CASES
// ------------------------------------------------------------
// All same [5,5,5] → -1 (no second distinct)
// Negatives [-5,-2,-10] → -5 (second largest)
// Single element [42] → -1 (no second element)
