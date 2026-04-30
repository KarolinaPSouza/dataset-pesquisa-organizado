import sys
 
def main():
    data = list(map(int, sys.stdin.buffer.read().split()))
    it = iter(data)
    n = next(it); q = next(it)
 
    size = 1
    while size < n:
        size <<= 1
    N = 2 * size
 
    pref = [0] * N
    suff = [0] * N
    best = [0] * N
    summ = [0] * N
 
    # build leaves
    base = size
    for i in range(n):
        x = next(it)
        t = x if x > 0 else 0
        idx = base + i
        pref[idx] = t
        suff[idx] = t
        best[idx] = t
        summ[idx] = x
    # remaining leaves already 0
 
    # build internal nodes
    for idx in range(size - 1, 0, -1):
        l = idx << 1
        r = l | 1
 
        sl = summ[l]; sr = summ[r]
        summ[idx] = sl + sr
 
        # pref = max(prefL, sumL + prefR)
        v = sl + pref[r]
        pl = pref[l]
        pref[idx] = pl if pl >= v else v
 
        # suff = max(suffR, sumR + suffL)
        v = sr + suff[l]
        rr = suff[r]
        suff[idx] = rr if rr >= v else v
 
        # best = max(bestL, bestR, suffL + prefR)
        b = best[l]
        br = best[r]
        if br > b:
            b = br
        v = suff[l] + pref[r]
        if v > b:
            b = v
        best[idx] = b
 
    out = []
    for _ in range(q):
        k = next(it); x = next(it)
        idx = base + (k - 1)
        t = x if x > 0 else 0
        pref[idx] = t
        suff[idx] = t
        best[idx] = t
        summ[idx] = x
 
        idx >>= 1
        while idx:
            l = idx << 1
            r = l | 1
 
            sl = summ[l]; sr = summ[r]
            summ[idx] = sl + sr
 
            v = sl + pref[r]
            pl = pref[l]
            pref[idx] = pl if pl >= v else v
 
            v = sr + suff[l]
            rr = suff[r]
            suff[idx] = rr if rr >= v else v
 
            b = best[l]
            br = best[r]
            if br > b:
                b = br
            v = suff[l] + pref[r]
            if v > b:
                b = v
            best[idx] = b
 
            idx >>= 1
 
        out.append(str(best[1]))  # 루트가 전체 구간 답
 
    sys.stdout.write("\n".join(out))
 
if __name__ == "__main__":
    main()