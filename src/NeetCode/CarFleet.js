class Solution {
    /**
     * @param {number} target
     * @param {number[]} position
     * @param {number[]} speed
     * @return {number}
     */
    carFleet(target, position, speed) {
        const indices = Array(position.length)
            .fill(0)
            .map((_, i) => i)
            .sort((a, b) => position[b] - position[a]);
        const times = indices.map((i) => (target - position[i]) / speed[i]);

        let fleets = 1;
        let curr = times[0];
        for (const t of times) {
            if (t <= curr) continue;

            fleets++;
            curr = t;
        }

        return fleets;
    }
}
