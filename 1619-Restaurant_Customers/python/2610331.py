n=int(input());a=[];l=[]
for i in range(n):
 x,y=input().split()
 a.append(int(x));l.append(int(y))
a.sort();l.sort()
ans=1
curr=0
i,j=0,0
while i<n and j<n:
 if a[i]<=l[j]:
  curr+=1
  i+=1
 else:
  curr-=1
  j+=1 
 ans=max(ans,curr)
print(ans)
