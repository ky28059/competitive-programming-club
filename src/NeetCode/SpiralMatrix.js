class Solution {
    /**
     * @param {number[][]} matrix
     * @return {number[]}
     */
    spiralOrder(matrix) {
        const ret = [];

        let dx = 1;
        let dy = 0;
        let i = 0;
        let j = 0;

        while (true) {
            ret.push(matrix[i][j]);
            matrix[i][j] = undefined;

            // Try to advance; if we hit a wall or visited node, rotate
            if (matrix[i + dy]?.[j + dx] === undefined) {
                [dx, dy] = rotateDir(dx, dy);
            }

            // If we hit a wall twice in a row, we've reached the end of the spiral
            if (matrix[i + dy]?.[j + dx] === undefined) {
                break;
            }

            i += dy;
            j += dx;
        }

        return ret;
    }
}

function rotateDir(x, y) {
    if (x === 1 && y === 0) return [0, 1];
    if (x === 0 && y === 1) return [-1, 0];
    if (x === -1 && y === 0) return [0, -1];
    if (x === 0 && y === -1) return [1, 0];
}
