import collections
import functools
import heapq
import bisect
import itertools
import math
import os
from io import BytesIO, IOBase
from sys import setrecursionlimit, stderr, stdin, stdout

setrecursionlimit(1_000_000)


def get_ints():
    return list(map(int, input().split()))


def get_int():
    return int(input())


def get_str():
    return "".join(list(map(chr, input().rstrip())))


def eprint(*args):
    print(*args, sep=", ", file=stderr)


class DSU:
    def __init__(self):
        self.p = {}
        self.sz = {}
        self.components = 0

    def create(self, x):
        if x not in self.p:
            self.components += 1
            self.p[x] = x
            self.sz[x] = 1

    def find(self, x):
        if x not in self.p:
            self.create(x)
            return x

        if x != self.p[x]:
            self.p[x] = self.find(self.p[x])
        return self.p[x]

    def union(self, x, y):
        rx, ry = self.find(x), self.find(y)
        if rx != ry:
            self.components -= 1
            if self.sz[rx] < self.sz[ry]:
                rx, ry = ry, rx
            self.p[ry] = rx
            self.sz[rx] += self.sz[ry]


def main():
    n, m = get_ints()
    matrix = []
    for _ in range(n):
        matrix.append(input())

    dsu = DSU()
    for r in range(n):
        for c in range(m):
            if matrix[r][c] == ".":
                location = r * m + c
                dsu.create(location)
                for nx, ny in ((r + 1, c), (r, c + 1)):
                    if 0 <= nx < n and 0 <= ny < m and matrix[nx][ny] == ".":
                        other_location = nx * m + ny
                        dsu.union(location, other_location)
    print(dsu.components)


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


stdin = IOWrapper(stdin)  # type: ignore
stdout = IOWrapper(stdout)  # type: ignore
input = lambda: stdin.readline().rstrip("\r\n")


def print(*args, **kwargs):
    """Prints the values to a stream, or to sys.stdout by default."""
    sep, file = kwargs.pop("sep", " "), kwargs.pop("file", stdout)
    at_start = True
    for x in args:
        if not at_start:
            file.write(sep)
        file.write(str(x))
        at_start = False
    file.write(kwargs.pop("end", "\n"))
    if kwargs.pop("flush", False):
        file.flush()


# endregion

if __name__ == "__main__":
    main()