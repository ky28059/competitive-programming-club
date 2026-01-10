class TimeMap {
    private store: Record<string, [string, number][]>;

    constructor() {
        this.store = {};
    }

    set(key: string, value: string, timestamp: number): void {
        if (!this.store[key])
            this.store[key] = [[value, timestamp]];
        else
            // OK since `set` is called with strictly increasing timestamps
            this.store[key].push([value, timestamp]);
    }

    get(key: string, timestamp: number): string {
        const values = this.store[key];
        if (!values || values[0][1] > timestamp) return '';

        // Binary search for the latest timestamp
        let l = 0;
        let r = values.length - 1;

        while (l <= r) {
            const m = Math.floor((l + r) / 2);

            if (values[m][1] === timestamp) return values[m][0];
            if (values[m][1] < timestamp) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return values[l - 1][0];
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * var obj = new TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */
