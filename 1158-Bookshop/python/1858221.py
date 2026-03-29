import sys
input=sys.stdin.readline
n,x=map(int,input().split())
A=list(map(int,input().split()))
B=list(map(int,input().split()))
DP=[0]*(x+1)

for i in range(n):
    v=A[i]
    s=B[i]
    for j in range(x-v,-1,-1):
        DP[j+v]=max(DP[j+v],s+DP[j])
    i+=1
print(DP[x])