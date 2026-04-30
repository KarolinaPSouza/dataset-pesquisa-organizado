# by the authority of GOD   author: manhar singh sachdev #
 
import os,sys
from io import BytesIO,IOBase
 
# empty subarray considered
def construct(n,x,si):
    tree = [0]*(si<<1)
    le = [0]*(si<<1)
    ri = [0]*(si<<1)
    best = [0]*(si<<1)
    for i in range(si,si+n):
        tree[i] = x[i-si]
        le[i] = ri[i] = best[i] = max(0,x[i-si])
    a,b = si>>1,si
    while a:
        for i in range(a,b):
            tree[i] = tree[2*i]+tree[2*i+1]
            le[i] = max(le[2*i],tree[2*i]+le[2*i+1])
            ri[i] = max(ri[2*i+1],tree[2*i+1]+ri[2*i])
            best[i] = max(best[2*i],best[2*i+1],max(tree[2*i],ri[2*i])+max(tree[2*i+1],le[2*i+1]))
        a,b = a>>1,b>>1
    return tree,le,ri,best
 
def update(tree,le,ri,best,pos,value,si):
    pos += si-1
    tree[pos] = value
    le[pos] = ri[pos] = best[pos] = max(value,0)
    pos >>= 1
    while pos:
        tree[pos] = tree[pos*2]+tree[pos*2+1]
        le[pos] = max(le[2*pos],tree[2*pos]+le[2*pos+1])
        ri[pos] = max(ri[2*pos+1],tree[2*pos+1]+ri[2*pos])
        best[pos] = max(best[2*pos],best[2*pos+1],max(tree[2*pos],ri[2*pos])+max(tree[2*pos+1],le[2*pos+1]))
        pos >>= 1
    return best[1]
 
def main():
    n,m = map(int,input().split())
    a = list(map(int,input().split()))
    si = 1<<(n.bit_length()-(not n&n-1))
    tree,le,ri,best = construct(n,a,si)
    for _ in range(m):
        i,x = map(int,input().split())
        print(update(tree,le,ri,best,i,x,si))
 
# Fast IO Region
BUFSIZE = 8192
 
class FastIO(IOBase):
    newlines = 0
 
    def __init__(self,file):
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None
 
    def read(self):
        while True:
            b = os.read(self._fd,max(os.fstat(self._fd).st_size,BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0,2),self.buffer.write(b),self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()
 
    def readline(self):
        while self.newlines == 0:
            b = os.read(self._fd,max(os.fstat(self._fd).st_size,BUFSIZE))
            self.newlines = b.count(b"\n")+(not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0,2),self.buffer.write(b),self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()
 
    def flush(self):
        if self.writable:
            os.write(self._fd,self.buffer.getvalue())
            self.buffer.truncate(0),self.buffer.seek(0)
 
class IOWrapper(IOBase):
    def __init__(self,file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s:self.buffer.write(s.encode("ascii"))
        self.read = lambda:self.buffer.read().decode("ascii")
        self.readline = lambda:self.buffer.readline().decode("ascii")
 
sys.stdin,sys.stdout = IOWrapper(sys.stdin),IOWrapper(sys.stdout)
input = lambda:sys.stdin.readline().rstrip("\r\n")
if __name__ == "__main__":
    main()