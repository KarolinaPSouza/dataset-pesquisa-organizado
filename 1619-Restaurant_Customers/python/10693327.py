def solution() -> None:
    n: int = int(input())
    arival, departed = [], []
    for i in range(n):
        a, d = [int(x) for x in input().split()]
        arival.append(a)
        departed.append(d)
    arival.sort()
    departed.sort()
    ans: int = 0
    i, j, c = 0, 0, 0
    while i < n and j < n:
        if arival[i] < departed[j]:
            c += 1
            i += 1
        else:
            c -= 1
            j += 1
        ans = max(ans, c)
    print(ans)


def main() -> None:
    solution()


if __name__ == '__main__':
    main()