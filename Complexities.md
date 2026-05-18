These are all of the time/space complexities of the data structures and algorithms we've learned, condensed into one long list.

# Search Algorithms

## Linear Search
Time:
Best: O(1)
Average: O(n)
Worst: O(n)
Space: O(1)
Note: Works on sorted or unsorted data.
## Binary Search
Time:
Best: O(1)
Average: O(log n)
Worst: O(log n)
Space:
Iterative: O(1)
Recursive: O(log n)
Note: Requires sorted data.

# Sorting Algorithms
## Bubble Sort
Time:
Best: O(n) if optimized
Average: O(n²)
Worst: O(n²)
Space: O(1)
## Insertion Sort
Time:
Best: O(n)
Average: O(n²)
Worst: O(n²)
Space: O(1)
## Merge Sort
Time:
Best: O(n log n)
Average: O(n log n)
Worst: O(n log n)
Space: O(n)
## Quick Sort
Time:
Best: O(n log n)
Average: O(n log n)
Worst: O(n²)
Space:
Average: O(log n)
Worst: O(n)
## Brute Force Sorting
Time: usually O(n²) or worse
Space: depends on implementation
# Linked Lists
## Singly Linked List
Access by index: O(n)
Search: O(n)
Insert at head: O(1)
Insert at tail:
With tail pointer: O(1)
Without tail pointer: O(n)
Delete head: O(1)
Delete tail: O(n)
Delete known node:
If previous node is known: O(1)
Otherwise: O(n)
Space: O(n)
## Doubly Linked List
Access by index: O(n)
Search: O(n)
Insert at head: O(1)
Insert at tail: O(1) with tail pointer
Delete head: O(1)
Delete tail: O(1) with tail pointer
Delete known node: O(1)
Space: O(n)
Note: Uses more memory than singly linked list because each node stores next and prev.
# Stacks
## Stack
Push: O(1)
Pop: O(1)
Peek/top: O(1)
Search: O(n)
Space: O(n)
Rule: LIFO — Last In, First Out.
# Queues
## Regular Queue
Enqueue: O(1)
Dequeue: O(1)
Peek/front: O(1)
Search: O(n)
Space: O(n)
Rule: FIFO — First In, First Out.
## Priority Queue
Assuming binary heap implementation:
Insert: O(log n)
Remove min/max: O(log n)
Peek min/max: O(1)
Search: O(n)
Build heap from array: O(n)
Space: O(n)
# Hash Tables
## Hash Table with Chaining
Insert:
Average: O(1)
Worst: O(n)
Search:
Average: O(1)
Worst: O(n)
Delete:
Average: O(1)
Worst: O(n)
Space: O(n)
## Hash Table with Open Addressing
Insert:
Average: O(1)
Worst: O(n)
Search:
Average: O(1)
Worst: O(n)
Delete:
Average: O(1)
Worst: O(n)
Space: O(n)
Note: Performance gets worse when the table becomes too full.
# Trees
## Binary Search Tree
Search:
Average: O(log n)
Worst: O(n)
Insert:
Average: O(log n)
Worst: O(n)
Delete:
Average: O(log n)
Worst: O(n)
Traversal: O(n)
Space: O(n)
Note: Worst case happens when the tree becomes unbalanced, like a linked list.
## AVL Tree
Search: O(log n)
Insert: O(log n)
Delete: O(log n)
Rotation: O(1)
Traversal: O(n)
Space: O(n)
Note: AVL trees are self-balancing, so they guarantee O(log n) operations.
# Sets
## HashSet
Add:
Average: O(1)
Worst: O(n)
Remove:
Average: O(1)
Worst: O(n)
Contains/search:
Average: O(1)
Worst: O(n)
Iterate through set: O(n)
Space: O(n)
Note: Does not allow duplicates.
# Graph Representations
## Adjacency List
Space: O(V + E)
Add vertex: O(1)
Add edge: O(1)
Check if edge exists: O(degree(v))
Get all neighbors of vertex: O(degree(v))
Traverse whole graph: O(V + E)
Best for sparse graphs.
Works for:
Directed graphs
Undirected graphs
Weighted graphs
Unweighted graphs
## Adjacency Matrix
Space: O(V²)
Add vertex: O(V²) if resizing
Add edge: O(1)
Check if edge exists: O(1)
Get all neighbors of vertex: O(V)
Traverse whole graph: O(V²)
Best for dense graphs.
Fast edge lookup, but high memory use.
Graph Types
Directed Graph
Edges have direction.
Example: A → B
Complexity is usually the same Big-O as undirected graphs.
Undirected Graph
Edges go both ways.
Example: A — B
In an adjacency list, each edge is usually stored twice.
## Unweighted Graph
Edges have no cost/weight.
Often used with BFS for shortest path by number of edges.
## Weighted Graph
Edges have costs/weights.
Example weights:
distance
latency
cost
Needed for algorithms like Dijkstra and Kruskal.
## Graph Traversal
Breadth-First Search — BFS
With adjacency list:
Time: O(V + E)
Space: O(V)
With adjacency matrix:
Time: O(V²)
Space: O(V)
Uses a queue.
Good for shortest path in unweighted graphs.
Depth-First Search — DFS
With adjacency list:
Time: O(V + E)
Space: O(V)
With adjacency matrix:
Time: O(V²)
Space: O(V)
Uses recursion or a stack.
Good for connectivity, cycle detection, and traversal.
# Greedy Algorithms
## Dijkstra’s Algorithm
Purpose: Finds shortest paths from one source in a weighted graph.
Requirement: Edge weights must be nonnegative.
With adjacency list + priority queue:
Time: O((V + E) log V)
Space: O(V + E)
With adjacency matrix:
Time: O(V²)
Space: O(V²)
Greedy idea: Repeatedly choose the currently closest unvisited vertex.
## Kruskal’s Algorithm
Purpose: Finds a minimum spanning tree.
Requirement: Graph should be connected, undirected, and weighted.
Time: O(E log E)
Space: O(V + E)
Main steps:
Sort edges by weight: O(E log E)
Add smallest edge that does not create a cycle.
Use Union-Find / Disjoint Set to detect cycles.
Greedy idea: Always pick the lowest-weight valid edge.
Dynamic Programming
General Dynamic Programming
Time: depends on number of states and work per state.
Space: depends on how many states are stored.
General formula:
Time: # of states × work per state
Space: # of states stored
1D Dynamic Programming
Typical time: O(n)
Typical space:
Normal: O(n)
Optimized: O(1)
2D Dynamic Programming
Typical time: O(nm)
Typical space:
Normal: O(nm)
Optimized: sometimes O(n) or O(m)
Recursive Memoization
Time: # of unique states × work per state
Space: # of unique states
Note: Avoids recomputing repeated subproblems.
