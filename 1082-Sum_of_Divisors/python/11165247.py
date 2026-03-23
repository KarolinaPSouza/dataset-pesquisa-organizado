import math

num_ = int(input().strip())
base_ = 1000000007


def solve(num, base):
    def sigma(numm):
        return (numm * (numm + 1) // 2) % base

    res = ((num * (num + 1)) // 2) % base
    res += (num - 1 % base)
    sq_int = int(math.sqrt(num))
    for i in range(2, 1 + sq_int):
        d = num // i
        res = (res + (i * (d - i + 1))) % base
        sig = (sigma(d) - sigma(i)) % base
        res = (res + sig) % base
    return res


print(solve(num_, base_))