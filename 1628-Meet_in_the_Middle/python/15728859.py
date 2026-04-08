import sys
from collections import Counter

# Read all input at once
n, x, *t = map(int, sys.stdin.read().split())

# Helper to generate all subset sums for a list
def get_sums(arr):
    sums = [0]
    for v in arr:
        sums += [i + v for i in sums]
    return sums

# Split array
mid = n // 2

# 1. Get counts of all sums from the right half
right_counts = Counter(get_sums(t[mid:]))

# 2. Iterate left sums and add the count of the required remainder from the right
# If (x - i) is not in right_counts, it returns 0
print(sum(right_counts[x - i] for i in get_sums(t[:mid])))