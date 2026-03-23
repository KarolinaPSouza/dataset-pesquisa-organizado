mod=10**9+7
while True:
    n=int(input())

    e=n
    d=1
    ans=[]
    while d<=n:
        ans.append(n//d)
        d += (1+(n-ans[-1]*d)//ans[-1])
    ee=0
    for i in ans:
        a = n//i
        b = n//(i+1)
        a = (a*(a+1))//2
        b = (b*(b+1))//2
        ee=(ee+(a-b)*i)%mod
    print(ee)
    break


