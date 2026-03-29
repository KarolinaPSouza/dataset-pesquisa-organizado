import sys
import bisect
import heapq    
import bisect
from collections import defaultdict, deque
from bisect import bisect_right, insort
from collections import deque

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

def pow(a, b):
    res = 1
    mod = 1_000_000_007
    while b > 0:
        if b % 2 == 0:
            a = (a * a) % mod
            b //= 2
        else:
            res = (res * a) % mod
            b -= 1
    return res


def ub(arr, tar, l):
    h = len(arr) - 1
    ans = len(arr)
    while l <= h:
        mid = l + (h - l) // 2
        if arr[mid] < tar:
            l = mid + 1
        else:
            ans = mid
            h = mid - 1
    return ans

def update(seg, xid, val, l, r, id):
    mod = 1_000_000_007
    if l == r:
        seg[id] = (seg[id] + val) % mod
        return
    mid = l + (r - l) // 2
    if xid <= mid:
        update(seg, xid, val, l, mid, (2 * id) + 1)
    else:
        update(seg, xid, val, mid + 1, r, (2 * id) + 2)
    seg[id] = (seg[(2 * id) + 1] + seg[(2 * id) + 2]) % mod

def query(seg, x, y, l, r, id):
    mod = 1_000_000_007
    if r < x or y < l:
        return 0
    if x <= l and r <= y:
        return seg[id]

    mid = l + (r - l) // 2
    return (query(seg, x, y, l, mid, (2 * id) + 1) + query(seg, x, y, mid + 1, r, (2 * id) + 2)) % mod

def soltn(strs, vis, r, c):
    dirs = ((0, 1), (1, 0), (-1, 0), (0, -1))
    q = deque([(r, c)])
    while q:
        r, c = q.popleft()
        if r < 0 or c < 0 or c >= len(strs[0]) or r >= len(strs) or strs[r][c] == '#' or vis[r][c]:
            continue
        vis[r][c] = True
        for dir in dirs:
            nr = dir[0] + r
            nc = dir[1] + c
            if nr < 0 or nc < 0 or nr >= len(strs) or nc >= len(strs[0]) or vis[nr][nc]:
                continue
            q.append((nr, nc))

def solve():
    [n, m] = read_ints()
    strs = []
    for i in range(n):
        strs.append(read_str())
    vis = [[False for _ in range(m)] for _ in range(n)]
    ans = 0
    ids = []
    for i in range(n):
        for j in range(m):
            if strs[i][j] == '.':
                ids.append((i, j))
    for (i, j) in ids:    
        if vis[i][j]:
            continue
        ans+=1
        soltn(strs, vis, i, j)
    print(ans)

if __name__ == "__main__":
    solve()