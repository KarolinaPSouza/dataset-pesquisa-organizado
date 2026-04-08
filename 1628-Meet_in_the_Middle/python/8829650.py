from collections import Counter

def f(a, z = 0):
    q = [0]
    for v in a:
        for i in range(len(q)):
            q.append(v + q[i])
            if z:
                ans[0] += c[x - q[-1]]
    return q

n, x = map(int, input().split())
t = [*map(int, input().split())]
n //= 2
c = Counter(f(t[:n]))
ans = [c[x]]
f(t[n:], 1)
print(ans[0])