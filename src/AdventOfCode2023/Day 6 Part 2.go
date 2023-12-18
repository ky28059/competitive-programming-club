package main

import (
	"./inputs"
	"fmt"
	"math"
	"strconv"
	"strings"
)

func main() {
	_, tAfter, _ := strings.Cut(inputs.Day6[0], "Time:")
	time, _ := strconv.ParseInt(strings.ReplaceAll(tAfter, " ", ""), 10, 64)

	_, dAfter, _ := strings.Cut(inputs.Day6[1], "Distance:")
	distance, _ := strconv.ParseInt(strings.ReplaceAll(dAfter, " ", ""), 10, 64)

	// Distance travelled after holding button for x seconds is given by
	// f(x) = (time - x)(x)
	// -> dist = (time - x)(x)
	// -> 0 = -x^2 + (time)x - dist
	// -> x = (time +- sqrt(time^2 - 4(dist))) / 2
	discriminant := int64(math.Sqrt(float64(time*time - 4*distance)))
	hMax := (time + discriminant) / 2
	hMin := (time - discriminant) / 2
	fmt.Println(hMax - hMin + 1)
}
