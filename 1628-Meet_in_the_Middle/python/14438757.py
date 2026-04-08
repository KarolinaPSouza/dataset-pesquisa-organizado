import sys
from collections import Counter

def gerar_somas(arr):
    somas = [0]
    for num in arr:
        somas.extend([s + num for s in somas])
    return somas

def main():
    try:
        data = sys.stdin.read().split()
        n = int(data[0])
        x = int(data[1])
        arr = list(map(int, data[2:2+n]))
    except (IndexError, ValueError) as e:
        return
    metade1 = arr[:n//2]
    metade2 = arr[n//2:]
    somas1 = gerar_somas(metade1)
    somas2 = gerar_somas(metade2)
    counts2 = Counter(somas2)
    total_ways = 0
    for s1 in somas1:
        alvo = x - s1
        total_ways += counts2[alvo]

    print(total_ways)

if __name__ == "__main__":
    main()