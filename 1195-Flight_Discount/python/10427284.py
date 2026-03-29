from heapq import heappop, heappush

def dijkstra(adj, ini, fim, n):
    dist_sem_disc = [float('inf')] * (n + 1)
    dist_disc = [float('inf')] * (n + 1)

    dist_sem_disc[ini] = 0

    minheap = [(0, ini, 0)]

    while minheap:
        custo, v, cupom = heappop(minheap)

        if v == fim:
            return min(dist_sem_disc[fim], dist_disc[fim])

        # pula se custo n for mais benefico
        if cupom == 0 and custo > dist_sem_disc[v]:
            continue
        if cupom == 1 and custo > dist_disc[v]:
            continue

        for u, peso in adj[v]:
            if not cupom:
                custo_sem_disc = custo + peso
                if custo_sem_disc < dist_sem_disc[u]:
                    dist_sem_disc[u] = custo_sem_disc
                    heappush(minheap, (custo_sem_disc, u, 0))

                custo_disc = custo + peso // 2
                if custo_disc < dist_disc[u]:
                    dist_disc[u] = custo_disc
                    heappush(minheap, (custo_disc, u, 1))

            custo_novo = custo + peso
            if custo_novo < dist_disc[u]:
                dist_disc[u] = custo_novo
                heappush(minheap, (custo_novo, u, 1))

def exerJ():
    n, m = map(int, input().split())

    adj = [[] for _ in range(n+1)]

    for i in range(m):
        a, b, c = map(int, input().split())
        adj[a].append((b, c))

    min_cost = dijkstra(adj, 1, n, n)
    print(min_cost)

exerJ()

#creditos pra ideia do algoritmo de erastosthenes sieve: https://codeforces.com/blog/entry/22229
def divisores(max):
    div = [0] * (max+1)
    for i in range(1, max+1):
        for j in range(i, max+1, i):
            div[j] += 1
    return div

def exerC():
    n = int(input())
    entradas = []
    for _ in range(n):
        x = int(input())
        entradas.append(x)
    res = divisores(max(entradas))

    for x in entradas:
        print(res[x])
#exerC()




