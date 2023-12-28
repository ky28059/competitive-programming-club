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
	points := []Point[int64]{{I: 0, J: 0}}

	for _, line := range inputs.Day18 {
		matches := regexp.MustCompile("([RLUD]) (\\d+) \\(#(.+)\\)").FindStringSubmatch(line)
		instr := matches[3][len(matches[3])-1]
		count, _ := strconv.ParseInt(matches[3][:len(matches[3])-1], 16, 64)

		p := points[len(points)-1]

		var i, j int64
		switch instr {
		case '0':
			i = p.I
			j = p.J + count
		case '2':
			i = p.I
			j = p.J - count
		case '3':
			i = p.I - count
			j = p.J
		case '1':
			i = p.I + count
			j = p.J
		}

		points = append(points, Point[int64]{I: i, J: j})
	}

	fmt.Println(util.ShoelaceCw(points))
}
