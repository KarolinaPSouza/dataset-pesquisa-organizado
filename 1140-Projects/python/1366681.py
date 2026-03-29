from bisect import*
I=input
S=sorted
P={}
for _ in[0]*int(I()):
 a,b,p=map(int,I().split())
 P[b][a]=max(P.setdefault(b,{}).get(a,0),p)
D=S(P)
A=[0]
for d in D:
 p=P[d]
 A+=max([A[bisect_left(D,s)]+p[s]for s in S(p)]+A[-1:]),
print(A[-1])