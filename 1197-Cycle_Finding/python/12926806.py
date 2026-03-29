import sys
input = sys.stdin.readline
sys.setrecursionlimit(9**9)
I=lambda:map(int,input().split())
n,m=I()
E=[(*I(),)for _ in" "*m]
D=[-1e13]*-~n
D[1]=0
R={}
for _ in range(n):
    c = 0
    for a, b, w in E:
        w += D[a]
        if D[b] > w:
            c = b
            D[b] = w
            R[b] = a
if c:
    K = [c]
    for k in K:
        if k in K[:-1]:
            break
        K.append(R[k])
    print("YES")
    print(*reversed(K[K.index(k):]))
else:
    print("NO")