def encontrar_ciclo_negativo(n, aristas):
    INF = float('inf')
    dist = [0] * (n + 1)
    padre = [-1] * (n + 1)
    x = -1

    for i in range(n):
        x = -1
        for a, b, c in aristas:
            if dist[b] > dist[a] + c:
                dist[b] = dist[a] + c
                padre[b] = a
                x = b

    if x == -1:
        print("NO")
        return

    for _ in range(n):
        x = padre[x]

    ciclo = []
    v = x
    while True:
        ciclo.append(v)
        if v == x and len(ciclo) > 1:
            break
        v = padre[v]

    ciclo.reverse()
    print("YES")
    print(" ".join(map(str, ciclo)))

n, m = map(int, input().split())
aristas = [tuple(map(int, input().split())) for _ in range(m)]

encontrar_ciclo_negativo(n, aristas)