MOD = int(1e9 + 7)


def read_list(f=int):
    return list(map(f, input().split()))


def read(f=int):
    return f(input())


def solve():
    n = read()
    ans = 0
    for i in range(1, 1000001):
        if i * i > n:
            break
        # i * (i + k) <= n
        k = (n - i * i) // i
        ans += i + 2 * i * k
        ans += k * (k + 1) // 2
        ans %= MOD
    print(ans)

if __name__ == "__main__":
    T = 1
    # T = int(input())
    for _ in range(T):
        solve()