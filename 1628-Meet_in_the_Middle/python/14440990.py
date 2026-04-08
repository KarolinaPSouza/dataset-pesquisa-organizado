def gerarSomas(arr):
    somas = [0]
    for num in arr:
        novasSomas = [s + num for s in somas]
        somas.extend(novasSomas)
    return somas

n, x = map(int, input().split())
t = list(map(int, input().split()))

meio = n // 2
metade1 = t[:meio]
metade2 = t[meio:]

somasA = gerarSomas(metade1)
somasB = gerarSomas(metade2)

somasA.sort()
somasB.sort()

contador = 0
esq = 0
dir = len(somasB) - 1

while esq < len(somasA) and dir >= 0:
    somaAtual = somasA[esq] + somasB[dir]

    if somaAtual == x:
        valorA = somasA[esq]
        contagemA = 0
        while esq < len(somasA) and somasA[esq] == valorA:
            contagemA += 1
            esq += 1

        valorB = somasB[dir]
        contagemB = 0
        while dir >= 0 and somasB[dir] == valorB:
            contagemB += 1
            dir -= 1

        contador += contagemA * contagemB

    elif somaAtual < x:
        esq += 1
    else:
        dir -= 1

print(contador)