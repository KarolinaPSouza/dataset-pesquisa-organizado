from math import isqrt

MOD=10**9 + 7

n=int(input())

def sigma(x):
    global MOD
    return ((x*(x+1))//2)%MOD

i=2
val=n%MOD
r=n

a=isqrt(n)

while i<=a:

    val=(val+((i-1)*(sigma(r)-sigma(n//i)))%MOD)%MOD
    val=(val+((n//i)*i)%MOD)%MOD
    r=n//i
    i+=1

if a!=n//a:
    val=(val+(a*(sigma(r)-sigma(a)))%MOD)%MOD

print(val)