# PyPy3 - optimized and correct (no fixed-width arrays)
import sys

data = list(map(int, sys.stdin.buffer.read().split()))
if not data:
    raise SystemExit
it = iter(data)
n = next(it)

a_list = [0]*n
b_list = [0]*n
p_list = [0]*n
days = [0]*(2*n)
di = 0
for i in range(n):
    a = next(it); b = next(it); p = next(it)
    a_list[i] = a
    b_list[i] = b
    p_list[i] = p
    days[di] = a; days[di+1] = b; di += 2

# coordinate compress days (only once)
days = sorted(set(days))
m = len(days)
day_index = {d: idx+1 for idx, d in enumerate(days)}  # 1-indexed

# order of projects sorted by end day
order = list(range(n))
order.sort(key = lambda i: b_list[i])

# precompute indices: a_idx_minus1 (ends < a) and b_idx (end index)
a_idx_minus1 = [0]*n
b_idx = [0]*n
for i in range(n):
    ai = day_index[a_list[i]]
    a_idx_minus1[i] = ai - 1
    b_idx[i] = day_index[b_list[i]]

# Fenwick tree storing Python ints (no overflow)
fenw = [0] * (m + 2)
_local_fenw = fenw
_local_m = m

# process projects by increasing end day
for idx in order:
    ai = a_idx_minus1[idx]
    # query max on prefix [1..ai]
    best = 0
    j = ai
    while j > 0:
        v = _local_fenw[j]
        if v > best:
            best = v
        j -= j & -j

    new_val = best + p_list[idx]

    bi = b_idx[idx]
    j = bi
    # update fenwick: propagate max
    while j <= _local_m:
        if new_val > _local_fenw[j]:
            _local_fenw[j] = new_val
        j += j & -j

# answer = max over fenwick (prefix up to m)
ans = 0
j = _local_m
while j > 0:
    v = _local_fenw[j]
    if v > ans:
        ans = v
    j -= j & -j

print(ans)