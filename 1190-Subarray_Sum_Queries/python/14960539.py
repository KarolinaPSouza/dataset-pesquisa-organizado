import sys
read = sys.stdin.buffer.read
write = sys.stdout.write
 
data = list(map(int, read().split()))
it = 0
n = data[it]; it += 1
m = data[it]; it += 1
arr = data[it:it+n]; it += n
 
size = 1
while size < n:
    size <<= 1
N = 2 * size
 
# arrays: index from 1..(N-1); leaves at [size .. size+size-1]
S = [0] * N  # sum
P = [0] * N  # pref
U = [0] * N  # suff
B = [0] * N  # best
 
# initialize leaves
base = size
for i in range(n):
    v = arr[i]
    z = v if v > 0 else 0
    idx = base + i
    S[idx] = v
    P[idx] = z
    U[idx] = z
    B[idx] = z
# extra leaves (beyond n) remain zeros (neutral for empty-allowed)
 
# build internal nodes
for i in range(size - 1, 0, -1):
    l = i << 1
    r = l | 1
    Sl, Sr = S[l], S[r]
    Pl, Pr = P[l], P[r]
    Ul, Ur = U[l], U[r]
    Bl, Br = B[l], B[r]
 
    S[i] = Sl + Sr
    # prefix
    t = Sl + Pr
    P[i] = Pl if Pl >= t else t
    # suffix
    t = Sr + Ul
    U[i] = Ur if Ur >= t else t
    # best
    t = Ul + Pr
    m1 = Bl if Bl >= Br else Br
    B[i] = m1 if m1 >= t else t
 
for _ in range(m):
    k = data[it]; x = data[it+1]; it += 2
    p = base + (k - 1)
 
    # set leaf
    z = x if x > 0 else 0
    S[p] = x
    P[p] = z
    U[p] = z
    B[p] = z
 
    # climb and recompute
    p >>= 1
    while p:
        l = p << 1
        r = l | 1
 
        Sl, Sr = S[l], S[r]
        Pl, Pr = P[l], P[r]
        Ul, Ur = U[l], U[r]
        Bl, Br = B[l], B[r]
 
        S[p] = Sl + Sr
 
        t = Sl + Pr
        P[p] = Pl if Pl >= t else t
 
        t = Sr + Ul
        U[p] = Ur if Ur >= t else t
 
        t = Ul + Pr
        m1 = Bl if Bl >= Br else Br
        B[p] = m1 if m1 >= t else t
 
        p >>= 1
 
    write(str(B[1])); write("\n")