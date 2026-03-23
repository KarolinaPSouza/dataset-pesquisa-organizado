from bisect import bisect_right

n, m = map(int, input().split())
price = list(map(int, input().split()))
maxP = list(map(int, input().split()))

price.sort()
parent = list(range(n))

def find(x):
    if x < 0:
        return -1
    if parent[x] != x:
        parent[x] = find(parent[x])  # path compression
    return parent[x]

for val in maxP:
    idx = bisect_right(price, val) - 1
    idx = find(idx)
    if idx >= 0 and price[idx] <= val:
        print(price[idx])
        parent[idx] = find(idx - 1)  # mark this index as used
    else:
        print(-1)