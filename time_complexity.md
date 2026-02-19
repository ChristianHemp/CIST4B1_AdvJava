Time Complexity Cheat Sheet
Big-O Overview

Big-O describes how runtime grows as input size (n) increases.

Common orders from fastest to slowest:

O(1) – Constant time

O(log n) – Logarithmic

O(n) – Linear

O(n log n) – Linearithmic

O(n²) – Quadratic

O(2ⁿ) – Exponential

O(n!) – Factorial

When analyzing, drop constants and lower-order terms.
Example: O(3n² + 5n + 7) → O(n²)

Recognizing Time Complexity Patterns

O(1)

Accessing an array by index

Simple variable assignment

Single comparison

O(n)

One full loop over input

Linear search

O(n²)

Nested loops over same input

Comparing every pair of elements

O(log n)

Repeatedly dividing input in half

Binary search

O(n log n)

Divide and conquer with linear work per level

Merge sort

Quicksort (average case)

O(2ⁿ)

Recursive branching without reducing problem much

Naive Fibonacci recursion

Sorting Algorithms

Selection Sort

Best: O(n²)

Average: O(n²)

Worst: O(n²)

Always quadratic

Insertion Sort

Best: O(n) (already sorted)

Average: O(n²)

Worst: O(n²)

Good for nearly sorted data

Bubble Sort

Best: O(n) (optimized version)

Average: O(n²)

Worst: O(n²)

Merge Sort

Best: O(n log n)

Average: O(n log n)

Worst: O(n log n)

Uses extra space

QuickSort

Best: O(n log n)

Average: O(n log n)

Worst: O(n²) (bad pivot)

In-place

Searching

Linear Search

O(n)

Binary Search (requires sorted data)

O(log n)

Recursion Patterns

If recursion splits problem in half each time → likely O(log n) depth.

If each level does O(n) work and depth is log n → O(n log n).

If recursion reduces by 1 each time → O(n).

If recursion makes multiple calls without significant reduction → exponential.

Space Complexity

O(1)

In-place algorithms (Selection, Insertion, QuickSort)

O(n)

Merge Sort (temporary arrays)

Recursive calls add stack space:

Depth log n → O(log n) space

Depth n → O(n) space

Quick Pop Quiz Reminders

Nested loops usually mean O(n²).

Halving each step means O(log n).

Divide and conquer with merge/combine step is often O(n log n).

Worst case for QuickSort is O(n²).

Binary search only works on sorted data.
