from itertools import chain, combinations
from collections import Counter

def subset_sums(nums):
    return [sum(comb) for comb in chain.from_iterable(combinations(nums, r) for r in range(len(nums) + 1))]

def solve(n, x, arr):
    first_half = arr[:n//2]
    second_half = arr[n//2:]
    sum_first_half = subset_sums(first_half)
    sum_second_half = subset_sums(second_half)
    count_second_half = Counter(sum_second_half)

    result = 0
    for s1 in sum_first_half:
        if (x - s1) in count_second_half:
            result += count_second_half[x - s1]

    print(result)

n, x = map(int, input().split())
arr = list(map(int, input().split()))
solve(n, x, arr)