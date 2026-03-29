n, x = list(map(int, input().split()))

H = list(map(int, input().split()))
S = list(map(int, input().split()))

A = [0 for _ in range(x + 1)]

for i in range(n):
    h = H[i]
    s = S[i]
    for p in range(x, h - 1, -1):
        A[p] = max(s + A[p - h], A[p])
print(A[x])