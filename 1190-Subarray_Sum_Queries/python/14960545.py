import sys
 
input = sys.stdin.readline
 
 
class SegmentTree:
    def __init__(self, arr):
        self.n = len(arr)
        size = 1
        while size < self.n:
            size <<= 1
        self.size = size
        self.total = [0] * (2 * self.size)
        self.leftlargest = [0] * (2 * self.size)
        self.rightlargest = [0] * (2 * self.size)
        self.largest = [0] * (2 * self.size)
 
        total, leftlargest, rightlargest, largest = self.total, self.leftlargest, self.rightlargest, self.largest
 
        for i in range(self.n):
            value = arr[i]
            temp = max(value, 0)
            total[size + i] = value
            leftlargest[size + i] = temp
            rightlargest[size + i] = temp
            largest[size + i] = temp
 
        for i in range(self.size - 1, 0, -1):
            left = 2 * i
            right = 2 * i + 1
 
            total[i] = total[left] + total[right]
            leftlargest[i] = max(leftlargest[left], total[left] + leftlargest[right])
            rightlargest[i] = max(rightlargest[right], total[right] + rightlargest[left])
            largest[i] = max(largest[left], largest[right], rightlargest[left] + leftlargest[right])
 
    def update(self, index, value):
        # Base case: leaf node to be updated
        total, leftlargest, rightlargest, largest = self.total, self.leftlargest, self.rightlargest, self.largest
        start = self.size + index
        temp = max(value, 0)
        total[start] = value
        leftlargest[start] = temp
        rightlargest[start] = temp
        largest[start] = temp
        start >>= 1
        while start >= 1:
            left = 2 * start
            right = 2 * start + 1
 
            total[start] = total[left] + total[right]
            leftlargest[start] = max(leftlargest[left], total[left] + leftlargest[right])
            rightlargest[start] = max(rightlargest[right], total[right] + rightlargest[left])
            largest[start] = max(largest[left], largest[right], leftlargest[right] + rightlargest[left])
 
            start >>= 1
 
    def query(self):
        return self.largest[1]
 
 
if __name__ == "__main__":
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))
 
    st = SegmentTree(arr)
    ans = []
 
    for _ in range(m):
        k, x = map(int, input().split())
        st.update(k - 1, x)
        ans.append(str(st.query()))
 
    sys.stdout.write("\n".join(ans))