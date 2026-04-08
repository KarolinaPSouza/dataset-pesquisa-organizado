from collections import Counter
import bisect
def obtener_sumas(subconjunto):
    sumas = [0]
    for numero in subconjunto:
        sumas_nuevas = [suma + numero for suma in sumas]
        sumas.extend(sumas_nuevas)
    return sumas
def contar_subconjuntos(n, x, arreglo):
    mitad1 = arreglo[:n//2]
    mitad2 = arreglo[n//2:]
    sumas_mitad1 = obtener_sumas(mitad1)
    sumas_mitad2 = obtener_sumas(mitad2)
    counter_mitad2 = Counter(sumas_mitad2)
    contador = 0
    for suma in sumas_mitad1:
        complemento = x - suma
        contador += counter_mitad2[complemento]
    return contador
n, x = map(int, input().split())
arreglo = list(map(int, input().split()))
print(contar_subconjuntos(n, x, arreglo))