from bisect import bisect_left,bisect_right
n=int(input());L,R=[],[];ans=0
for i in range(n):
    l,r=map(int,input().split())
    L.append(l);R.append(r)
L.sort();R.sort()
for i in range(n):
    p=bisect_left(R,L[i])
    c=i+1-p
    ans=max(ans,c)
for i in range(n):
    p=bisect_right(L,R[i])-1
    c=p-i+1
    ans=max(ans,c)
print(ans)