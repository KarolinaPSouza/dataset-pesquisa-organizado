from bisect import bisect
 
 
def main():
    n, k, *r = map(int, open(0).read().split())
 
    s = r[::2]
    f = r[1::2]
 
    order = list(range(n))
    order.sort(key=lambda i: f[i])
 
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