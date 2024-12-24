from z3 import BitVec, Solver

# The program decompiles to:
# regB = (regA % 8) xor 1
# regC = regA / 2^regB
# regB = (regB xor 5) xor regC
# regA = regA / 8
# output regB % 8
# jnz 0

# Then, we have the following system:
# 2 = (((regA % 8) ^ 4) ^ (regA >> ((regA % 8) ^ 1)))) % 8
# 4 = ((((regA >> 3) % 8) ^ 4) ^ ((regA >> 3) >> (((regA >> 3) % 8) ^ 1))) % 8
# 1 = ((((regA >> 6) % 8) ^ 4) ^ ((regA >> 6) >> (((regA >> 6) % 8) ^ 1))) % 8
# 1 = ((((regA >> 9) % 8) ^ 4) ^ ((regA >> 9) >> (((regA >> 9) % 8) ^ 1))) % 8
# 7 = ((((regA >> 12) % 8) ^ 4) ^ ((regA >> 12) >> (((regA >> 12) % 8) ^ 1))) % 8
# 5 = ((((regA >> 15) % 8) ^ 4) ^ ((regA >> 15) >> (((regA >> 15) % 8) ^ 1))) % 8
# 1 = ((((regA >> 18) % 8) ^ 4) ^ ((regA >> 18) >> (((regA >> 18) % 8) ^ 1))) % 8
# 5 = ((((regA >> 21) % 8) ^ 4) ^ ((regA >> 21) >> (((regA >> 21) % 8) ^ 1))) % 8
# ...

prog = [2, 4, 1, 1, 7, 5, 1, 5, 4, 5, 0, 3, 5, 5, 3, 0]

s = Solver()
a = BitVec('a', 3 * len(prog) + 20)

for i in range(len(prog)):
    offset = 3 * i
    s.add(((((a >> offset) % 8) ^ 4) ^ ((a >> offset) >> (((a >> offset) % 8) ^ 1))) % 8 == prog[i])

s.add(a >> 48 == 0)

print(s.units())
print(s.check())
print(s.model())
