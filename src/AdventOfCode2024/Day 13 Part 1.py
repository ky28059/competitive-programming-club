import re

import numpy as np


with open('./day13.in') as f:
    groups = [
        re.match(r'Button A: X\+(\d+), Y\+(\d+)\nButton B: X\+(\d+), Y\+(\d+)\nPrize: X=(\d+), Y=(\d+)', l).groups()
        for l in f.read().split('\n\n')
    ]

sum = 0

for ax, ay, bx, by, tx, ty in groups:
    (x,), (y,) = np.linalg.solve(
        np.array([[int(ax), int(bx)], [int(ay), int(by)]]),
        np.array([[int(tx)], [int(ty)]])
    )

    # Discard non-solved equations, accounting for floating point errors
    if 0.9999 > x % 1 > 0.0001 or 0.9999 > y % 1 > 0.0001:
        continue

    a, b = round(x), round(y)
    sum += a * 3 + b

print(sum)
