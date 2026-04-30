def main():
    from sys import stdin
    from bisect import bisect_right
    e = stdin.readline
 
    def tuple(it):
        a, b = it
        return b << 32 | a
 
    n, k = map(int, e().split())
    l = [tuple(map(int, e().split())) for _ in range(n)]
    l.sort()
    ans = 0
    end = []
    nxt = list(range(n + 1))
    for v in l:
        s, t = v & 0xffff_ffff, v >> 32
        i = bisect_right(end, s)
        while nxt[i] != i:
            nxt[i] = i = nxt[nxt[i]]
 
        if not i:
            if k:
                end.append(t)
                k -= 1
                ans += 1
            continue
 
        nxt[i] = i - 1
        end.append(t)
        ans += 1
    print(ans)
main()