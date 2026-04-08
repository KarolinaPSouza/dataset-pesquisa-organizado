import sys
from itertools import combinations, chain

def retorna_conjuntos(lista):
    return chain.from_iterable(combinations(lista,r) for r in range(len(lista)+1))

def divide_subset(n, arr, target):
    size = len(arr)
    mid = size // 2
    div1 = arr[:mid]
    div2 = arr[mid:]

    div1_conjunto = retorna_conjuntos(div1)
    div2_conjunto = retorna_conjuntos(div2)

    mapa_somas = dict()

    total = 0

    for conjunto in div1_conjunto:
        soma = 0
        for numero in conjunto:
            soma += numero
        if soma not in mapa_somas:
            mapa_somas[soma] = 1
        else:
            mapa_somas[soma] += 1   

    for conjunto in div2_conjunto:
        soma = 0
        for numero in conjunto:
            soma += numero
        complemento = target-soma
        if complemento in mapa_somas:
            total += mapa_somas[complemento]

    return total

def main():
    n, target = map(int, sys.stdin.readline().split())
    arr = list(map(int, sys.stdin.readline().split()))
    print (divide_subset(n, arr, target))
main()