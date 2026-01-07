function numIslands(grid: string[][]): number {
    let islands = 0;

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            if (grid[i][j] === '0') continue;

            floodFill(grid, i, j);
            islands++;
        }
    }

    return islands;
}

function floodFill(grid: string[][], i: number, j: number) {
    grid[i][j] = '0';

    if (i > 0 && grid[i - 1][j] !== '0')
        floodFill(grid, i - 1, j);
    if (i < grid.length - 1 && grid[i + 1][j] !== '0')
        floodFill(grid, i + 1, j);
    if (j > 0 && grid[i][j - 1] !== '0')
        floodFill(grid, i, j - 1);
    if (j < grid[0].length - 1 && grid[i][j + 1] !== '0')
        floodFill(grid, i, j + 1);
}
