def sr(li,ls):
    ls-=1
    return ((ls-li+1)*(ls+li)//2)
def solve():
    n=int(input())
    i=1
    sum=0
    ls=n
    li=n
    while i*i<=n:
        div=n//i
        sum+=i*div
        ls=li
        li=div+1
        sri=sr(li,ls)*(i-1)
        sum+=sri
        i+=1
    if(i-1)!=div:
        div=n//i
        sum+=i*div
    return sum



print(solve()%1000000007)