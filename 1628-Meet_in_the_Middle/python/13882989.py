# On CSES choose the PyPy3 option 

import collections

# read input
n, x = map(int, input().split())  # array length, required sum
t = list(map(int, input().split()))  # array

# compute sum frequencies for first and second part of the array
def get_subset_sums(l, r):
    sums = [0]
    for ti in t[l : r]:
        sums.extend([s + ti for s in sums])
    return collections.Counter(sums)


freq = [get_subset_sums(0, n // 2), get_subset_sums(n // 2, n)]

# combine results of both parts
answer = 0
for s in freq[0]:
    answer += freq[0][s] * freq[1].get(x - s, 0)

print(answer)