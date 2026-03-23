#!/usr/bin/env python3

n = int(input())
s,d,q = 0,1,n

while (d < q):
    s+=q*(q+1+2*d)//2
    d+=1
    q=n//d

r = s-d*(d-1)//2*d+q*(q+1)//2;
print(r%1000000007);