n = int(input())
x = 0
for i in range(1,int(n**0.5+1)):
    x += n // i*i
for j in range(n//int(n**0.5)-1,0,-1):
    k = n//j
    x += j*(i+1+k)*(k-i)//2
    i = k
print(x % (10**9+7))