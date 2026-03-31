"""
https://cses.fi/problemset/task/1619
"""


from typing import Iterable, List, Tuple


Times = Iterable[Tuple[int, int]]


def main(times: Times) -> int:
    """
    >>> main([(5, 8), (2, 4), (3, 9)])
    2
    """
    events: List[Tuple[int, int]] = []
    for s, e in times:
        events.append((s, 1))
        events.append((e, -1))
    events = sorted(events, key=lambda it: it[0])

    mx = 0
    count = 0
    for _, delta in events:
        count += delta
        if count > mx:
            mx = count

    return mx


def _read_int_list() -> Tuple[int, int]:
    pp = input().split(" ")
    return (int(pp[0]), int(pp[1]))


if __name__ == "__main__":
    n = int(input())
    print(main(_read_int_list() for _ in range(n)))