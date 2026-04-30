def main():
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))
    ops = [tuple(map(int, input().split())) for _ in range(m)]
 
    size = 1
    while size < n:
        size <<= 1
 
    tot = [0] * (2 * size)
    pre = [0] * (2 * size)
    suf = [0] * (2 * size)
    best = [0] * (2 * size)
 
    for i in range(n):
        v = arr[i]
        idx = size + i
        tot[idx] = v
        pre[idx] = suf[idx] = best[idx] = max(0, v)
 
    for i in range(size - 1, 0, -1):
        l, r = i << 1, i << 1 | 1
        tot[i] = tot[l] + tot[r]
        pre[i] = max(pre[l], tot[l] + pre[r])
        suf[i] = max(suf[r], tot[r] + suf[l])
        best[i] = max(best[l], best[r], suf[l] + pre[r])
 
    for k, val in ops:
        idx = size + k - 1
        tot[idx] = val
        pre[idx] = suf[idx] = best[idx] = max(0, val)
        idx >>= 1
        while idx:
            l, r = idx << 1, idx << 1 | 1
            tot[idx] = tot[l] + tot[r]
            pre[idx] = max(pre[l], tot[l] + pre[r])
            suf[idx] = max(suf[r], tot[r] + suf[l])
            best[idx] = max(best[l], best[r], suf[l] + pre[r])
            idx >>= 1
        print(best[1])
 
main()