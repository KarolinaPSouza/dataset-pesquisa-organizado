from bisect import*
I=input
R=range
S=sorted
P={}
for _ in R(int(I())):
 a,b,p=map(int,I().split())
 P[b][a]=max(P.setdefault(b,{}).get(a,0),p)

D=S(P)
A=[0]
for i in R(len(D)):
 p=P[D[i]]
 A+=max(A[-1],max(A[bisect_left(D,s)]+p[s] for s in S(p))),
print(A[-1])