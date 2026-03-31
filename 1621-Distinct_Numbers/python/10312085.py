def main():
    import sys

    input = sys.stdin.readline
    print = sys.stdout.write

    n = int(input())
    nums = [int(x) for x in input().strip().split()]

    nums.sort()
    num_changes = 1
    for i in range(1, len(nums)):
        if nums[i] != nums[i-1]:
            num_changes += 1

    print(f"{num_changes}")

if __name__ == "__main__":
    main()