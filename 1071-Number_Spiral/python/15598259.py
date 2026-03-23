def main():
    n = int(input())
    for tc in range(n):
        inp = input().split()
        x = int(inp[0])
        y = int(inp[1])
        m = max(x,y)
        if m % 2 == 0:
            if x == m:
                # m ^ 2  -  (y - 1)
                print((m * m - (y - 1)))
            else:
                # (m - 1) * (m - 1) + x
                print((m - 1) * (m - 1) + x)
        else:
            if x == m:
                # (m - 1) * (m - 1) + y
                print((m - 1) * (m - 1) + y)
            else:
                # (m * m - (x - 1))
                print(m* m - (x - 1))


if __name__ == "__main__":
    main()