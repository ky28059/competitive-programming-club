package main

import (
	"./inputs"
	"./util"
	"fmt"
	"regexp"
	"strconv"
)

type part struct {
	x, m, a, s int
}

func main() {
	lines := regexp.MustCompile("\r?\n").Split(inputs.Day19[1], -1)
	parts := util.Map(lines, func(l string) part {
		matches := regexp.MustCompile("\\{x=(\\d+),m=(\\d+),a=(\\d+),s=(\\d+)}").FindStringSubmatch(l)
		x, _ := strconv.Atoi(matches[1])
		m, _ := strconv.Atoi(matches[2])
		a, _ := strconv.Atoi(matches[3])
		s, _ := strconv.Atoi(matches[4])

		return part{x, m, a, s}
	})

	// Run all parts through the workflows, filtering out ones that get rejected.
	filtered := util.Filter(parts, func(p part) bool {
		workflow := util.Day19Workflows["in"]
	Outer:
		for {
			for _, c := range workflow.Conditions {
				var count int
				switch c.Field {
				case "x":
					count = p.x
				case "m":
					count = p.m
				case "a":
					count = p.a
				case "s":
					count = p.s
				}

				if (c.Gt && count > c.Count) || (!c.Gt && count < c.Count) {
					switch c.Dest {
					case "R":
						return false
					case "A":
						return true
					default:
						workflow = util.Day19Workflows[c.Dest]
						continue Outer
					}
				}
			}

			switch workflow.Final {
			case "R":
				return false
			case "A":
				return true
			default:
				workflow = util.Day19Workflows[workflow.Final]
			}
		}
	})

	fmt.Println(util.SumOf(filtered, func(p part) int {
		return p.x + p.m + p.a + p.s
	}))
}
