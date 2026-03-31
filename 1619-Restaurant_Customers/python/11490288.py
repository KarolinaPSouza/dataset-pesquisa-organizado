t=int(input())
a,d=[],[]
for i in range(t):
    temp=list(map(int,input().split()))
    a.append(temp[0])
    d.append(temp[1])
ans=1
cur=0
a.sort()
d.sort()
j,k=0,0
while j<t and k<t:
    if a[j]<=d[k]:
        cur+=1
        j+=1
    else:
        k+=1
        cur-=1
    ans=max(ans,cur)
print(ans)