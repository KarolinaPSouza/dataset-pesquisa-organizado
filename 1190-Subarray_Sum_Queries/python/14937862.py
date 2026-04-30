import sys
input = sys.stdin.readline
 
class SegmentTree:
    def __init__(self, arr):
        self.n = len(arr)
        self.size = 1
        while self.size < self.n:
            self.size *= 2
        N = 2 * self.size
        self.sum = [0] * N
        self.pref = [0] * N
        self.suff = [0] * N
        self.best = [0] * N
        for i in range(self.n):
            val = arr[i]
            pos = self.size + i
            self.sum[pos] = val
            self.pref[pos] = self.suff[pos] = self.best[pos] = max(0, val)
        for i in range(self.size - 1, 0, -1):
            self.merge(i)
 
    def merge(self, i):
        l, r = 2 * i, 2 * i + 1
        self.sum[i] = self.sum[l] + self.sum[r]
        self.pref[i] = max(self.pref[l], self.sum[l] + self.pref[r])
        self.suff[i] = max(self.suff[r], self.sum[r] + self.suff[l])
        self.best[i] = max(self.best[l], self.best[r], self.suff[l] + self.pref[r])
 
    def update(self, index, value):
        pos = self.size + index
        self.sum[pos] = value
        self.pref[pos] = self.suff[pos] = self.best[pos] = max(0, value)
        pos //= 2
        while pos >= 1:
            self.merge(pos)
            pos //= 2
 
    def query(self):
        return self.best[1]
 
n, m = map(int, input().split())
a = list(map(int, input().split()))
st = SegmentTree(a)
 
out = []
for _ in range(m):
    k, x = map(int, input().split())
    st.update(k - 1, x)
    out.append(str(st.query()))
 
print("\n".join(out))