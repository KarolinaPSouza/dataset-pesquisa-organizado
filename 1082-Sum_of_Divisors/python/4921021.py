from sys import stdin
input = stdin.readline
#google = lambda : print("Case #%d: "%(T + 1) , end = '')

inp = lambda : list(map(int,input().split()))

mod = (10 ** 9) + 7


def answer():

    i , ans = 1 , 0
    while(i * i <= n):

        l = n // (i + 1)
        r = n // i

        ans += i * ((r * (r + 1)) // 2 - (l * (l + 1)) // 2)
        if(i != (n // i)):ans += i * (n // i)

        ans %= mod

        i += 1

    return ans


for T in range(1):

    n = int(input())

    print(answer())