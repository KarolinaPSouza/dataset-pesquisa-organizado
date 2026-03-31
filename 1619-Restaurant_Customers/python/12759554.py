from bisect import bisect_right
n=int(input())
a=[]
l=[]
for i in range(n):
    x,y=map(int,input().split())
    a.append(x)
    l.append(y)
ans=0
a.sort()
l.sort()
i=j=0
cc=0
while i<n and j<n:
    if a[i]<=l[j]:
        cc+=1
        i+=1
    else:
        j+=1
        cc-=1
    ans=max(ans,cc)
print(ans)