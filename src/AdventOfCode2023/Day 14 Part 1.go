package main

import (
	"./inputs"
	"./util"
	"fmt"
)

func main() {
	m := make([][]uint8, len(inputs.Day14))
	for i := range m {
		m[i] = []uint8(inputs.Day14[i])
	}

	util.RollNorth(m)
	fmt.Println(util.CalculateLoad(m))
}
