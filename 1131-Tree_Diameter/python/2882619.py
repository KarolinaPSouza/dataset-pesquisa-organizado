import math
import os
import sys
from io import BytesIO, IOBase
M = 1000000007
import random
import heapq
import bisect
import time
from functools import *
from collections import *
from itertools import *
#sys.setrecursionlimit(10**5)
BUFSIZE = 8192
import array
class FastIO(IOBase):
    newlines = 0
    def __init__(self, file):
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
def inp(): return sys.stdin.readline().rstrip("\r\n")  # for fast input
def out(var): sys.stdout.write(str(var))  # for fast output, always take string
def lis(): return list(map(int, inp().split()))
def stringlis(): return list(map(str, inp().split()))
def sep(): return map(int, inp().split())
def strsep(): return map(str, inp().split())
def fsep(): return map(float, inp().split())
def inpu(): return int(inp())

def build(arr,a,b,st,node):
    if a==b:
        st[node] =  arr[a]
        return st[node]
    mid = (a+b)//2
    st[node] = min(build(arr,a,mid,st,2*node+1) , build(arr,mid+1,b,st,2*node+2))
    return st[node]

def getmin(arr,a,b,l,r,st,node):
    if l>b or r<a:
        return float("inf")
    if l<=a and r>=b:
        return st[node]
    mid = (a+b)//2
    return min(getmin(arr,a,mid,l,r,st,2*node+1),getmin(arr,mid+1,b,l,r,st,2*node+2))

def bfs(dc,cur,lv,ml,n):
    vis=[0]*n
    q=deque([(cur,0)])
    while q:
        nd,lvl=q.popleft()
        lv[0]=nd
        vis[nd]=1
        ml[0]=max(ml[0],lvl+1)
        for nbr in dc[nd]:
            if vis[nbr]==0:
                q.append((nbr,lvl+1))


def main():
    t = 1
    #t = int(input())
    for tc in range(1, t + 1):
        d=defaultdict(list)
        n=inpu()
        if n==1:
            print(0)
            continue
        for __ in range(n-1):
            a,b=sep()
            d[a-1].append(b-1)
            d[b-1].append(a-1)
        mx = [0]
        lv = [-1]
        ml = [-1]
        bfs(d, 1, lv, ml,n)
        bfs(d, lv[0], lv, ml,n)
        print(ml[0] - 1)
if __name__ == '__main__':
    main()