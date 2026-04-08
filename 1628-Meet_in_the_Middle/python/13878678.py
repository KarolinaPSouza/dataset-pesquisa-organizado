# On CSES choose the PyPy3 option 

import collections

# read input
n, x = map(int, input().split())  # array length, required sum
t = list(map(int, input().split()))  # array

# compute sum frequencies for first and second part of the array
freq = []
for k in range (2):  # loop over parts of the array
    sums = [0]
    for ti in t[(n * k) // 2 : (n * (k + 1)) // 2]:  # loop over part elements
        sums.extend([s + ti for s in sums])
    freq.append(collections.Counter(sums))

# combine results of both parts
answer = 0
for s in freq[0]:
    answer += freq[0][s] * freq[1].get(x - s, 0)

print(answer)