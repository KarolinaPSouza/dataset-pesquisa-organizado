import sys
from bisect import bisect_right

# Increase recursion depth just in case, though we use iterative find
sys.setrecursionlimit(300000)

def solve():
    # 1. Fast Input Reading
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    iterator = iter(input_data)
    n = int(next(iterator))
    m = int(next(iterator))

    # 2. Read and Sort Tickets
    tickets = []
    for _ in range(n):
        tickets.append(int(next(iterator)))
    tickets.sort()

    # 3. Read Customers
    customers = []
    for _ in range(m):
        customers.append(int(next(iterator)))

    # 4. DSU Setup
    # parent[i] will store the index of the next available ticket 
    # to the left (or itself if available).
    parent = list(range(n))

    # Helper: Find the actual available index (with Path Compression)
    def get_available_index(i):
        path = []
        curr = i
        # Traverse up until we find a node that points to itself
        # or we go out of bounds (-1)
        while curr >= 0 and parent[curr] != curr:
            path.append(curr)
            curr = parent[curr]

        # Path Compression: Point all visited nodes directly to the result
        # This makes future lookups O(1) mostly
        for node in path:
            parent[node] = curr

        return curr

    # Helper: "Remove" index i by pointing it to i-1
    def remove_index(i):
        root_i = get_available_index(i)
        root_left = get_available_index(i - 1)
        # Point the current available spot to the one on the left
        if root_i != -1:
            parent[root_i] = root_left

    results = []

    for max_price in customers:
        # Find the rightmost ticket <= max_price
        # bisect_right returns insertion point after max_price, so subtract 1
        initial_idx = bisect_right(tickets, max_price) - 1

        # Find the REAL available ticket (skipping already sold ones)
        idx = get_available_index(initial_idx)

        if idx == -1:
            results.append("-1")
        else:
            results.append(str(tickets[idx]))
            # Mark this ticket as sold
            remove_index(idx)

    print('\n'.join(results))

if __name__ == '__main__':
    solve()