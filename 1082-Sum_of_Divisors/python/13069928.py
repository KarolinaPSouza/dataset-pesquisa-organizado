import time

def suma_de_divisores(n):
    MOD=1000000007
    total=0
    i=1
    while i<=n:
        k=n//i
        j=n//k
        suma=((j-i+1)*(i+j)//2)
        total+=(k*suma)
        total%=MOD
        i=(j+1)
    return total

'''
for prueba in [20, 10**3, 10**4, 10**6, 10**8, 10**12]:
    start = time.time()
    resultado = suma_de_divisores(prueba)
    end = time.time()
    print(f"n = {prueba}, resultado = {resultado}, tiempo = {end - start:6f} segundos")
'''

n = int(input())
print(suma_de_divisores(n))