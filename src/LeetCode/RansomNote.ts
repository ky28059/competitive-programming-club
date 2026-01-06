function canConstruct(ransomNote: string, magazine: string): boolean {
    const counts: Record<string, number> = {};

    for (const c of magazine) {
        if (!counts[c]) counts[c] = 1;
        else counts[c]++;
    }

    for (const c of ransomNote) {
        if (!counts[c]) return false;
        counts[c]--;
    }

    return true;
}
