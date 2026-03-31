def main():
    from sys import stdin
    e = stdin.readline

    n = int(e())
    s, t = [None] * n, [None] * n
    for i in range(n):
        s[i], t[i] = map(int, e().split())
    s.sort()
    t.sort()
    i = j = ans = cur = 0
    while i < n and j < n:
        if s[i] < t[j]:
            i = i + 1
            cur = cur + 1
            if cur > ans: ans = cur
        else:
            j = j + 1
            cur = cur - 1
    print(ans)
main()