import sys
import random
from collections import defaultdict
from types import GeneratorType

MOD = 10**9 + 7
RANDOM = random.randrange(2**62)


def bootstrap(f, stack=[]):
    def wrappedfunc(*args, **kwargs):
        if stack:
            return f(*args, **kwargs)
        else:
            to = f(*args, **kwargs)
            while True:
                if isinstance(to, GeneratorType):
                    stack.append(to)
                    to = next(to)
                else:
                    stack.pop()
                    if not stack:
                        break
                    to = stack[-1].send(to)
            return to
    return wrappedfunc

def solve():
    n = int(sys.stdin.readline().strip())
    d = defaultdict(list)
    for _ in range(n - 1):
        u, v = map(int, sys.stdin.readline().split())
        d[u].append(v)
        d[v].append(u)

    fans = [0]

    @bootstrap
    def rec(cur, prev):
        L = [0, 0]
        for i in d[cur]:
            if i == prev:
                continue
            L.append((yield rec(i, cur)))
        L.sort()
        fans[0] = max(fans[0], L[-1] + L[-2])
        yield 1 + L[-1]

    rec(1, -1)
    print(fans[0])

solve()