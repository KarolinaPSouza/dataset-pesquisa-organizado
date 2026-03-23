import bisect

class SegmentTree:
    def __init__(self, n):
        self.size = 1
        while self.size < n:
            self.size <<= 1
        self.tree = [-1] * (2 * self.size)
        # Initialize leaves
        for i in range(n):
            self.tree[self.size + i] = i
        # Build the tree
        for i in range(self.size - 1, 0, -1):
            self.tree[i] = max(self.tree[2 * i], self.tree[2 * i + 1])

    def update(self, pos):
        pos += self.size
        self.tree[pos] = -1
        pos >>= 1
        while pos >= 1:
            new_val = max(self.tree[2 * pos], self.tree[2 * pos + 1])
            if self.tree[pos] == new_val:
                break
            self.tree[pos] = new_val
            pos >>= 1

    def query(self, a, b):
        res = -1
        a += self.size
        b += self.size
        while a <= b:
            if a % 2 == 1:
                res = max(res, self.tree[a])
                a += 1
            if b % 2 == 0:
                res = max(res, self.tree[b])
                b -= 1
            a >>= 1
            b >>= 1
        return res

n, m = map(int, input().split())
h = list(map(int, input().split()))
h.sort()
st = SegmentTree(n)
max_prices = list(map(int, input().split()))
for t in max_prices:
    idx = bisect.bisect_right(h, t) - 1
    if idx < 0:
        print(-1)
        continue
    pos = st.query(0, idx)
    if pos == -1:
        print(-1)
    else:
        print(h[pos])
        st.update(pos)

# def solution(n,m,price,max_price):
#     price.sort()
#     left = 0
#     store_right = n
#     for i in range(m):
#         if left == -1:
#             right = store_right
#         else:
#             right = store_right - 1
#         if not price:
#             print(-1)
#             continue
#         store_right = right
#         left = 0
#         while left < right:
#             mid = (left+right)//2
#             if not quailifer(price[mid],max_price[i]):
#                 right = mid                
#             else:
#                 left = mid + 1
#         if price[left] <= max_price[i]:
#             print(price[left])
#             del price[left]  
#         elif left > 0 and price[left - 1] <= max_price[i]:
#             print(price[left - 1])
#             del price[left - 1]  
#         else:
#             left = -1
#             print(-1)

# def quailifer(price,max_price):
#     return price <= max_price

# n,m = map(int, input().split())
# price = list(map(int, input().split()))
# max_price = list(map(int, input().split()))

# solution(n,m,price,max_price)