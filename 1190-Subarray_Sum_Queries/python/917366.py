   
#!/usr/bin/env python
import os
import sys
from io import BytesIO, IOBase
 
 
def main():
    n,m = map(int,sys.stdin.readline().split())
    xs = map(int,sys.stdin.readline().split())
 
    base = 1
    while base < n:
        base*=2
    tree = [0]*(8*base)
    for i,x in enumerate(xs):
        tree[4*(base+i)+0] = tree[4*(base+i)+1] = tree[4*(base+i)+2] = max(0, x)
        tree[4*(base+i)+3] = x
        
    for i in range(base-1,0,-1):
        a1,b1,c1,d1,a2,b2,c2,d2 = tree[8*i:8*i+8]
        tree[4*i:4*i+4] = (max(a1,a2,c1+b2),max(b1,d1+b2),max(c2,d2+c1),d1+d2)
        
 
    for j in range(m):
        i,b = map(int,sys.stdin.readline().split())
 
        i+=base-1
        tree[4*i+0] = tree[4*i+1] = tree[4*i+2]  = max(b,0)
        tree[4*i+3] = b
        while i>1:
            i >>= 1
            a1,b1,c1,d1,a2,b2,c2,d2 = tree[8*i:8*i+8]
            tree[4*i:4*i+4] = (max(a1,a2,c1+b2),max(b1,d1+b2),max(c2,d2+c1),d1+d2)
        sys.stdout.write(f"%d\n" % tree[4])
 
 
# region fastio
 
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
 
 
sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip("\r\n")
 
# endregion
 
if __name__ == "__main__":
    main()