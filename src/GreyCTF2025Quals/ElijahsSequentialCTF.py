def reward_for_transition(a: int, b: int):
    if a == 0 and b == 1:
        return 2
    elif a == 0 and b == 2:
        return 3
    elif a == 1 and b == 0:
        return 4
    elif a == 1 and b == 2:
        return 5
    elif a == 2 and b == 0:
        return 1
    elif a == 2 and b == 1:
        return 6
    return 0


if __name__ == '__main__':
    s = int(input())
    challs = [int(x) for x in input().split(' ')]

    # Conjecture: you never need to skip more than one problem in a row. Thus, we just consider the satisfaction
    # from going directly from the previous problem, vs. skipping the previous problem and going from the
    # 2nd previous.

    s1 = 0
    s2 = 0
    c1 = challs[0]
    c2 = challs[0]

    for c in challs[1:]:
        if c == c2:
            continue

        if s2 == 0:
            # Initialize first transition if we haven't already
            s2 = reward_for_transition(c2, c)
        else:
            new = max(
                s1 + reward_for_transition(c1, c),
                s2 + reward_for_transition(c2, c)
            )
            s1 = s2
            s2 = new

        c1 = c2
        c2 = c

    print(s2)
