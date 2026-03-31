import io, os


def solve():
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
    n = int(input())
    arr = []
    for _ in range(n):
        x, y = map(int, input().split())
        arr.extend([(x, 1), (y, -1)])

    arr.sort()
    ans, temp = 0, 0
    for i in range(2 * n):
        temp += arr[i][1]
        ans = max(ans, temp)
    print(ans)


if __name__ == "__main__":
    # t = int(input())
    for _ in range(1):
        solve()