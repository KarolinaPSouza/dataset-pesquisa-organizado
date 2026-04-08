from itertools import chain, combinations
from collections import Counter

def subset_sums(nums):
    return [sum(c) for c in chain.from_iterable(combinations(nums, r) for r in range(len(nums) + 1))]

def solForG():
    n, x = map(int, input().split())
    lst = list(map(int, input().split()))
    firstHalf = lst[:n // 2]
    secondHalf = lst[n // 2:]
    sumFH = subset_sums(firstHalf)
    sumSH = subset_sums(secondHalf)
    counterForSH = Counter(sumSH)

    res = 0
    for s1 in sumFH:
        if (x - s1) in counterForSH:
            res = res +  counterForSH[x - s1]

    print(res)


if __name__ == "__main__":
    solForG()