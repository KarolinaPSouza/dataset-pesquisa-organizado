import sys
import os

# Only run locally
# if "ONLINE_JUDGE" not in os.environ:
#     sys.stdin = open("input.txt", "r")
#     sys.stdout = open("output.txt", "w")


MOD = 10**9 + 7


def inplist():
    return [int(i) for i in input().split()]


def pow(a, b, mod):
    x = 1
    while b:
        if b & 1:
            x = (x * a) % mod
        a = (a * a) % mod
        b >>= 1
    return x


def debug(**kwargs):
    st = [f"{name}: {val}" for (name, val) in kwargs.items()]
    print(*st, sep=" | ")

import sys
from bisect import bisect_left, bisect_right
from collections import Counter

# Setting recursion limit just in case, though not needed for this iterative solve
sys.setrecursionlimit(2000)

def solve():
    # Fast I/O
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    n = int(input_data[0])
    x = int(input_data[1])
    arr = list(map(int, input_data[2:]))

    left_size = n // 2
    right_size = n - left_size

    # Generate subset sums for the left half
    # Optimization: Use a list and Counter instead of nested bitwise loops if possible
    left_sums = [0]
    for i in range(left_size):
        val = arr[i]
        left_sums += [s + val for s in left_sums]

    # Generate subset sums for the right half
    right_sums = [0]
    for i in range(right_size):
        val = arr[left_size + i]
        right_sums += [s + val for s in right_sums]

    # Use Counter for frequency matching (Much faster than binary search in Python)
    left_counts = Counter(left_sums)
    right_counts = Counter(right_sums)

    ans = 0
    # Match sums: For every sum in left, see if (target - sum) exists in right
    for s_val, count in left_counts.items():
        target = x - s_val
        if target in right_counts:
            ans += count * right_counts[target]

    print(ans)

if __name__ == "__main__":
    # Redirecting input/output for local testing (mimicking the C++ #ifndef ONLINE_JUDGE)
    # In practice, for competitive programming, you usually just use standard I/O
    solve()