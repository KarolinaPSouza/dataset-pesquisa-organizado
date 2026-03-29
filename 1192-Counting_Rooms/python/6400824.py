I=input
n,m=map(int,I().split())
def F(x):
 while K[x]-x:K[x]=x=K[K[x]]
 return x
G=[i=="."for _ in" "*n for i in I()]
D=*K,=range(n*m)
for k in D:
 if k%m*G[k]*G[k-1]:K[F(k)]=k-1
 if k//m*G[k]*G[k-m]:K[F(k)]=k-m
print(len({F(k)for k in D if G[k]}))