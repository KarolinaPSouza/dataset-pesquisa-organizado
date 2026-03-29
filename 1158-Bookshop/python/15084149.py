import sys
import bisect
import heapq    
import bisect
from collections import defaultdict, deque
from bisect import bisect_right, insort

# Fast I/O
input = sys.stdin.buffer.readline
def print_array(arr, sep=" "):
    sys.stdout.write(sep.join(map(str, arr)) + "\n")

def fast_print_matrix(matrix, sep=" "):
    """
    Efficiently prints a 2D matrix (list of lists) using sys.stdout.write.
    Much faster than calling print() inside loops.
    """
    sys.stdout.write("\n".join(sep.join(map(str, row)) for row in matrix) + "\n")

# Set recursion limit for deep recursive calls (e.g., DFS)
sys.setrecursionlimit(10**6)

# Utility functions
def read_int():
    return int(input())

def read_ints():
    return list(map(int, input().split()))

def read_str():
    return input().decode().strip()

def read_strs():
    return list(input().decode().split())

class LazyHeap:
    def __init__(self):
        self.heap = []
        self.deleted = set()

    def push(self, k, v):
        heapq.heappush(self.heap, (k, v))

    def remove(self, k, v):
        """Mark an element as deleted (lazy deletion)"""
        self.deleted.add((k, v))

    def pop(self):
        """Pop the top element, skipping deleted ones"""
        while self.heap and self.heap[0] in self.deleted:
            heapq.heappop(self.heap)
        if self.heap:
            return heapq.heappop(self.heap)
        return None

    def top(self):
        """Return the top element without removing it"""
        while self.heap and self.heap[0] in self.deleted:
            heapq.heappop(self.heap)
        if self.heap:
            return self.heap[0]
        return None

class SortedSet:
    def __init__(self):
        self.data = []

    def add(self, x):
        """Insert x maintaining sorted order if not already present"""
        i = bisect.bisect_left(self.data, x)
        if i == len(self.data) or self.data[i] != x:
            self.data.insert(i, x)  # O(n) due to list shift

    def remove(self, x):
        """Remove x if present"""
        i = bisect.bisect_left(self.data, x)
        if i < len(self.data) and self.data[i] == x:
            self.data.pop(i)  # O(n)

    def __contains__(self, x):
        i = bisect.bisect_left(self.data, x)
        return i < len(self.data) and self.data[i] == x

    def lower_bound(self, x):
        """Greatest element < x"""
        i = bisect.bisect_left(self.data, x)
        return self.data[i - 1] if i > 0 else -1

    def upper_bound(self, x):
        """Smallest element > x"""
        i = bisect.bisect_right(self.data, x)
        return self.data[i] if i < len(self.data) else -1

    def __getitem__(self, idx):
        return self.data[idx]

    def __len__(self):
        return len(self.data)

    def __iter__(self):
        return iter(self.data)

dirs = ((1, 0), (0, 1))
MOD = 1_000_000_007

def soltn(x, h, s, id, dp):
    if x < 0:
        return -1_000_000_000
    if id >= len(h):
        return 0
    if dp[id][x] != -1:
        return dp[id][x]
    dp[id][x] = max(s[id] + soltn(x - h[id], h, s, id + 1, dp), soltn(x, h, s, id + 1, dp))
    return dp[id][x]

# Main solution logic
def solve():
    [n, x] = read_ints()
    h = read_ints()
    s = read_ints()

    curr = [0 for _ in range(x + 1)]
    temp = [0 for _ in range(x + 1)]

    # for id in range(n - 1, -1, -1):

    # here if we use same curr instead of maintaining a copy we can see in O we are using 
    # same step updated value of curr[3] at O so here we must need to maintain a copy of prev 
    # step result

    # x = 5, h[id] = 2, id = 2, i = 4
    # curr[2] = max(s[2] + curr[0], curr[5])
    # curr[3] = max(s[2] + curr[1], curr[4])
    # curr[4] = max(s[2] + curr[2], curr[3])
    # curr[5] = max(s[2] + curr[3], curr[3]) --- O

    # x = 5, h[id] = 3, id = 3, i = 5
    # curr[5] = max(s[3] + curr[2], curr[5])
    # curr[4] = max(s[3] + curr[1], curr[4])
    # curr[3] = max(s[3] + curr[0], curr[3])

    #     for i in range(h[id], x + 1):
    #         curr[i] = max(s[id] + temp[i - h[id]], temp[i])
    #     temp = curr
    # print(curr[x])

    for id in range(n - 1, -1, -1):
        # x = 5, h[id] = 3, id = 3, i = 5
        # curr[5] = max(s[3] + curr[2], curr[5])
        # curr[4] = max(s[3] + curr[1], curr[4])
        # curr[3] = max(s[3] + curr[0], curr[3])

        # x = 5, h[id] = 2, id = 2, i = 4
        # curr[4] = max(s[2] + curr[2], curr[5])
        # curr[3] = max(s[2] + curr[1], curr[4])
        # curr[2] = max(s[2] + curr[0], curr[3])
        for i in range(x, h[id] - 1, -1):
            curr[i] = max(s[id] + curr[i - h[id]], curr[i])
    print(curr[x])

    # curr[id] = max(s[id] + max(temp[0...x - h[id]]), max(temp[h[id]...x]))

# Call the solve function
if __name__ == "__main__":
    solve()