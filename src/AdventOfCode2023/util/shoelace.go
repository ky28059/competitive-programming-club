package util

func Shoelace(points []Point) (area int) {
	// Append first point for cyclicity
	points = append(points, points[0])

	for i := 1; i < len(points); i++ {
		p1, p2 := points[i-1], points[i]

		if p2.J > p1.J {
			area += p2.I + 1
		} else if p2.J < p1.J {
			area -= p2.I
		} else if p2.I < p1.I { // Add to area when going up to "push out" sides
			area += p1.I - p2.I
		}
	}
	area++ // Fix off-by-one error
	return
}
