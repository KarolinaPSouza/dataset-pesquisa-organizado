import sys
input = sys.stdin.readline
n, m = map(int, input().split())
X = list(map(int, input().split()))
s = 2**19
L = s*[0]  # Largest subarray sum
S = s*[0]  # Start prefix subarray sum
E = s*[0]  # End suffix subarray sum
M = s*[0]  # Sum of whole range
def U(i, v):
    i += s//2
    L[i] = max(0, v)
    S[i] = max(0, v)
    E[i] = max(0, v)
    M[i] = v
    while i>1:
        i //= 2
        a, b = i*2, i*2+1
        L[i] = max(L[a], L[b], E[a] + S[b])
        S[i] = max(S[a], M[a] + S[b])
        E[i] = max(E[b], E[a] + M[b])
        M[i] = M[a] + M[b]
for i, x in enumerate(X):
    U(i, x)
for _ in range(m):
    k, x = map(int, input().split())
    U(k-1, x)
    print(L[1])
 
'''
5 3
1 2 -3 5 -1
2 6
3 1
2 -2
'''