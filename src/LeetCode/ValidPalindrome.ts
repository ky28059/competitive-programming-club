function isPalindrome(s: string): boolean {
    let start = 0;
    let end = s.length - 1;

    const wr = /[A-Za-z0-9]/;

    while (true) {
        while (!wr.test(s[start])) start++;
        while (!wr.test(s[end])) end--;

        if (start >= end) return true;
        if (s[start].toLowerCase() !== s[end].toLowerCase()) return false;

        start++;
        end--;
    }
}
