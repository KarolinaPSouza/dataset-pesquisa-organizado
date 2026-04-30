import sys
input = sys.stdin.readline
n,m = map(int,input().split())
a = list(map(int,input().split()))
while bin(n).count("1") > 1:
    a.append(0)
    n+=1
PRE = [0 for _ in range(2*n)]
SUF = [0 for _ in range(2*n)]
TOT = [0 for _ in range(2*n)]
MAX = [0 for _ in range(2*n)]
 
for i in range(n):
    PRE[n+i] = max(0,a[i])
    SUF[n+i] = max(0,a[i])
    TOT[n+i] = a[i]
    MAX[n+i] = max(0,a[i])
for i in range(n-1,0,-1):
    MAX[i] = max(MAX[2*i],MAX[2*i+1],SUF[2*i]+PRE[2*i+1])
    TOT[i] = TOT[2*i]+TOT[2*i+1]
    PRE[i] = max(PRE[2*i],TOT[2*i]+PRE[2*i+1])
    SUF[i] = max(SUF[2*i+1],TOT[2*i+1]+SUF[2*i])
for _ in range(m):
    x,y = map(int,input().split())
    x -= 1
    x += n
    PRE[x] = max(0,y)
    SUF[x] = max(0,y)
    TOT[x] = y
    MAX[x] = max(0,y)
    i = x // 2
    while i:
        MAX[i] = max(MAX[2 * i], MAX[2 * i + 1], SUF[2 * i] + PRE[2 * i+1])
        TOT[i] = TOT[2 * i] + TOT[2 * i + 1]
        PRE[i] = max(PRE[2 * i], TOT[2 * i] + PRE[2 * i + 1])
        SUF[i] = max(SUF[2 * i + 1], TOT[2 * i + 1] + SUF[2 * i])
        i //= 2
    print(MAX[1])