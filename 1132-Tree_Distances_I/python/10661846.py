#!/usr/bin/env python
import os
import sys
from io import BytesIO, IOBase
from types import GeneratorType
from collections import deque


def main():
    n = int(input())
    adj = [[] for _ in range(n)]
    for _ in range(n - 1):
        u, v = map(int, input().split())
        adj[u - 1].append(v - 1)
        adj[v - 1].append(u - 1)

    max_height = [[0, 0] for _ in range(n)]
    level = [0] * n
    max_dist_up = [0] * n
    vis = [False] * n
    stack = [(0, 0, -1)]
    while stack:
        curr, lvl, prev = stack[-1]
        if vis[curr]:
            first_max, second_max = lvl, lvl
            for nex in adj[curr]:
                if nex != prev:
                    f1 = max_height[nex][0]
                    if f1 >= first_max:
                        second_max = first_max
                        first_max = f1
                    elif f1 >= second_max:
                        second_max = f1
            max_height[curr][0], max_height[curr][1] = first_max, second_max
            stack.pop()
        else:
            vis[curr] = True
            level[curr] = lvl
            for nex in adj[curr]:
                if nex != prev:
                    stack.append((nex, lvl + 1, curr))

    q = deque()
    q.append((0, -1))
    while q:
        curr, prev = q.popleft()
        max_dist_up[curr] = level[curr]
        if prev != -1:
            if max_height[prev][0] == max_height[curr][0]:
                max_dist_up[curr] = max(max_dist_up[curr], max_dist_up[prev] + 1, max_height[prev][1] - level[prev] + 1)
            else:
                max_dist_up[curr] = max(max_dist_up[curr], max_dist_up[prev] + 1, max_height[prev][0] - level[prev] + 1)
        for nex in adj[curr]:
            if nex != prev:
                q.append((nex, curr))

    arr = []
    for i in range(n):
        arr.append(max(max_dist_up[i], max_height[i][0] - level[i]))
    print(' '.join(map(str, arr)))

    pass


def bootstrap(f, stack=[]):
    def wrappedfunc(*args, **kwargs):
        if stack:
            return f(*args, **kwargs)
        to = f(*args, **kwargs)
        while True:
            if type(to) is GeneratorType:
                stack.append(to)
                to = next(to)
            else:
                stack.pop()
                if not stack:
                    break
                to = stack[-1].send(to)
        return to

    return wrappedfunc


# region fastio

BUFSIZE = 8192


class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        self._file = file
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None

    def read(self):
        while True:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()

    def readline(self):
        while self.newlines == 0:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()

    def flush(self):
        if self.writable:
            os.write(self._fd, self.buffer.getvalue())
            self.buffer.truncate(0), self.buffer.seek(0)


class IOWrapper(IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s: self.buffer.write(s.encode("ascii"))
        self.read = lambda: self.buffer.read().decode("ascii")
        self.readline = lambda: self.buffer.readline().decode("ascii")


sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip("\r\n")

# endregion

if __name__ == "__main__":
    main()