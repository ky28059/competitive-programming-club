package main

import (
	"./inputs"
	"./util"
	. "./util"
	"fmt"
	"regexp"
	"strconv"
)

func main() {
	points := []Point[int]{{I: 0, J: 0}}

	for _, line := range inputs.Day18 {
		matches := regexp.MustCompile("([RLUD]) (\\d+) .+").FindStringSubmatch(line)
		instr := matches[1]
		count, _ := strconv.Atoi(matches[2])

		p := points[len(points)-1]

		var i, j int
		switch instr {
		case "R":
			i = p.I
			j = p.J + count
		case "L":
			i = p.I
			j = p.J - count
		case "U":
			i = p.I - count
			j = p.J
		case "D":
			i = p.I + count
			j = p.J
		}

		points = append(points, Point[int]{I: i, J: j})
	}

	fmt.Println(util.ShoelaceCw(points))
}
