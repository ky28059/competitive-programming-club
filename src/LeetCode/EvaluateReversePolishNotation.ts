function evalRPN(tokens: string[]): number {
    const stack = [];

    for (const tok of tokens) {
        switch (tok) {
            case '+':
                const b1 = stack.pop();
                const a1 = stack.pop();
                stack.push(a1 + b1);
                break;
            case '-':
                const b2 = stack.pop();
                const a2 = stack.pop();
                stack.push(a2 - b2);
                break;
            case '*':
                const b3 = stack.pop();
                const a3 = stack.pop();
                stack.push(a3 * b3);
                break;
            case '/':
                const b4 = stack.pop();
                const a4 = stack.pop();
                stack.push(Math.trunc(a4 / b4));
                break;
            default:
                stack.push(Number(tok));
                break;
        }
    }

    return stack[0];
}
