package main

import (
	"./inputs"
	"./util"
	"fmt"
	"reflect"
)

func main() {
	m := make([][]uint8, len(inputs.Day14))
	for i := range m {
		m[i] = []uint8(inputs.Day14[i])
	}

	var states [][][]uint8

	for {
		util.RollNorth(m)
		util.RollWest(m)
		util.RollSouth(m)
		util.RollEast(m)

		// Loop until the cycles stabilize and calculate the period; then, skip all duplicated cycles and run only
		// the remainder.
		for i, state := range states {
			if reflect.DeepEqual(m, state) {
				period := len(states) - i
				fmt.Println("States", i, len(states), "are equal with period", period)

				rem := (1000000000 - i - 1) % period
				for j := 0; j < rem; j++ {
					util.RollNorth(m)
					util.RollWest(m)
					util.RollSouth(m)
					util.RollEast(m)
				}
				fmt.Println(util.CalculateLoad(m))
				return
			}
		}

		// Deep clone the matrix and append it to previous states
		cloned := make([][]uint8, len(m))
		for i, l := range m {
			cloned[i] = append([]uint8{}, l...)
		}
		states = append(states, cloned)
	}
}
