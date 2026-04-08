from itertools import combinations
from collections import Counter

def subset_sums(arr):
    """ Generate all possible subset sums of the given array. """
    sums = []
    n = len(arr)
    for i in range(n + 1):
        for combo in combinations(arr, i):
            sums.append(sum(combo))
    return sums

def count_ways(n, x, arr):
    # Split the array into two halves
    mid = n // 2
    left_half = arr[:mid]
    right_half = arr[mid:]

    # Get all subset sums for both halves
    left_sums = subset_sums(left_half)
    right_sums = subset_sums(right_half)

    # Count occurrences of each sum in the right half
    right_count = Counter(right_sums)

    # Count the number of ways to form the sum x
    count = 0
    for left_sum in left_sums:
        complement = x - left_sum
        if complement in right_count:
            count += right_count[complement]

    return count

# Read input
n, x = map(int, input().strip().split())
arr = list(map(int, input().strip().split()))

# Find and print the number of ways to create the sum x
print(count_ways(n, x, arr))