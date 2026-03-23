import math

M = 10**9 + 7

def sum_all_divisors(num):
    sum = 0
    for i in range(1, int(math.sqrt(num)) + 1):
        t1 = i * (num // i - i + 1)
        t2 = (((num // i) * (num // i + 1)) // 2) - ((i * (i + 1)) // 2)
        sum += (t1 + t2) % M
    return sum % M

n = int(input()) 
sum = sum_all_divisors(n)
print(sum) 