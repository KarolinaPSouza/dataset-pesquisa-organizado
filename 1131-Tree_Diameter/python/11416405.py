from collections import defaultdict, deque

def fa_atmeroje(n, elek):
    # Szomszédsági lista építése
    szomszedsag = defaultdict(list)
    for a, b in elek:
        szomszedsag[a].append(b)
        szomszedsag[b].append(a)

    def bfs(kezdopont):
        tavolsag = [-1] * (n + 1)
        tavolsag[kezdopont] = 0
        q = deque([kezdopont])
        legtavolabbi_csucs = kezdopont
        while q:
            jelenlegi = q.popleft()
            for szomszed in szomszedsag[jelenlegi]:
                if tavolsag[szomszed] == -1:
                    tavolsag[szomszed] = tavolsag[jelenlegi] + 1
                    q.append(szomszed)
                    if tavolsag[szomszed] > tavolsag[legtavolabbi_csucs]:
                        legtavolabbi_csucs = szomszed
        return legtavolabbi_csucs, tavolsag[legtavolabbi_csucs]

    # Első BFS, hogy találjunk egy levelet
    csucs1, _ = bfs(1)

    # Második BFS a fa átmérőjének meghatározásához
    _, atmero = bfs(csucs1)

    return atmero

# Bemenet beolvasása
n = int(input())
elek = [tuple(map(int, input().split())) for _ in range(n - 1)]

# Fa átmérőjének meghatározása
print(fa_atmeroje(n, elek))