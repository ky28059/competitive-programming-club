package util

import "strconv"

func MapToInt(vs []string) []int {
	vsm := make([]int, len(vs))
	for i, v := range vs {
		vsm[i], _ = strconv.Atoi(v)
	}
	return vsm
}
