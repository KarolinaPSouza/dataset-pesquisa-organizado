import sys

def number_spiral(y, x):
    max_side = max(y, x)
    max_val = max_side * max_side  # Bottom-right value of the layer

    if max_side % 2 == 0:
        if y == max_side:
            return max_val - (x - 1)
        else:
            return max_val - (max_side - 1) - (max_side - y)
    else:
        if x == max_side:
            return max_val - (y - 1)
        else:
            return max_val - (max_side - 1) - (max_side - x)

# Read input efficiently
t = int(sys.stdin.readline().strip())
results = []

for _ in range(t):
    y, x = map(int, sys.stdin.readline().split())
    results.append(str(number_spiral(y, x)))

# Print all results at once for efficiency
sys.stdout.write("\n".join(results) + "\n")