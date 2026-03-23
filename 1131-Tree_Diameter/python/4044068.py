from __future__ import division, print_function
import math
import sys
import os
from io import BytesIO, IOBase
from collections import deque, Counter, OrderedDict, defaultdict
import heapq
# ceil,floor,log,sqrt,factorial,pow,pi,gcd
# import bisect
from bisect import bisect_left,bisect_right

BUFSIZE = 8192


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

def inp():
    return(int(input()))
def inps():
    return input().strip()
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input().strip()
    return(list(s[:len(s)]))
def invr():
    return(map(int,input().split()))

from types import GeneratorType
def bootstrap(f, stack=[]):
    def wrappedfunc(*args, **kwargs):
        if stack:
            return f(*args, **kwargs)
        else:
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




def dia1():
    @bootstrap
    def dfs(nd,p,v):
        if v>maxd[0]:
            maxd[0]=v
            maxfr[0]=nd
        for each in d[nd]:
            if each!=p:
                yield dfs(each,nd,v+1)
        yield 0
    maxfr=[1]
    maxd=[0]
    dfs(1,-1,0)
    dfs(maxfr[0],-1,0)
    return maxd[0]

def dia2():
    @bootstrap
    def dfs(nd,p,v):
        lst=[0,0]
        v1,v2=0,0
        idxmx=0
        i=2
        for each in d[nd]:
            # print(each,i)
            if each!=p:
                val=yield dfs(each,nd,v+1)
                lst.append(val)
                # print(val,i)
                if val>v1:
                    v1=val
                    idxmx=i
                i+=1
        for i in range(len(lst)):
            if lst[i]>v2 and i!=idxmx:
                v2=lst[i]
        tmxd=v1+v2
        # print(v1,v2,lst,idxmx)
        maxd[0]=max(maxd[0],tmxd)
        yield v1+1
    maxd=[0]
    dfs(1,-1,0)
    return maxd[0]




n=inp()
d=defaultdict(lambda:[])
for i in range(n-1):
    a,b=invr()
    d[a].append(b)
    d[b].append(a)
print(dia2())