class MinStack {
    size: number;
    stack: number[];
    mins: number[];

    constructor() {
        this.size = 0;
        this.stack = [];
        this.mins = [];
    }

    push(val: number): void {
        this.stack[this.size] = val;
        this.mins[this.size] = this.size === 0
            ? val
            : Math.min(val, this.mins[this.size - 1]);

        this.size++;
    }

    pop(): void {
        this.size--;
    }

    top(): number {
        return this.stack[this.size - 1];
    }

    getMin(): number {
        return this.mins[this.size - 1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
