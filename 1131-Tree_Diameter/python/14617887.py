from collections import deque

n = int(input())

if n == 1:
    print(0)
else:

    tree = {i:[] for i in range(1, n +1)}

    for _ in range(n - 1):
        a,b = map(int,input().split())
        tree[a].append(b)
        tree[b].append(a)

    def bfs(inicio,tree):

        fila = deque([(inicio,0)])
        visitados = set([inicio])
        max_distancia, no_mais_distante = 0, inicio

        while fila:

            no, dist = fila.popleft()
            if dist > max_distancia:
                max_distancia, no_mais_distante = dist, no

            for vizinho in tree[no]:
                if vizinho not in visitados:
                    visitados.add(vizinho)
                    fila.append((vizinho, dist + 1))

        return max_distancia, no_mais_distante

    _, ponto1 = bfs(1,tree)
    diametro , _ = bfs(ponto1,tree)

    print(diametro)