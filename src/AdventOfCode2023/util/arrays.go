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

func Filter[T any](ss []T, test func(T) bool) (ret []T) {
	for _, s := range ss {
		if test(s) {
			ret = append(ret, s)
		}
	}
	return
}

func FindIndex[T any](ss []T, test func(T) bool) int {
	for i, s := range ss {
		if test(s) {
			return i
		}
	}
	return -1
}
