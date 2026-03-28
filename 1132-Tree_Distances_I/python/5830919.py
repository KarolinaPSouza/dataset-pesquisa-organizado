from __future__ import division, print_function

import os,collections,math,random,heapq,bisect
import sys
from io import BytesIO, IOBase
# sys.setrecursionlimit(10**5)
if sys.version_info[0] < 3:
    from __builtin__ import xrange as range
    from future_builtins import ascii, filter, hex, map, oct, zip

# mod=10**9+7
def main(n):
    graph=collections.defaultdict(list)
    for i in range(n-1):
        a,b=map(int,input().split(" "))
        graph[a-1].append(b-1)
        graph[b-1].append(a-1)
    def updateDis(node):
        maxi=node
        dist=dis[node]
        for ele,val in enumerate(dis):
            maxi_dis[ele]=max(maxi_dis[ele],val)
            if dist<val:
                dist=val
                maxi=ele
        return maxi            
    def bfs(node):
        q=collections.deque()
        q.append([node,-1])
        while q:
            curr,par=q.popleft()
            for root in graph[curr]:
                if root==par:
                    continue
                if dis[root]<dis[curr]+1:
                    dis[root]=dis[curr]+1
                    q.append([root,curr])


    maxi_dis=[0]*n    
    dis=[-1]*n
    node=0
    dis[node]=0
    bfs(node)
    node=updateDis(node)
    dis=[-1]*n
    dis[node]=0
    bfs(node)
    node=updateDis(node)
    dis=[-1]*n
    dis[node]=0
    bfs(node)
    node=updateDis(node)
    print(*maxi_dis)





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


def print(*args, **kwargs):
    """Prints the values to a stream, or to sys.stdout by default."""
    sep, file = kwargs.pop("sep", " "), kwargs.pop("file", sys.stdout)
    at_start = True
    for x in args:
        if not at_start:
            file.write(sep)
        file.write(str(x))
        at_start = False
    file.write(kwargs.pop("end", "\n"))
    if kwargs.pop("flush", False):
        file.flush()


if sys.version_info[0] < 3:
    sys.stdin, sys.stdout = FastIO(sys.stdin), FastIO(sys.stdout)
else:
    sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)

input = lambda: sys.stdin.readline().rstrip("\r\n")

# endregion

if __name__ == "__main__":
    # sys.stdin=open('input.txt','r')
    # sys.stdout=open('output.txt','w')
    # t=int(input())
    # for _ in range(t):
        # n,s1,s2=map(int,input().split(" "))
    n=int(input())
        # nums=list(map(int,input().split(" ")))
        # b=list(map(int,input().split(" ")))

    main(n)






