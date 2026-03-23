from math import isqrt

n=int(input())
s=0
mod=10**9+7
def sm(f):
  if f%2==0:
    return (((f//2)%mod)*((f+1)%mod))%mod
  return (((f%mod)*((f+1)//2)%mod))%mod
t=isqrt(n)
for i in range(1,t+1):

  if i==n//i:
    s+=((n//i)*i)
    s%=mod
  else:

    s+=((n//i)*i)
    s%=mod
    s+=(((sm(n//i)+mod-sm(n//(i+1)))%mod)*i)
    #print(sm(n//i),sm(n//(i+1)))
    s%=mod

print(s)