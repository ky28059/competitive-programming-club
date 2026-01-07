/**
 * DFS-based solution; BFS may have a better time constant factor
 * but worse space constant factor?
 */
function orangesRotting(grid: number[][]): number {
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            if (grid[i][j] !== 2) continue;
            floodFill(grid, i, j);
        }
    }

    // Check for the maximum time
    let max = 0;
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            if (grid[i][j] === 0) continue;
            if (grid[i][j] === 1) return -1;
            if (grid[i][j] - 10 > max) max = grid[i][j] - 10;
        }
    }
    return max;
}

function floodFill(grid: number[][], i: number, j: number, minute: number = 0) {
    grid[i][j] = 10 + minute;

    if (i > 0 && (grid[i - 1][j] === 1 || grid[i - 1][j] > 10 + minute))
        floodFill(grid, i - 1, j, minute + 1);
    if (i < grid.length - 1 && (grid[i + 1][j] === 1 || grid[i + 1][j] > 10 + minute))
        floodFill(grid, i + 1, j, minute + 1);
    if (j > 0 && (grid[i][j - 1] === 1 || grid[i][j - 1] > 10 + minute))
        floodFill(grid, i, j - 1, minute + 1);
    if (j < grid[0].length - 1 && (grid[i][j + 1] === 1 || grid[i][j + 1] > 10 + minute))
        floodFill(grid, i, j + 1, minute + 1);
}
