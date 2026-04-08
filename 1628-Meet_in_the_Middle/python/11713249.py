from collections import Counter
from itertools import combinations
def meetInTheMiddle(n,x,arr):
    def subset_sums(nums):
        sums = []
        for size in range(len(nums) + 1):
            for subset in combinations(nums, size):
                sums.append(sum(subset))
        return sums

    left = arr[:n // 2]
    right = arr[n // 2:]

    leftSum = subset_sums(left)
    rightSum = subset_sums(right)

    hashtable = Counter(rightSum)
    ways = 0
    for l in leftSum:
        ways += hashtable[x-l]
    return ways

n,x = input().split()
arr = list(map(int,input().split()))
x = int(x)
print(meetInTheMiddle(int(n),x,arr))