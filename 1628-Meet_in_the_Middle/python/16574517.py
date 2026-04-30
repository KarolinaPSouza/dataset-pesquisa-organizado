from bisect import *
n,k=map(int ,input().split())
A,B=[],[]
C=[*range(n)]
for _ in range(n):
   a,b=map(int ,input().split())
   A+=a,;B+=b,
C.sort(key= lambda i:B[i])
seen=[]
dsu=[*range(n+1)]
total=counter=0
for i in range(n):
   idx=C[i]
   start,finish=A[idx],B[idx]
   j=bisect(seen,start)
   while j != dsu[j]:
      dsu[j]=j=dsu[dsu[j]]
   if not j:
      if counter<k:
         counter+=1;seen.append(finish);total+=1
      continue   
   dsu[j]-=1
   seen.append(finish)
   total+=1
print(total)