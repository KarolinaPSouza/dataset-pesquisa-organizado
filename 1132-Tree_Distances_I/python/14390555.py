n=int(input())
G=[[] for _ in range(n+1)]
for _ in range(n-1):
    a,b=map(int,input().split())
    G[a].append(b)
    G[b].append(a)
from collections import deque

D=deque()
D.append(1)
Parent=[-1]*(n+1)
seq=[1]
while D:
    a=D.popleft()
    for j in G[a]:
        if j!=Parent[a]:
            D.append(j)
            Parent[j]=a
            seq.append(j)

dp=[[0]*2 for _ in range(n+1)]
for i in seq[::-1]:
    for j in G[i]:
        if j!=Parent[i]:
            for value in dp[j]:
                if value+1>=dp[i][0]:
                    dp[i][0],dp[i][1]=value+1,dp[i][0]
                elif value+1>=dp[i][1]:
                    dp[i][1]=value+1
                break

dp2=[0]*(n+1)
for i in seq:
    if Parent[i]==-1:
        continue
    dp2[i]=dp2[Parent[i]]+1
    if dp[Parent[i]][0]==dp[i][0]+1:
        dp2[i]=max(dp2[i],dp[Parent[i]][1]+1)
    else:
        dp2[i]=max(dp2[i],dp[Parent[i]][0]+1)

ans=[max(dp[i][0],dp2[i]) for i in range(1,n+1)]
print(*ans)    

