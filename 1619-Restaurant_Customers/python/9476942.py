def main():
    import sys
    input = sys.stdin.read
    data = input().split()

    n = int(data[0])
    b = []

    index = 1
    for i in range(n):
        a_first = int(data[index])
        l_first = int(data[index + 1])
        index += 2
        b.append((a_first, True))
        b.append((l_first, False))

    b.sort()

    c = 0
    ans = float('-inf')

    for p in b:
        if p[1]:
            c += 1
            ans = max(ans, c)
        else:
            c -= 1

    print(ans)

if __name__ == "__main__":
    main()