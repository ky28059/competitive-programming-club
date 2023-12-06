package util

import (
	"../inputs"
	"regexp"
	"strings"
)

func MapSeeds(s []int) (seeds []int) {
	seeds = s
	for i := 1; i < len(inputs.Day5); i++ {
		seeds = applyMapping(seeds, inputs.Day5[i])
	}
	return
}

func applyMapping(seeds []int, m string) []int {
	// https://stackoverflow.com/questions/34259800/is-there-a-built-in-min-function-for-a-slice-of-int-arguments-or-a-variable-numb/76531109#76531109
	ret := make([]int, len(seeds))
	copy(ret, seeds)

	for _, line := range regexp.MustCompile("\r?\n").Split(m, -1) {
		instr := MapToInt(strings.Split(line, " "))

		for i, seed := range seeds {
			if seed >= instr[1] && seed < instr[1]+instr[2] {
				diff := seed - instr[1]
				ret[i] = instr[0] + diff
			}
		}
	}
	return ret
}
