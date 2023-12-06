package main

import (
	"./inputs"
	"./util"
	"fmt"
	"slices"
	"strings"
)

func main() {
	_, after, _ := strings.Cut(inputs.Day5[0], "seeds: ")
	seeds := util.MapToInt(strings.Split(after, " "))

	seeds = util.MapSeeds(seeds)
	fmt.Println(slices.Min(seeds))
}
