A = []
L = []
n = int(input())
for _ in range(n):
    x,y = map(int, input().split())
    A.append(x)
    L.append(y)
A.sort()
L.sort()
i, j = 0,0
cnt = 0 
bst = 0
while i<n and j<n:
    if A[i]<L[j]:
        cnt += 1
        i += 1
    else:
        cnt -= 1
        j += 1
    if bst < cnt:
        bst = cnt
print(bst)