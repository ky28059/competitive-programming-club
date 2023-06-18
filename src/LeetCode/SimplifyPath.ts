function simplifyPath(path: string): string {
    const segments = path.split('/');
    const parsed = [];

    for (const segment of segments) {
        if (!segment) continue;
        if (segment === '.') continue;
        if (segment === '..') parsed.pop();
        else parsed.push(segment);
    }

    return '/' + parsed.join('/');
}
