import sys
import bisect
 
 
it = map(int, sys.stdin.buffer.read().split())
 
 
def solve() -> str:
    n, k = next(it), next(it)
    movies = []
    for _ in range(n):
        movies.append((next(it), next(it)))
 
    movies.sort(key=lambda x: x[1])
 
    unique_ends = set()
    unique_ends.add(0)
    for _, e in movies:
        unique_ends.add(e)
 
    sorted_ends = sorted(unique_ends)
    m = len(sorted_ends)
 
    time_to_rank = {t: i for i, t in enumerate(sorted_ends)}
 
    size = 1
    while size < m:
        size *= 2
 
    tree = [-1] * (2 * size)
 
    counts = [0] * m
 
    def update(idx, val):
        p = idx + size
        tree[p] = val
        while p > 1:
            tree[p >> 1] = max(tree[p], tree[p ^ 1])
            p >>= 1
 
    def query_max(limit_idx):
        res = -1
        l = size
        r = limit_idx + size + 1
 
        while l < r:
            if l & 1:
                res = max(res, tree[l])
                l += 1
            if r & 1:
                r -= 1
                res = max(res, tree[r])
            l >>= 1
            r >>= 1
        return res
 
    counts[0] = k
    update(0, 0)
 
    watched_count = 0
 
    for start, end in movies:
        limit_rank = bisect.bisect_right(sorted_ends, start) - 1
 
        if limit_rank < 0:
            continue
 
        best_rank = query_max(limit_rank)
 
        if best_rank != -1:
            watched_count += 1
 
            counts[best_rank] -= 1
            if counts[best_rank] == 0:
                update(best_rank, -1)
 
            new_rank = time_to_rank[end]
            if counts[new_rank] == 0:
                update(new_rank, new_rank)
            counts[new_rank] += 1
 
    return str(watched_count)
 
 
sys.stdout.write(solve())
# out = [solve() for _ in range(next(it))]
# sys.stdout.write("\n".join(out))