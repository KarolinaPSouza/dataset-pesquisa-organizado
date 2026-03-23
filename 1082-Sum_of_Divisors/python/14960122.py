T = lambda x: x*(x+1)//2
def getDivisorSums(n):
    total = 0
    for i in range(1, int(n**0.5) + 1):
        total += (i * (n // i))%(10**9 + 7)
        if n//i != i: total += ((T(n // i) - T(n // (i + 1)))*i)%(10**9 + 7)
    return total%(10**9 + 7)

print(getDivisorSums(int(input())))