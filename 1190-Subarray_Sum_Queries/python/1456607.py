import sys
I=lambda:map(int,sys.stdin.readline().split())
M=max
n,m=I()
*X,=I()
L,S,E,A=[2**19*[0]for _ in"    "]
def U():
 i=j+2**18-1
 L[i]=S[i]=E[i]=M(0,v)
 A[i]=v
 while i:
  i//=2
  a=i*2
  b=a+1
  L[i]=M(L[a],L[b],E[a]+S[b])
  S[i]=M(S[a],A[a]+S[b])
  E[i]=M(E[b],E[a]+A[b])
  A[i]=A[a]+A[b]
j=1
for v in X:
 U()
 j+=1
for _ in" "*m:
 j,v=I()
 U()
 print(L[1])