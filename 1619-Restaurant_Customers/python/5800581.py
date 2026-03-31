def solve(A,B):
    N = dict()
    for a in A:
        N[a] = N.get(a,0) + 1
    for b in B:
        N[b] = N.get(b,0) - 1
    tot, maxi = 0, 0
    for t in sorted(N.keys()):
        tot += N[t]
        maxi = max(maxi, tot)
    return maxi

n = int(input())
A, B = [], []
for i in range(n):
    a, b = [int(x) for x in input().split()]
    A.append(a)
    B.append(b)
print(solve(A,B))

