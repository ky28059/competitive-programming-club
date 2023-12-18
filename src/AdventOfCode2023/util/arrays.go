package util

import "strconv"

func MapToInt(vs []string) []int {
	vsm := make([]int, len(vs))
	for i, v := range vs {
		vsm[i], _ = strconv.Atoi(v)
	}
	return vsm
}

func Map[T, V any](ts []T, fn func(T) V) []V {
	result := make([]V, len(ts))
	for i, t := range ts {
		result[i] = fn(t)
	}
	return result
}
