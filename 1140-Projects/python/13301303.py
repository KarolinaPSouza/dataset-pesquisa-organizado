import sys
from bisect import bisect_right

def main():
    input = sys.stdin.read().splitlines()
    n = int(input[0])
    projects = []
    for i in range(1, n + 1):
        a, b, p = map(int, input[i].split())
        projects.append((a, b, p))

    # Ordena por data de término
    projects.sort(key=lambda x: x[1])
    end_days = [b for _, b, _ in projects]
    dp = [0] * (n + 1)

    for i in range(1, n + 1):
        a, b, p = projects[i - 1]
        j = bisect_right(end_days, a - 1)
        dp[i] = max(dp[i - 1], dp[j] + p)

    print(dp[n])

if __name__ == "__main__":
    main()