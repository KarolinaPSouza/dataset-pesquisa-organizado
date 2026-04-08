from  sys import  stdin
input=stdin.readline
def f(n,k,a):
 t=n
 n=n//2
 h1=a[:n]
 h2=a[n:]
 mask=0
 d={}
 while mask<(1<<n):
  ts=0
  tm=mask
  for i in range(n):
   if ((tm)&1):
    ts+=h1[i]
   tm>>=1
   if tm==0:
    break
  d[ts]=d.get(ts,0)+1
  mask+=1
 mask=0
 ans=0
 n2=t-n
 while mask<(1<<n2):
  ts=0
  tm=mask
  for i in range(n2):
   if  (tm&1):
    ts+=h2[i]
   if tm==0:
    break
   tm>>=1
  ans+=d.get(k-ts,0)
  mask+=1
 return ans

n,k=map(int,input().strip().split())
lst=list(map(int,input().strip().split()))
print(f(n,k,lst))