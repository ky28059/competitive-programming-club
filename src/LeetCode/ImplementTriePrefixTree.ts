const EOF = '';

class Trie {
    private root: Record<string, any>;

    constructor() {
        this.root = {};
    }

    insert(word: string): void {
        let curr = this.root;

        for (let i = 0; i < word.length; i++) {
            if (!curr[word[i]]) curr[word[i]] = {};
            curr = curr[word[i]];
        }

        curr[EOF] = true;
    }

    search(word: string): boolean {
        let curr = this.root;

        for (let i = 0; i < word.length; i++) {
            curr = curr[word[i]];
            if (!curr) return false;
        }

        return !!curr[EOF];
    }

    startsWith(prefix: string): boolean {
        let curr = this.root;

        for (let i = 0; i < prefix.length; i++) {
            curr = curr[prefix[i]];
            if (!curr) return false;
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
