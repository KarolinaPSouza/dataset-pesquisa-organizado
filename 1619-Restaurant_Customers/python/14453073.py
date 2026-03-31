import sys


def main():
    data = sys.stdin.read().split()
    if not data:
        return

    n = int(data[0])
    starts = []
    ends = []

    index = 1
    for i in range(n):
        a = int(data[index])
        b = int(data[index + 1])
        starts.append(a)
        ends.append(b)
        index += 2

    starts.sort()
    ends.sort()

    i, j = 0, 0
    max_count, cur_count = 0, 0

    while i < n:
        if starts[i] <= ends[j]:
            cur_count += 1
            if cur_count > max_count:
                max_count = cur_count
            i += 1
        else:
            cur_count -= 1
            j += 1

    print(max_count)


if __name__ == "__main__":
    main()