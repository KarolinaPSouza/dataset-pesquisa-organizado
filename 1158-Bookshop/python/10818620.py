import sys
input = sys.stdin.readline
n,x=map(int,input().split())
h=[int(i) for i in input().split()]
s=[int(i) for i in input().split()]
K=[0]*(x+1)
for i in range(n):
    hi,si=h[i],s[i]
    for j in range(x,hi-1,-1):
        K[j]=max(K[j],K[j-hi]+si)
print(K[x])