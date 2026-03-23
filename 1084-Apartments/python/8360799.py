import math


def first(it):
    return next(iter(it))


def optional_first(it, default=None):
    return next(iter(it), default)


def read_int():
    return int(input())


def read_ints():
    return map(int, input().strip().split())


def read_str():
    return input().strip()


def write_iter(it, sep=" "):
    print(sep.join(map(str, it)))


def main():
    _, _, k = read_ints()
    a = sorted(read_ints())
    b = sorted(read_ints())

    ptr_a, ptr_b = 0, 0
    cc = 0
    while ptr_a < len(a) and ptr_b < len(b):
        if abs(a[ptr_a] - b[ptr_b]) <= k:
            cc += 1
            ptr_a += 1
            ptr_b += 1
        elif ptr_a < len(a) and a[ptr_a] < b[ptr_b]:
            ptr_a += 1
        elif ptr_b < len(b) and a[ptr_a] > b[ptr_b]:
            ptr_b += 1
    print(cc)


if __name__ == '__main__':
    main()