'''
Sum of Divisors
https://cses.fi/problemset/task/1082
 оптимальная
 '''
import sys, time

modulo = 10**9+7
st = time.perf_counter()

def modpow(x,exp):
    if exp == 0:
        return 1
    res = modpow(x, exp//2)
    if exp % 2 == 0:
        return (res * res) % modulo
    else:
        return (((res * res) % modulo) * x) % modulo

n = int(input())
s = 0
i = 1
t2 = modpow(2,modulo-2)
while i <= n + 1:
    res = n//i
    if res == 0:
        break
    newi = n//res+1
    count = newi-i

    t = ((2*i + count-1)*count) % modulo
    t = (t * t2) % modulo
    s = (s + t*res) % modulo
    #print(f'i = {i:12d}, newi = {newi:12d}, res = {res:12d} , t = {t:12d}, s = {s:12d}')    
    i = newi

print(s)





