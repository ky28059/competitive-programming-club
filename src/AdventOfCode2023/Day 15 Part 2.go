package main

import (
	"./inputs"
	"./util"
	"fmt"
	"regexp"
	"strconv"
)

type lens struct {
	label       string
	focalLength int
}

func main() {
	// https://stackoverflow.com/questions/34018908/golang-why-dont-we-have-a-set-datastructure
	boxes := make(map[int32][]lens)

	for _, s := range inputs.Day15 {
		matches := regexp.MustCompile("(\\w+)([=-])(\\d?)").FindStringSubmatch(s)
		label := matches[1]
		op := matches[2]
		focalLength, _ := strconv.Atoi(matches[3])

		box := util.LabelHash(label)
		if boxes[box] == nil {
			boxes[box] = make([]lens, 0)
		}

		// Filter out duplicate labelled lenses
		switch op {
		case "-":
			boxes[box] = util.Filter(boxes[box], func(l lens) bool {
				return l.label != label
			})
		case "=":
			i := util.FindIndex(boxes[box], func(l lens) bool {
				return l.label == label
			})
			if i != -1 {
				boxes[box][i].focalLength = focalLength
			} else {
				boxes[box] = append(boxes[box], lens{label, focalLength})
			}
		}
	}

	sum := 0
	for box, lenses := range boxes {
		for i, l := range lenses {
			sum += (int(box) + 1) * (i + 1) * l.focalLength
		}
	}
	fmt.Println(sum)
}
