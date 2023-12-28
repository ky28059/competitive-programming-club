package util

import (
	"../inputs"
	"regexp"
	"strconv"
	"strings"
)

type cond struct {
	Field string
	Count int
	Dest  string
	Gt    bool
}

type workflow struct {
	Conditions []cond
	Final      string
}

func getWorkflows() map[string]workflow {
	workflows := make(map[string]workflow)

	for _, line := range regexp.MustCompile("\r?\n").Split(inputs.Day19[0], -1) {
		matches := regexp.MustCompile("(\\w+)\\{(.+),(\\w+)}").FindStringSubmatch(line)
		name := matches[1]
		final := matches[3]

		conditions := Map(strings.Split(matches[2], ","), func(t string) cond {
			matches := regexp.MustCompile("(\\w+)([><])(\\d+):(\\w+)").FindStringSubmatch(t)
			field := matches[1]
			gt := matches[2] == ">"
			count, _ := strconv.Atoi(matches[3])
			dest := matches[4]

			return cond{field, count, dest, gt}
		})

		workflows[name] = workflow{conditions, final}
	}

	return workflows
}

var Day19Workflows = getWorkflows()
