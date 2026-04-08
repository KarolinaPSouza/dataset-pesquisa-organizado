from bisect import bisect_left, bisect_right

def problema_a():
    # Leitura de n e x
    try:
        n, x = map(int, input().split())
    except (ValueError, EOFError):
        print("Entrada para n e x inválida ou não fornecida.")
        return

    # Leitura do array
    try:
        array = list(map(int, input().split()))
    except (ValueError, EOFError):
        print("Entrada do array inválida ou não fornecida.")
        return

    # Divide o array em duas metades para meet-in-the-middle
    meio = n // 2
    primeira_metade = array[:meio]
    segunda_metade = array[meio:]

    # Gera todas as somas possíveis de forma eficiente por expansão
    def gerar_somas(vetor):
        somas = [0]
        for v in vetor:
            base = somas[:]  # snapshot
            somas += [s + v for s in base]
        return somas

    somas_primeira = gerar_somas(primeira_metade)
    somas_segunda = gerar_somas(segunda_metade)
    somas_primeira.sort()
    somas_segunda.sort()

    # Conta pares com dois ponteiros, agregando duplicatas
    i = 0
    j = len(somas_segunda) - 1
    resultado = 0
    while i < len(somas_primeira) and j >= 0:
        s = somas_primeira[i] + somas_segunda[j]
        if s == x:
            v1 = somas_primeira[i]
            v2 = somas_segunda[j]
            c1 = 0
            while i < len(somas_primeira) and somas_primeira[i] == v1:
                c1 += 1
                i += 1
            c2 = 0
            while j >= 0 and somas_segunda[j] == v2:
                c2 += 1
                j -= 1
            resultado += c1 * c2
        elif s < x:
            i += 1
        else:
            j -= 1

    print(resultado)

problema_a()
