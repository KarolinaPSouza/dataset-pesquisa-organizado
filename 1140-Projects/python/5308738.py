from sys import stdin
input = stdin.buffer.readline

def main():
    n = int(input())
    projects = []
    comp = {}
    a, b, p = [], [], []
    date = set()
    for _ in range(n):
        ai, bi, pi = map(int,input().split())
        a.append(ai); b.append(bi + 1); p.append(pi)
        date.add(ai); date.add(bi + 1)
    comp = {v:i for i,v in enumerate(sorted(date))}
    dp = [0] * (2 * n + 1)
    order = sorted(range(n),key=lambda i:b[i])
    curr_end = 0
    for i in range(1, 2 * n + 1):
        dp[i] = dp[i - 1]
        while curr_end != n and comp[b[order[curr_end]]] == i:
            dp[i] = max(dp[i], dp[comp[a[order[curr_end]]]] + p[order[curr_end]])
            curr_end += 1

    print(dp[2 * n])

main()