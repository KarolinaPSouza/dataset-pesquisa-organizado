n,s,i,m=int(input()),0,1,10**9+7
while i*i<=n:
    x=n//i
    s+=(x-i)*(x+i+1)//2+i*(x-i+1)
    s%=m
    i+=1
print(s)