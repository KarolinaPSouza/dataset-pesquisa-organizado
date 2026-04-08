from collections import Counter

def all_subset_sums(a):
    sums = [0]
    for v in a:
        # append new sums using v
        sums += [s + v for s in sums]
    return sums

def count_subsets_sum_to_x(arr, x):
    n = len(arr)
    L, R = arr[:n//2], arr[n//2:]

    SL = all_subset_sums(L)              # size 2^(n/2)
    SR = all_subset_sums(R)
    freqR = Counter(SR)                  # map sum -> count in right half

    ans = 0
    for s in SL:
        ans += freqR.get(x - s, 0)
    return ans

n, target = list(map(int, input().split()))
arr = list(map(int, input().split()))
print(count_subsets_sum_to_x(arr, target))