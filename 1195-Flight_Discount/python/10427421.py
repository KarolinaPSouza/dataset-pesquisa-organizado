from heapq import heappop, heappush

def dijkstraCupom(adj, ini, fim):
    custos_sem_disc = [float('inf')] * (fim+1)
    custos_disc = [float('inf')] * (fim+1)

    custos_sem_disc[ini] = 0

    minheap = [(0, ini, 0)]

    while minheap:
        custo, v, cupom = heappop(minheap)

        if v == fim:
            return min(custos_sem_disc[fim], custos_disc[fim])

        if cupom == 0 and custo > custos_sem_disc[v]:
            continue
        if cupom == 1 and custo > custos_disc[v]:
            continue

        for u, peso in adj[v]:
            if not cupom:
                novo = custo+peso
                if novo < custos_sem_disc[u]:
                    custos_sem_disc[u] = novo
                    heappush(minheap, (novo, u, 0))

                novo = custo + peso//2
                if novo < custos_disc[u]:
                    custos_disc[u] = novo
                    heappush(minheap, (novo, u, 1))

            novo = custo+peso
            if novo < custos_disc[u]:
                custos_disc[u] = novo
                heappush(minheap, (novo, u, 1))

def exerJ():
    n, m = map(int, input().split())

    adj = [[] for _ in range(n+1)]

    for _ in range(m):
        a, b, c = map(int, input().split())
        adj[a].append((b, c))

    custo = dijkstraCupom(adj, 1, n)
    print(custo)

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




