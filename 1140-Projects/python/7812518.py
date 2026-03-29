import sys
input=sys.stdin.readline
import bisect
n=int(input())
a=[]
for _ in range(n):
    s,e,v=map(int,input().split())
    a.append((s,e,v))
a=sorted(a,key=lambda x:(x[1]))
dp=[a[0][1]]
p=[a[0][2]]
ans=a[0][2]
for i in range(1,n):
    idx=bisect.bisect_left(dp,a[i][0])
    if idx==0:
        if p[-1]<a[i][2]:
            dp.append(a[i][1])
            p.append(a[i][2])
    else:
        if p[-1]<p[idx-1]+a[i][2]:
            dp.append(a[i][1])
            p.append(p[idx-1]+a[i][2])
    ans=max(ans,p[-1])
#print(dp)
sys.stdout.write(str(ans)+'\n')