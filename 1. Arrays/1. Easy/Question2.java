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

      // Note: We skip if value equals largest (duplicate)
      // Note: We skip if value is too small (not in top 2)
    }

    // WHY: Check if we actually found a second largest
    // WHAT: If still MIN_VALUE, no second distinct element exists
    // HOW: Return -1 to indicate "not found"
    if (secondLargest == Integer.MIN_VALUE) {
      return -1;
    }

    return secondLargest;
  }

  public static void main(String[] args) {
    int arr[] = { 12, 35, 1, 10, 34, 1 };
    int result = getSecondLargest(arr);
    System.out.println("The second largest element is: " + result);
    // Output: 34
  }
}

// ------------------------------------------------------------
// ⚡ COMPLEXITY
// ------------------------------------------------------------
// Time: O(n) - Single pass through array
// Space: O(1) - Only two variables used
//
// ------------------------------------------------------------
// 🎯 PATTERN: Two-Variable Tracking
// 🗣️ Interview: "Track largest and secondLargest. When find bigger than
// largest, cascade old largest to second. When find value
// between them, update second only."
//
// ------------------------------------------------------------
// 🧠 EXECUTION TRACE: arr = [12, 35, 1, 10, 34, 1]
// ------------------------------------------------------------
//
// Start: largest=12, secondLargest=MIN_VALUE
//
// value=12: (first element, already set)
// value=35: 35 > 12 → secondLargest=12, largest=35
// value=1: skip (too small)
// value=10: skip (10 not > 12)
// value=34: 34 < 35 && 34 > 12 → secondLargest=34 ✓
// value=1: skip (too small)
//
// Result: 34
//
// ------------------------------------------------------------
// 🔑 KEY INSIGHT: Why check "value < largest"?
// ------------------------------------------------------------
//
// Example: arr = [10, 20, 20, 5]
//
// WITHOUT "value < largest":
// When we hit second 20:
// 20 > secondLargest → secondLargest becomes 20 ✗ WRONG!
//
// WITH "value < largest":
// When we hit second 20:
// 20 < 20? NO → skip ✓ CORRECT!
// secondLargest stays 10
//
// This prevents duplicates of largest from becoming second!
//
// ------------------------------------------------------------
// 🧠 EDGE CASES
// ------------------------------------------------------------
//
// All same [5, 5, 5, 5]:
// largest=5, secondLargest=MIN_VALUE → returns -1 ✓
//
// Two values [10, 5, 10, 5]:
// largest=10, secondLargest=5 → returns 5 ✓
//
// Negatives [-5, -2, -10]:
// largest=-2, secondLargest=-5 → returns -5 ✓
//
// Single element [42]:
// largest=42, secondLargest=MIN_VALUE → returns -1 ✓