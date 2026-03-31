n = int(input())
a,b = [],[]
for i in range(n):
    x,y = list(map(int,input().split()))
    a.append(x)
    b.append(y)
a.sort()
b.sort()
curr,res = 0,0
i,j = 0,0
while i<n and j<n:
    if a[i]<b[j]:
        curr+=1
        i+=1
    else:
        curr-=1
        j+=1
    res = max(res,curr)
print(res)

