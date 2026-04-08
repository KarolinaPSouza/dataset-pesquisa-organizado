from itertools import combinations  
from collections import Counter

def subsetSums(nums):
    sums = []
    n = len(nums)
    for k in range(n + 1):
        for comb in combinations(nums, k):
            sums.append(sum(comb))
    return sums

def main():
    n, x = map(int, input().split())
    arr = list(map(int, input().split()))

    mid = n // 2  
    left = arr[:mid]
    right = arr[mid:]

    leftSums = subsetSums(left)
    rightSums = subsetSums(right)

    rightCounter = Counter(rightSums)

    count = 0  
    for s in leftSums:
        complement = x - s  
        count += rightCounter.get(complement, 0)

    print(count)

if __name__ == "__main__":
    main()