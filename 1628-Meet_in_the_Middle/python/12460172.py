from itertools import combinations
from collections import Counter

def subsets_sums(arr):

    subsets_sums = []
    n = len(arr)
    for i in range(n + 1):
        for subset in combinations(arr, i):
            subsets_sums.append(sum(subset))
    return subsets_sums

def count_subsets(length, sum, arr):
    left_half = arr[:length//2]
    right_half = arr[length//2:]

    left_sums = subsets_sums(left_half)
    right_sums = subsets_sums(right_half)

    right_counter = Counter(right_sums)

    count = 0
    for s in left_sums:
        count += right_counter[sum - s] 
    return count

array_length, required_sum = map(int, input().split())
arr = list(map(int, input().split()))

print(count_subsets(array_length, required_sum, arr))