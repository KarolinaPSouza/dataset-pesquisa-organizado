

mod=1000000007

def power(x,y,p):

    res=1

    x=x%p

    while y>0:

        if (y%2==1):

            res=(res*x)%p
        y=y//2
        x= (x * x) % p


    return res

def modinv(x):

    return power(x,mod-2,mod)





def sum(n):
    return (n * (n + 1) // 2) % mod


def divisorSum(n):

    i=1

    ans=0

    while( i<=n):

        q=n//i

        nex=n//q

        q%=mod

        ans+=(((sum(nex)-sum(i-1)+mod)%mod) * q)%mod
        ans%=mod

        i=nex+1


    ans=ans%mod



    return ans


m=int(input())
print(divisorSum(m))  




