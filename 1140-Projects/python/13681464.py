import sys,bisect
input=sys.stdin.readline
n=int(input())
L=[]
e=[]
for _ in range(n):
    a,b,p=map(int,input().split())
    e.append((a,b,p))
    L.append(a)
    L.append(b)
fmax=lambda x,y:x if x>y else y
e.sort(key=lambda x:x[0])
L.sort()
mx=0
v=[0]*(2*n)
p=0
ans=0
for i in range(n):
    while p<2*n and L[p]<e[i][0]:
        mx=fmax(mx,v[p])
        p+=1
    res=mx+e[i][2]
    l=bisect.bisect_left(L,e[i][1])
    v[l]=fmax(v[l],res)
    ans=fmax(ans,res)
print(ans)