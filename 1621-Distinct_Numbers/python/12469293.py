import sys

def main():
    data = sys.stdin.read().split()
    print(len(set(data[1:])))

main()