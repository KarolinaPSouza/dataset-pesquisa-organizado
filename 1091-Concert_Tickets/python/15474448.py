import bisect


tic, cus = map(int, input().split())
tickets = sorted(map(int, input().split()))
customers = list(map(int, input().split()))

# ==== BUILD SEGMENT TREE (range sum) ====

n = tic
size = 1
while size < n:
    size <<= 1

seg = [0] * (2 * size)

# init: leaf nodes = 1 (vé còn)
for i in range(n):
    seg[size + i] = 1

# build tree
for i in range(size - 1, 0, -1):
    seg[i] = seg[2*i] + seg[2*i + 1]


# ==== UPDATE: set index position to 0 (sold) ====
def update(pos):
    pos += size
    seg[pos] = 0
    pos >>= 1
    while pos:
        seg[pos] = seg[2*pos] + seg[2*pos + 1]
        pos >>= 1


# ==== QUERY: tìm phần tử còn lại lớn nhất ≤ index r ====
def query_max(r):
    # tìm trong đoạn [0, r]
    L = size
    R = size + r
    res = -1

    while L <= R:
        if L & 1:
            if seg[L] > 0:   # trong node này có vé
                # tìm vị trí thật bên trong node
                idx = L
                while idx < size:
                    if seg[2*idx + 1] > 0:   # ưu tiên nhánh phải (giá lớn hơn)
                        idx = 2*idx + 1
                    else:
                        idx = 2*idx
                return idx - size
            L += 1
        if not (R & 1):
            if seg[R] > 0:
                idx = R
                while idx < size:
                    if seg[2*idx + 1] > 0:
                        idx = 2*idx + 1
                    else:
                        idx = 2*idx
                return idx - size
            R -= 1
        L >>= 1
        R >>= 1

    return -1


# ==== PROCESS CUSTOMERS ====

for price in customers:
    # tìm vị trí lớn nhất có giá ≤ price
    idx = bisect.bisect_right(tickets, price) - 1
    if idx < 0:
        print(-1)
        continue

    # tìm vé còn sống trong [0, idx]
    pos = query_max(idx)
    if pos == -1:
        print(-1)
    else:
        print(tickets[pos])
        update(pos)