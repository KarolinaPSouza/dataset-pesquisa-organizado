import sys
from bisect import bisect_right

# Increase recursion depth just in case
sys.setrecursionlimit(200005)

def solve():
    # Read all input from stdin at once for performance
    input_data = sys.stdin.read().split()

    if not input_data:
        return

    iterator = iter(input_data)
    try:
        n = int(next(iterator))
        m = int(next(iterator))
    except StopIteration:
        return

    # Parse ticket prices
    h = [int(next(iterator)) for _ in range(n)]

    # Parse customers' max prices
    t = [int(next(iterator)) for _ in range(m)]

    # Sort ticket prices to allow binary search
    h.sort()

    # DSU (Disjoint Set Union) parent array
    # parent[i] points to the index of the next available ticket <= i
    # Initially, every ticket points to itself
    parent = list(range(n))

    # Iterative find function with path compression
    def find(i):
        path = []
        curr = i
        # Traverse up to the root or until -1 (indicating no available ticket to the left)
        while curr >= 0 and parent[curr] != curr:
            path.append(curr)
            curr = parent[curr]

        # Path compression: point all nodes in the path directly to the root
        for node in path:
            parent[node] = curr

        return curr

    results = []

    for max_price in t:
        # Find the rightmost ticket index in the original sorted array such that h[idx] <= max_price
        # bisect_right returns the insertion point; subtract 1 for the actual element index
        idx = bisect_right(h, max_price) - 1

        # If even the smallest ticket is > max_price, idx will be -1
        if idx < 0:
            results.append("-1")
            continue

        # Find the actual available ticket index using DSU (skips used tickets)
        available_idx = find(idx)

        if available_idx == -1:
            results.append("-1")
        else:
            # Ticket found
            results.append(str(h[available_idx]))

            # "Remove" the ticket by unioning the current index with the index to its left.
            # Next time a search lands here, it will be redirected to the left.
            if available_idx > 0:
                parent[available_idx] = find(available_idx - 1)
            else:
                parent[available_idx] = -1

    # Print all results efficiently
    sys.stdout.write('\n'.join(results) + '\n')

if __name__ == '__main__':
    solve()