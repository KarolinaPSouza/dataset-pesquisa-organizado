from bisect import*
I=lambda:map(int,input().split())
I()
H=-1,*sorted(I())
*G,=range(4**9)
for t in I():
 i=bisect(H,t)
 while i-G[i]:G[i]=i=G[G[i]]
 print(H[i-1])
 G[i]-=i>1