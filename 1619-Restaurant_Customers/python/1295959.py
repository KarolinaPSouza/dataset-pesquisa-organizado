n=int(input())
a=[]
l=[]
for i in range(n):
    x,y=map(int,input().split())
    a.append(x)
    l.append(y)
a.sort()
l.sort()
ma=0
cu=0
i,j=0,0
while(i<n and j<n):
    if a[i]<l[j]:
        cu+=1
        i+=1
    else:
        cu-=1
        j+=1
    if cu>ma:
        ma=cu
print(ma)        
