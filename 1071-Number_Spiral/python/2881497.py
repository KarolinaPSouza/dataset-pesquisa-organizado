tt=int(input())
for _ in range(tt):
    r,c=[int(_) for _ in input().split()]
    x=max(c,r)
    start=x*x
    ans=0
    if c>r:
        if c%2!=0:
            ans+=c*c 
            ans=ans-r+1 
        else:
            x=c-1
            ans+=(x*x)+1 
            ans=ans+r-1 
    elif r>c:
        if r%2==0:
            ans+=r*r 
            ans=ans-c+1 
        else:
            x=r-1
            ans=x*x 
            ans=ans+c
    else:
        ans=c*c 
        ans=ans-r +1
    # ans=start
    print(ans)