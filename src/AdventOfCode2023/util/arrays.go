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

type Number interface {
	~int | ~int8 | ~int16 | ~int32 | ~int64 | ~uint | ~uint8 | ~uint16 | ~uint32 | ~uint64 | ~float32 | ~float64
}

func SumOf[T any, V Number](ss []T, fn func(T) V) (sum V) {
	for _, s := range ss {
		sum += fn(s)
	}
	return
}
