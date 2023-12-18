package main

import (
	"./inputs"
	"./util"
	"fmt"
	"regexp"
	"strings"
)

func main() {
	_, tAfter, _ := strings.Cut(inputs.Day6[0], "Time:")
	times := util.MapToInt(regexp.MustCompile("\\s+").Split(strings.TrimSpace(tAfter), -1))

	_, dAfter, _ := strings.Cut(inputs.Day6[1], "Distance:")
	distances := util.MapToInt(regexp.MustCompile("\\s+").Split(strings.TrimSpace(dAfter), -1))

	product := 1
	for i, time := range times {
		unique := 0
		distance := distances[i]

		for i := 0; i <= time; i++ {
			// Distance travelled after holding button for x seconds is given by
			// f(x) = (time - x)(x)
			d := (time - i) * i
			if d > distance {
				unique++
			}
		}

		product *= unique
	}
	fmt.Println(product)
}
