n = int ( input ( ) )

mod = 1000000007

def ap ( a , b ):

    n = b - a + 1

    return ( ( a + b )* n ) // 2


def cieli ( a ) :

    if int ( a ) == a :

        return int ( a )

    return int(a) + 1

ans = 0
ans += 0


for i in range ( 1 , cieli ( n**0.5 ) + 1 ) :

    ans += ( i * (n//i) ) % mod
    ans %= mod

a = cieli ( n**0.5 ) + 1
i = (n//i) 

while ( a < n ) :

    b = n//i

    ans += ( i * ap ( a , b ) ) % mod
    ans %= mod

    a = b + 1

    i -= 1

if a == n :
    ans += n%mod

ans %= mod

print(ans)