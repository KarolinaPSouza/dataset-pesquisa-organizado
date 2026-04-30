import sys
input = sys.stdin.readline
 
class SegmentTree:
    def __init__(self, a):
        n = len(a)
        size = 1
        while size < n:
            size <<= 1
        self.n = n
        self.size = size
        self.sum  = [0] * (2 * size)
        self.pref = [0] * (2 * size)
        self.suff = [0] * (2 * size)
        self.best = [0] * (2 * size)
 
        # leaves
        for i in range(n):
            v = a[i]
            self.sum[size + i] = v
            x = v if v > 0 else 0
            self.pref[size + i] = x
            self.suff[size + i] = x
            self.best[size + i] = x
        # padded leaves already zero-initialized (neutral)
 
        # build
        for i in range(size - 1, 0, -1):
            self._pull(i)
 
    def _pull(self, i):
        l, r = 2 * i, 2 * i + 1
        self.sum[i]  = self.sum[l] + self.sum[r]
        self.pref[i] = self.pref[l] if self.pref[l] >= self.sum[l] + self.pref[r] else self.sum[l] + self.pref[r]
        self.suff[i] = self.suff[r] if self.suff[r] >= self.sum[r] + self.suff[l] else self.sum[r] + self.suff[l]
        cross = self.suff[l] + self.pref[r]
        b = self.best[l] if self.best[l] >= self.best[r] else self.best[r]
        self.best[i] = b if b >= cross else cross
 
    def update(self, idx, val):
        i = idx + self.size
        self.sum[i] = val
        x = val if val > 0 else 0
        self.pref[i] = x
        self.suff[i] = x
        self.best[i] = x
        i //= 2
        while i:
            self._pull(i)
            i //= 2
 
 
n, m = map(int, input().split())
arr = list(map(int, input().split()))
st = SegmentTree(arr)
 
out = []
for _ in range(m):
    k, x = map(int, input().split())
    st.update(k - 1, x)
    out.append(str(st.best[1]))
sys.stdout.write("\n".join(out))
 
 
 
 
 
