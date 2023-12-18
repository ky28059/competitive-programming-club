package main

import (
	"./inputs"
	"./util"
	"fmt"
	"regexp"
	"slices"
	"strings"
)

// https://stackoverflow.com/questions/13670818/pair-tuple-data-type-in-go
type lenRange struct {
	start  int
	length int
}

func main() {
	_, after, _ := strings.Cut(inputs.Day5[0], "seeds: ")
	seeds := util.MapToInt(strings.Split(after, " "))
	var ranges []lenRange

	for i := 0; i < len(seeds); i += 2 {
		start, length := seeds[i], seeds[i+1]
		ranges = append(ranges, lenRange{start, length})
	}

	for i := 1; i < len(inputs.Day5); i++ {
		ranges = mapSeedRanges(ranges, inputs.Day5[i])
	}

	fmt.Println(slices.Min(util.Map(ranges, func(r lenRange) int {
		return r.start
	})))
}

func mapSeedRanges(ranges []lenRange, m string) []lenRange {
	// https://stackoverflow.com/questions/34259800/is-there-a-built-in-min-function-for-a-slice-of-int-arguments-or-a-variable-numb/76531109#76531109
	ret := make([]lenRange, len(ranges))
	copy(ret, ranges)

	for _, line := range regexp.MustCompile("\r?\n").Split(m, -1) {
		instr := util.MapToInt(strings.Split(line, " "))
		fmt.Println(instr)

		for i, seedRange := range ranges {
			intStart := max(seedRange.start, instr[1])
			intEnd := min(seedRange.start+seedRange.length, instr[1]+instr[2])
			intLength := intEnd - intStart

			if intLength > 0 {
				// Map intersection to new range
				// TODO: remove original slice in array as well
				ret[i] = lenRange{
					start:  instr[0] + intStart - instr[1],
					length: intLength,
				}

				// Keep unintersected range edges
				// TODO: remove original slice in array as well
				if intStart > seedRange.start {
					excluded := lenRange{start: seedRange.start, length: intStart - seedRange.start - 1}
					ret = append(ret, excluded)
					ranges = append(ranges, excluded)
				}
				if intEnd < seedRange.start+seedRange.length {
					excluded := lenRange{start: intEnd + 1, length: seedRange.start + seedRange.length - intEnd - 1}
					ret = append(ret, excluded)
					ranges = append(ranges, excluded)
				}

				fmt.Println(ret)
			}
		}
	}
	return ret
}
