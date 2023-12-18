package main

import (
	"./inputs"
	"./util"
	"fmt"
	"regexp"
	"slices"
	"strings"
)

func main() {
	_, after, _ := strings.Cut(inputs.Day5[0], "seeds: ")
	seeds := util.MapToInt(strings.Split(after, " "))

	for i := 1; i < len(inputs.Day5); i++ {
		seeds = mapSeeds(seeds, inputs.Day5[i])
	}

	fmt.Println(slices.Min(seeds))
}

func mapSeeds(seeds []int, m string) []int {
	// https://stackoverflow.com/questions/34259800/is-there-a-built-in-min-function-for-a-slice-of-int-arguments-or-a-variable-numb/76531109#76531109
	ret := make([]int, len(seeds))
	copy(ret, seeds)

	for _, line := range regexp.MustCompile("\r?\n").Split(m, -1) {
		instr := util.MapToInt(strings.Split(line, " "))

		for i, seed := range seeds {
			if seed >= instr[1] && seed < instr[1]+instr[2] {
				diff := seed - instr[1]
				ret[i] = instr[0] + diff
			}
		}
	}
	return ret
}
