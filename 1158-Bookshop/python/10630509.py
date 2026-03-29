import time

def main():
    #t_start = time.monotonic_ns()
    n, x = map(int, input().strip().split())
    h = [int(price) for price in input().strip().split()]
    s = [int(pages) for pages in input().strip().split()]
    opt = [0] * (x+1)
    #t_end = time.monotonic_ns()
    #print("Initialization took {} ms".format((t_end - t_start) / 10**6))
    #print(n, x, h, s, opt)
    #t_start = time.monotonic_ns()
    for i in range(n):
        pages = s[i]
        price = h[i]
        for w in range(x, price-1, -1):
            new_balance = w-price
            incl_self = pages + opt[new_balance]
            excl_self = opt[w]
            opt[w] = max(incl_self, excl_self)
    #t_end = time.monotonic_ns()
    #print("solving took {} ms".format((t_end - t_start) / 10**6))
    #print(opt)
    print(opt[x])

if __name__ == '__main__':
    main()