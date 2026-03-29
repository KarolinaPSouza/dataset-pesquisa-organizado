def main():
    n = int(input())
    compress = {}
    a = [0] * n
    b = [0] * n
    p = [0] * n

    for i in range(n):
        a[i], b[i], p[i] = map(int, input().split())
        b[i] += 1
        compress[a[i]] = 0
        compress[b[i]] = 0

    # Create the compressed coordinates
    coords_list = sorted(compress.keys())
    for idx, key in enumerate(coords_list):
        compress[key] = idx

    # Store projects
    project = [[] for _ in range(len(coords_list))]
    for i in range(n):
        project[compress[b[i]]].append((compress[a[i]], p[i]))

    # Dynamic programming to calculate maximum profit
    dp = [0] * len(coords_list)
    for i in range(len(coords_list)):
        if i > 0:
            dp[i] = dp[i - 1]
        for start, profit in project[i]:
            dp[i] = max(dp[i], dp[start] + profit)

    print(dp[-1])

if __name__ == "__main__":
    main()