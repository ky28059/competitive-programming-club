function findAllRecipes(recipes: string[], ingredients: string[][], supplies: string[]): string[] {
    const adjList = {};
    const inDeg = {};

    for (let i = 0; i < recipes.length; i++) {
        for (const u of ingredients[i]) {
            if (!adjList[u]) adjList[u] = [];
            adjList[u].push(recipes[i]);
        }

        inDeg[recipes[i]] = ingredients[i].length;
    }

    const queue = [];

    // Traverse all starter ingredients
    for (const s of supplies) {
        if (!adjList[s]) continue;

        for (const r of adjList[s]) {
            inDeg[r]--;
            if (inDeg[r] === 0) queue.push(r);
        }
    }

    // Traverse all 0-dependency recipes until we run out
    for (let i = 0; i < queue.length; i++) {
        if (!adjList[queue[i]]) continue;

        for (const r of adjList[queue[i]]) {
            inDeg[r]--;
            if (inDeg[r] === 0) queue.push(r);
        }
    }

    return queue;
}
