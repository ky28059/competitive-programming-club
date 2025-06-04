#include <iostream>

int reward_for_transition(int a, int b) {
    if (a == 0 && b == 1)
        return 2;
    else if (a == 0 && b == 2)
        return 3;
    else if (a == 1 && b == 0)
        return 4;
    else if (a == 1 && b == 2)
        return 5;
    else if (a == 2 && b == 0)
        return 1;
    else if (a == 2 && b == 1)
        return 6;
    return 0;
}

int main() {
    int s;
    std::cin >> s;

    // Conjecture: you never need to skip more than one problem in a row. Thus, we just consider the satisfaction
    // from going directly from the previous problem, vs. skipping the previous problem and going from the
    // 2nd previous.

    int s1 = 0;
    int s2 = 0;
    int c1;
    std::cin >> c1;
    int c2 = c1;

    for (int i = 1; i < s; i++) {
        int c;
        std::cin >> c;

        if (c == c2) continue;

        if (s2 == 0) {
            // Initialize first transition if we haven't already
            s2 = reward_for_transition(c2, c);
        } else {
            int n = std::max(
                s1 + reward_for_transition(c1, c),
                s2 + reward_for_transition(c2, c)
            );
            s1 = s2;
            s2 = n;
        }

        c1 = c2;
        c2 = c;
    }

    std::cout << s2 << std::endl;
}
