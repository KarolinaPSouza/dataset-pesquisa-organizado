I=lambda:map(int,input().split())
P=print
n,m=I()
E=[(*I(),)for _ in" "*m]
D=[-1e13]*-~n
D[1]=0
R={}
for _ in" "*n:
 c=0
 for a,b,w in E:
  w+=D[a]
  if D[b]>w:
   c=b
   D[b]=w
   R[b]=a
if c:
 K=[c]
 for k in K:
  if k in K[:-1]:
   P("YES",*K[K.index(k):][::-1])
   exit()
  K+=R[k],
P("NO")