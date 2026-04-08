from itertools import combinations
from collections import Counter

def get_subset_sums(arr):
    sums = []
    n = len(arr)
    for i in range(n + 1):
        for comb in combinations(arr, i):
            sums.append(sum(comb))
    return sums

n, x = map(int, input().split())
arr = list(map(int, input().split()))

half = n // 2
left = arr[:half]
right = arr[half:]

# Generate all subset sums
left_sums = get_subset_sums(left)
right_sums = get_subset_sums(right)

# Count frequency of right sums
right_count = Counter(right_sums)

# Count valid combinations
ways = 0
for s in left_sums:
    ways += right_count[x - s]

print(ways)