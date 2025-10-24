// ------------------------------------------------------------
// 🧮 Question 1: Find Largest Element in Array
// ------------------------------------------------------------
// 🧩 Find and return the maximum value in an array
// 🔑 Core Concept: Single pass tracking maximum
// 💡 Pattern: Linear Scan
//
// Level: 🟢 Easy
// Tags: #Arrays #MaxFinding
// ------------------------------------------------------------

public class Question1 {

  // WHY: Find maximum by checking every element once
  // WHAT: arr = input array, n = number of elements
  // HOW: Keep track of max, update when find larger value
  public static int largest(int[] arr, int n) {

    // WHY: Start with smallest possible integer
    // WHAT: Integer.MIN_VALUE = -2,147,483,648
    // HOW: Guarantees any array element will be larger
    int max = Integer.MIN_VALUE;

    // WHY: Need to check every element to find maximum
    // WHAT: Loop from 0 to n-1
    // HOW: Compare each with current max
    for (int i = 0; i < n; i++) {

      // WHY: Update max when find larger element
      // WHAT: If current element bigger than max
      // HOW: Replace max with current element
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    return max;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 8, 7, 56, 90 };
    int n = arr.length;
    int max = largest(arr, n);
    System.out.println("The largest element is: " + max);
    // Output: 90
  }
}

// ⚡ Time: O(n) | Space: O(1)
// 🗣️ Interview: "Single pass through array, track max, update when find
// larger."

// ------------------------------------------------------------
// 🧠 TRACE: arr = [1, 8, 7, 56, 90]
// ------------------------------------------------------------
// Start: max = MIN_VALUE
// i=0: arr[0]=1 → 1 > MIN ✓ → max=1
// i=1: arr[1]=8 → 8 > 1 ✓ → max=8
// i=2: arr[2]=7 → 7 > 8 ✗ → max=8 (no change)
// i=3: arr[3]=56 → 56 > 8 ✓ → max=56
// i=4: arr[4]=90 → 90 > 56 ✓ → max=90
// Result: 90 ✓

// ------------------------------------------------------------
// 🔑 KEY INSIGHT: Why Integer.MIN_VALUE?
// ------------------------------------------------------------
// Array with negatives: [-5, -2, -10]
// If start with 0: returns 0 (WRONG!)
// If start with MIN_VALUE: returns -2 (CORRECT!)

// ------------------------------------------------------------
// 🧠 EDGE CASES
// ------------------------------------------------------------
// Empty array []: returns MIN_VALUE (should add check)
// All negative [-1, -5, -3]: returns -1 ✓
// All same [5, 5, 5]: returns 5 ✓