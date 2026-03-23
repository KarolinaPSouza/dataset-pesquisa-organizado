import bisect
n, m = map(int,input().split())
h = sorted(list(map(int,input().split())))
t = list(map(int,input().split()))
if n <= 4:
    for ti in t:
        if len(h) == 0:
            print(-1)
        else:
            x = bisect.bisect_right(h,ti)
            if x == 0:
                print(-1)
            else:
                print(h[x-1])
                del h[x-1]
else:
    p1 = int(n/5)
    p2 = 2*p1
    p3 = 3*p1
    p4 = 4*p1
    h1 = h[:p1]
    h2 = h[p1:p2]
    h3 = h[p2:p3]
    h4 = h[p3:p4]
    h5 = h[p4:]
    lh = [h1,h2,h3,h4,h5]
    l = [0,1,2,3,4]
    for ti in t:
        if len(l) == 0:
            print(-1)
        else:
            i = 0
            while i <= len(l)-1:
                if i == 0 and len(l) > 1:
                    if ti < lh[l[i]][0]:
                        print(-1)
                        break
                elif i == 0 and len(l) == 1:
                    x = bisect.bisect_right(lh[l[i]],ti)
                    if x == 0:
                        print(-1)
                        break
                    else:
                        print(lh[l[i]][x-1])
                        del lh[l[i]][x-1]
                        if len(lh[l[i]]) == 0:
                            del l[i]
                        break
                elif l[i] != l[-1]:
                    if ti < lh[l[i]][0]:
                        x = bisect.bisect_right(lh[l[i-1]],ti)
                        print(lh[l[i-1]][x-1])
                        del lh[l[i-1]][x-1]
                        if len(lh[l[i-1]]) == 0:
                            del l[i-1]
                        break
                else:
                    if ti < lh[l[i]][0]:
                        x = bisect.bisect_right(lh[l[i-1]],ti)
                        print(lh[l[i-1]][x-1])
                        del lh[l[i-1]][x-1]
                        if len(lh[l[i-1]]) == 0:
                            del l[i-1]
                        break
                    else:
                        x = bisect.bisect_right(lh[l[i]],ti)
                        print(lh[l[i]][x-1])
                        del lh[l[i]][x-1]
                        if len(lh[l[i]]) == 0:
                            del l[i]
                        break
                i += 1