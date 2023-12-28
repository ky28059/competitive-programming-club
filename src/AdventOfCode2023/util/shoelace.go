package util

import "math"

func ShoelaceCcw[T Number](points []Point[T]) T {
	return Shoelace(points, true)
}

func ShoelaceCw[T Number](points []Point[T]) T {
	return Shoelace(points, false)
}

func Shoelace[T Number](points []Point[T], ccw bool) (area T) {
	// Append first point for cyclicity
	points = append(points, points[0])

	for i := 1; i < len(points); i++ {
		p1, p2 := points[i-1], points[i]

		if (ccw && p2.J > p1.J) || (!ccw && p1.J > p2.J) {
			area += (p2.I + 1) * T(math.Abs(float64(p2.J-p1.J)))
		} else if (ccw && p2.J < p1.J) || (!ccw && p1.J < p2.J) {
			area -= p2.I * T(math.Abs(float64(p1.J-p2.J)))
		} else if p2.I < p1.I { // Add to area when going up to "push out" sides
			area += p1.I - p2.I
		}
	}
	area++ // Fix off-by-one error
	return
}
