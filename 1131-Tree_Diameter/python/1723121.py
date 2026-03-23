# from queue import Queue
from collections import deque
import sys

contents = [tuple(map(int, s.split(' ')))
            for s in map(str.strip, sys.stdin.readlines())]

N = contents[0][0]
edges = [[] for _ in range(N + 1)]
for x, y in contents[1:]:
    edges[x].append(y)
    edges[y].append(x)


def farthest_from(x):
    q = Queue()
    q.put((x, None, 0))
    while not q.empty():
        x, p, l = q.get()
        # print(x, p, l)
        for y in edges[x]:
            if y != p:
                q.put((y, x, l + 1))
    return x, l

def farthest_from(x):
    q = deque()
    q.append((x, None, 0))
    while q:
        x, p, l = q.popleft()
        # print(x, p, l)
        for y in edges[x]:
            if y != p:
                q.append((y, x, l + 1))
    return x, l

print(farthest_from(farthest_from(1)[0])[1])