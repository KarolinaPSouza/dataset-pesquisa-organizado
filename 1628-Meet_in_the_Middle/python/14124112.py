import sys
import math
from collections import defaultdict, deque
from heapq import heappush, heappop
from itertools import permutations, combinations
from bisect import bisect_left, bisect_right
from functools import lru_cache

# Fast input using sys.stdin.buffer.read
data = sys.stdin.buffer.read().split()
index = 0

def next_int():
    global index
    val = int(data[index])
    index += 1
    return val

def next_str():
    global index
    val = data[index].decode()
    index += 1
    return val

def next_list(size, type_cast=int):
    global index
    val = list(map(type_cast, data[index:index + size]))
    index += size
    return val

# Output
def print_list(lst): print(" ".join(map(str, lst)))

# Common math functions
def gcd(a, b): return math.gcd(a, b)
def lcm(a, b): return (a * b) // gcd(a, b)

# Binary search
def binary_search(arr, x):
    idx = bisect_left(arr, x)
    if idx < len(arr) and arr[idx] == x:
        return idx
    return -1

# Sieve of Eratosthenes
def sieve(n):
    is_prime = [True] * (n + 1)
    is_prime[0] = is_prime[1] = False
    for i in range(2, int(n**0.5) + 1):
        if is_prime[i]:
            for j in range(i * i, n + 1, i):
                is_prime[j] = False
    return [i for i in range(n + 1) if is_prime[i]]

# Graph utilities
def bfs(graph, start):
    visited = set()
    queue = deque([start])
    visited.add(start)
    while queue:
        node = queue.popleft()
        for neighbor in graph[node]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append(neighbor)

def dfs(graph, start, visited=None):
    if visited is None:
        visited = set()
    visited.add(start)
    for neighbor in graph[start]:
        if neighbor not in visited:
            dfs(graph, neighbor, visited)


def highestPowerof2(x):
    # check for the set bits
    x |= x >> 1
    x |= x >> 2
    x |= x >> 4
    x |= x >> 8
    x |= x >> 16

    # Then we remove all but the top bit by xor'ing the
    # string of 1's with that string of 1's shifted one to
    # the left, and we end up with just the one top bit
    # followed by 0's.
    return x ^ (x >> 1)

# Modular arithmetic
MOD = 10**9 + 7
def mod_add(a, b): return (a + b) % MOD
def mod_sub(a, b): return (a - b + MOD) % MOD
def mod_mul(a, b): return (a * b) % MOD
def mod_exp(a, b): return pow(a, b, MOD)

class fenwickTree:
    def __init__(self, n):
        self.size = n
        self.tree = [0] * (n + 1)

    def update(self, index, value):
        while index <= self.size:
            self.tree[index] += value
            index += index & -index

    def query(self, index):
        sum_ = 0
        while index > 0:
            sum_ += self.tree[index]
            index -= index & -index
        return sum_

from collections import Counter

def subset_sums(arr):
    sums = [0]
    for val in arr:
        sums += [val + s for s in sums]
    return sums

# Main solve function
def solve():
    # Start your logic here
    n = next_int()
    target = next_int()
    arr = next_list(n)
    x = target
    mid = n // 2
    left = arr[:mid]
    right = arr[mid:]

    # Generate all subset sums
    left_sums = subset_sums(left)
    right_sums = subset_sums(right)

    # Count frequency of sums in right half
    count_right = Counter(right_sums)

    # Count valid combinations
    count = 0
    for s in left_sums:
        count += count_right[x - s]

    print(count)

# Main entry point
if __name__ == "__main__":
    sys.setrecursionlimit(10**6)  # Increase recursion limit if needed
    solve()