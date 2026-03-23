import sys, bisect
input = sys.stdin.readline

def solve():
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    q = list(map(int, input().split()))

    uniq = sorted(set(a))
    idx = {v:i+1 for i,v in enumerate(uniq)}  # 1-based
    U = len(uniq)

    from collections import Counter
    cnt = [0]*(U+1)
    c = Counter(a)
    for v, t in c.items():
        cnt[idx[v]] = t

    parent = list(range(U+1))  # 0..U, 0 là “hết”
    def find(x):
        while x > 0 and parent[x] != x:
            parent[x] = parent[parent[x]]
            x = parent[x]
        return x

    out = []
    for x in q:
        pos = bisect.bisect_right(uniq, x)   # 0..U
        if pos == 0:
            out.append("-1"); continue
        i = find(pos)                         # chỉ số ≤ pos còn vé
        if i == 0:
            out.append("-1"); continue
        cnt[i] -= 1
        out.append(str(uniq[i-1]))
        if cnt[i] == 0:
            parent[i] = find(i-1)             # nhảy lùi
    print("\n".join(out))

if __name__ == "__main__":
    solve()