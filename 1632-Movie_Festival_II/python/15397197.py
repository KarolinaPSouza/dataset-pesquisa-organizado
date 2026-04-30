import sys
import bisect
 
 
it = map(int, sys.stdin.buffer.read().split())
 
 
def solve() -> str:
    n, k = next(it), next(it)
    movies = []
    for _ in range(n):
        movies.append((next(it), next(it)))
 
    movies.sort(key=lambda x: x[1])
 
    seen = []
    dsu = list(range(n + 1))
 
    watched_count = members_active = 0
 
    for start, end in movies:
        j = bisect.bisect_right(seen, start)
 
        while dsu[j] != j:
            dsu[j] = dsu[dsu[j]]
            j = dsu[j]
 
        if j > 0:
            dsu[j] = j - 1
            seen.append(end)
            watched_count += 1
        else:
            if members_active < k:
                members_active += 1
                seen.append(end)
                watched_count += 1
 
    return str(watched_count)
 
 
sys.stdout.write(solve())
# out = [solve() for _ in range(next(it))]
# sys.stdout.write("\n".join(out))