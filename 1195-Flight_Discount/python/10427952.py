from heapq import heappop, heappush

def dijkstraCupom(adj, ini, fim):
    custos_sem_disc = [float('inf')] * (fim + 1)
    custos_disc = [float('inf')] * (fim + 1)

    custos_sem_disc[ini] = 0

    minheap = [(0, ini, 0)]  # (current cost, current node, discount used flag)

    while minheap:
        custo, v, cupom = heappop(minheap)

        # Early exit if we reach the destination
        if v == fim:
            return min(custos_sem_disc[fim], custos_disc[fim])

        # Skip if this path is not optimal anymore
        if cupom == 0 and custo > custos_sem_disc[v]:
            continue
        if cupom == 1 and custo > custos_disc[v]:
            continue

        # Process all neighbors
        for u, peso in adj[v]:
            # Case 1: No discount used, try both normal and discounted paths
            if cupom == 0:
                # Normal cost without discount
                novo = custo + peso
                if novo < custos_sem_disc[u]:
                    custos_sem_disc[u] = novo
                    heappush(minheap, (novo, u, 0))

                # Discounted cost, use discount on this edge
                novo = custo + peso // 2
                if novo < custos_disc[u]:
                    custos_disc[u] = novo
                    heappush(minheap, (novo, u, 1))

            # Case 2: Discount already used, add normal cost
            else:
                novo = custo + peso
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



from collections import defaultdict

primes = []
_sieve_size = 0
def sieve(upperbound):
    global _sieve_size, primes
    _sieve_size = upperbound + 1
    bs = [True] * _sieve_size
    bs[0] = bs[1] = False
    for i in range(2, _sieve_size):
        if bs[i]:
            for j in range(i * i, _sieve_size, i):
                bs[j] = False
            primes.append(i)

def prime_factors(N):
    factor_pow = defaultdict(int)
    PF_idx = 0
    PF = primes[PF_idx]
    while N != 1 and PF * PF <= N:
        p = 0
        while N % PF == 0:
            N //= PF
            p += 1
        if p > 0:
            factor_pow[PF] = p
        PF_idx += 1
        if PF_idx < len(primes):
            PF = primes[PF_idx]
        else:
            break

    if N != 1:
        factor_pow[N] = 1

    return factor_pow

def exerA():
    sieve(10000000)

    while True:
        try:
            n = int(input())
            if n == 0:
                break

            factors = prime_factors(n)
            result = ' '.join(f"{factor}^{exp}" for factor, exp in factors.items())
            print(result)
        except EOFError:
            break



