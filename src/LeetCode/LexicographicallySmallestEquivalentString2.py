class Solution:
    def traverse_uf(self, uf: dict, c: str):
        if c not in uf:
            return c
        c1 = self.traverse_uf(uf, uf[c])
        uf[c] = c1
        return c1

    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        # Union-find structure, where uf['b'] = 'a' means that 'a' and 'b' are equivalent.
        uf = {}

        # Populate the union-find with equivalencies, such that each char points to an equivalent char that is
        # lexicographically less than it. If there is no such equivalent char, it will not be in the UF.
        for i in range(len(s1)):
            if s1[i] == s2[i]:
                continue

            r1 = self.traverse_uf(uf, s1[i])
            r2 = self.traverse_uf(uf, s2[i])

            if r1 == r2:
                continue

            c1 = r1 if r1 < r2 else r2
            c2 = r2 if r1 < r2 else r1

            uf[c2] = c1

        # Map `baseStr` through the UF
        ret = ''
        for c in baseStr:
            ret += self.traverse_uf(uf, c)

        return ret
