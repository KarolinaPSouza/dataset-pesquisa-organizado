import sys
sys.setrecursionlimit(200000)

input = lambda: sys.stdin.readline().strip()

def main():
    n = int(input())

    nums = sorted(list(map(int, input().split()))) + [-1]

    ans = 0
    for i in range(n):
        if nums[i + 1] == nums[i]:
            continue
        else:
            ans += 1

    print(ans)

if __name__ == "__main__":
    main()