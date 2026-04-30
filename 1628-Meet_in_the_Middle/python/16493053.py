from bisect import *
n,k=map(int ,input().split())
A,B=[],[]
C=[*range(n)]
dsu=[*range(n+1)]
seen=[];total=ans=0
for _ in range(n):
    a,b=map(int ,input().split())
    A+=a,;B+=b,
C.sort(key=lambda i:B[i])
for v in C:
    start=A[v];finish=B[v]
    j=bisect_right(seen,start)
    while j!=dsu[j]:
        dsu[j]=j=dsu[dsu[j]]
    if not j:
        if total<k:
            total+=1
            ans+=1
            seen.append(finish)
        continue
    ans+=1
    seen.append(finish)
    dsu[j]-=1
print(ans)