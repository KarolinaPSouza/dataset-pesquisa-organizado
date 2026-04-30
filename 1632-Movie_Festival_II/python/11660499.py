from bisect import bisect
 
 
def radix_sort_index(keys, a, n):
    cnt = [0] * 32768
    t = [0] * n
    for i in range(n):
        cnt[keys[a[i]] & 32767] += 1
    for i in range(1, 32768):
        cnt[i] += cnt[i - 1]
    for i in reversed(range(n)):
        t[cnt[keys[a[i]] & 32767] - 1] = a[i]
        cnt[keys[a[i]] & 32767] -= 1
 
    cnt = [0] * 32768
    for i in range(n):
        cnt[keys[t[i]] >> 15] += 1
    for i in range(1, 32768):
        cnt[i] += cnt[i - 1]
    for i in reversed(range(n)):
        a[cnt[keys[t[i]] >> 15] - 1] = t[i]
        cnt[keys[t[i]] >> 15] -= 1
 
 
def main():
    n, k, *r = map(int, open(0).read().split())
 
    s = r[::2]
    f = r[1::2]
 
    order = list(range(n))
    # order.sort(key=lambda i: f[i])
    radix_sort_index(f, order, n)
 
    seen = []
    dsu = list(range(n + 1))
 
    counter = 0
    total = 0
 
    for i in range(n):
        index = order[i]
        start = s[index]
        finish = f[index]
 
        j = bisect(seen, start)
 
        while dsu[j] != j:
            dsu[j] = j = dsu[dsu[j]]
 
        if j == 0:
            if total < k:
                seen.append(finish)
                counter += 1
                total += 1
            continue
 
        dsu[j] = j - 1
 
        seen.append(finish)
        counter += 1
 
    print(counter)
 
 
if __name__ == "__main__":
    main()