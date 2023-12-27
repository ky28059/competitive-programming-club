package main

import (
	"./inputs"
	"./util"
	"fmt"
	"strings"
)

func main() {
	fmt.Println(util.SumOf(inputs.Day9, func(line string) int {
		nums := util.MapToInt(strings.Split(line, " "))
		states := [][]int{nums}

		// While the last state isn't all the same number, keep getting the diffs and appending to the state
		for !util.AllSame(states[len(states)-1]) {
			lastState := states[len(states)-1]

			newState := make([]int, len(lastState)-1)
			for i := 1; i < len(lastState); i++ {
				newState[i-1] = lastState[i] - lastState[i-1]
			}

			states = append(states, newState)
		}

		// Work back up to predict new value
		diff := 0
		for i := len(states) - 1; i >= 0; i-- {
			state := states[i]
			diff += state[len(state)-1]
		}

		return diff
	}))
}
