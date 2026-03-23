import bisect

m, n = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()

parent = [i for i in range(m)]

def find(x):
    if x < 0:
        return -1
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def rem(x):
    root = find(x)
    if root == -1:
        return
    parent[root] = find(root - 1)

for i in range(len(b)):
    idx = bisect.bisect_right(a, b[i]) - 1
    idx = find(idx)
    if idx == -1:
        print(-1)
    else:
        print(a[idx])
        rem(idx)