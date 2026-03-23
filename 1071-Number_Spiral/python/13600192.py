t=int(input())
anslst=[]
for i in range (t):
    lst = list(map(int, input().split()))
    n=max(lst)
    ans=n**2-n+1
    y=ans-lst[0]
    x=ans-lst[1]
    if n%2==0:
        ans=ans-y+x
    else:
        ans=ans+y-x
    anslst.append(ans)
for i in anslst:
    print(i)