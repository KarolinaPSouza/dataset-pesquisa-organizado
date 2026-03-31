n=int(input())
arr=[]
dep=[]
for _ in range(n):
    a,b=map(int,input().split())
    arr.append(a)
    dep.append(b)
arr.sort()
dep.sort()
i,j,c,m=0,0,0,0
while i<n and j<n:
    if arr[i]<=dep[j]:
        c+=1
        i+=1
    else:
        c-=1
        j+=1
    m=max(m,c)
print(m)