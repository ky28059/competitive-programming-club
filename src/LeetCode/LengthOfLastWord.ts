function lengthOfLastWord(s: string): number {
    return s.match(/([^ ]+)\s*$/)![1].length;
}

function lengthOfLastWord2(s: string): number {
    const words = s.trim().split(/\s+/);
    return words[words.length - 1].length;
}
