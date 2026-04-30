import sys
 
input = sys.stdin.readline
 
class MaxSubarraySegTree:
    def __init__(self, n):
        # size as power of two
        self.N = 1
        while self.N < n:
            self.N <<= 1
 
        size = 2 * self.N
        # total sum
        self.sum_ = [0] * size
        # max prefix
        self.pref = [0] * size
        # max suffix
        self.suff = [0] * size
        # max subarray inside segment
        self.best = [0] * size
 
    def _pull(self, i):
        L = 2 * i
        R = 2 * i + 1
 
        # combine children L and R into parent i
        self.sum_[i] = self.sum_[L] + self.sum_[R]
 
        self.pref[i] = max(
            self.pref[L],
            self.sum_[L] + max(self.pref[R], 0)
        )
 
        self.suff[i] = max(
            self.suff[R],
            self.sum_[R] + max(self.suff[L], 0)
        )
 
        self.best[i] = max(
            self.best[L],
            self.best[R],
            max(self.suff[L], 0) + max(self.pref[R], 0)
        )
 
    def build(self, a):
        # put array values into leaves
        for i, v in enumerate(a):
            pos = self.N + i
            self.sum_[pos] = v
            self.pref[pos] = v
            self.suff[pos] = v
            self.best[pos] = v
 
        # remaining leaves (past len(a)) stay as zeros:
        # they behave like extra 0's at the end, which is safe
        for i in range(self.N - 1, 0, -1):
            self._pull(i)
 
    def update(self, idx, val):
        # point update at position idx (0-based)
        i = self.N + idx
        self.sum_[i] = val
        self.pref[i] = val
        self.suff[i] = val
        self.best[i] = val
 
        i //= 2
        while i:
            self._pull(i)
            i //= 2
 
    def answer(self):
        # empty subarray allowed, hence max with 0
        return max(self.best[1], 0)
 
 
def main():
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
 
    st = MaxSubarraySegTree(n)
    st.build(a)
 
    out_lines = []
    for _ in range(m):
        k, x = map(int, input().split())
        st.update(k - 1, x)  # k is 1-based in input
        out_lines.append(str(st.answer()))
 
    sys.stdout.write("\n".join(out_lines))
 
 
if __name__ == "__main__":
    main()