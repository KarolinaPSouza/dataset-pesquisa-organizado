import sys
input=sys.stdin.readline
N=int(input())
A=[] ; S=set()
for i in range(N):
    a,b,p=map(int,input().split())
    A.append((a,b,p))
    S.add(a);S.add(b)
num=0;D={}
for i in sorted(list(S)):
    D[i]=num
    num+=1
from collections import defaultdict
newD=defaultdict(list)
for i in A:
    newD[D[i[1]]].append((D[i[0]], i[2]))
dp=[0]*num
for i in range(num):
    if i > 0:
        dp[i]=dp[i-1]
    if i in newD:
        for j in newD[i]:
            dp[i]=max(dp[i], dp[j[0]-1]+j[1])
mx=-1<<64
# print(dp)
for i in dp:
    mx=max(mx,i)
print(mx)