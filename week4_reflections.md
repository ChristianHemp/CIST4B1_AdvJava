Fast Sorting Algorithms
• So far we have previously covered brute force sorting
• Conceptually simple to understand, but not efficient
• In order to efficiently sort large amounts of data, we must do
better than O(N2). How to efficiently tackle a big task?
• Divide and Conquer

Quick Sort
• Quicksort is a sorting algorithm that repeatedly partitions the
input into low and high parts (each part unsorted), and then
recursively sorts each of those parts.
• Pivot is chosen to divide data into parts lower than it or higher
than it.
• Can be any value, typically middle or last element is used.
• Eventually, all elements of the array have been divided into
ordered parts

In-Place Quicksort
• In-Place: Algorithms that do not require us to allocate memory
for additional data structures
• Cant create new arrays for partitions around pivot
• So we must organize them in the array itself
• Dont want to loop more than once through the array, solution
needs to be more efficient than brute force

Partition Psuedocode
• Make last element pivot, and index boundaries
• Keep track of divide pointer ‘i’, start one below low bound
• Loop through from low to high bound
• If current element is less or equal to pivot, increment i and swap arr[i]
with arr[current]
• At end of loop i will be in pivot’s spot, swap it into place
• Return pivot location so it can be excluded in recursive calls

Pop Quiz
• Quicksort is naturally recursive, break it down into base and
recursive cases.

• What previous algorithm does this remind you of? What does
this say about its efficiency?

Base Case: Subarray has 0 or 1 element (low >= high) → already sorted, stop recursion.

Recursive Case: Choose a pivot, partition (left < pivot, right > pivot), recursively quicksort left and right sides.

Reminds You Of: Merge Sort — both use divide-and-conquer and recursive splitting.

Efficiency: Average O(n log n) (log n levels × n work per level); Worst O(n²) (bad pivot); fast in practice and in-place (no extra array like merge sort).

Efficiency
• Average case: Linearithmic O(N log N)
• Worst case: Quadratic O(N2)
• Worst case occurs when worst pivot is always selected, leading
to all elements being in one partition
• Usually better than quadratic time complexity, one of the fastest
sorting algorithms available.

Guaranteed Divide and Conquer
• Random selection of pivot in quick sort means we aren’t always
being super efficient with our divisions
• Ideally we divide equally each partition
• In quicksort we sort then split
• What if instead we split then sort?

Merge Sort
• Conceptually simple, split an array in two until you are down to
one element arrays, then merge them back up one pair at a
time in sorted order.
• Always split down the middle
• Garuntees best divide and conquer, but we need extra memory
space

Efficiency
• Worst case and Average case of O(N log N)
• For runtime complexity, one of the most efficient
• However, space complexity is a problem

Fast Integer Sorting
• Sorts integers based on their individual digits
• Numbers are sorted on right most digit first, then moving one
place to the left until all are sorted
• Numbers with same digit are grouped into buckets
• To handle negative numbers, would need positive and negative
buckets so that reverse order can be made for negative integers

Efficiency
• Average case O(N)
• Worst case O(W*N)
• N = number of elements to sort
• W = number of digits in each element
• Can beat out Quicksort and Mergesort for large datasets
• Performance can degrade below Selection Sort once W
becomes bigger than N
