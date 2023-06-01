stationTimes :: (Int, Int, [Int]) -> [Int]
stationTimes (i, n, l)
  | i == n = l
  | otherwise = do
    -- The distance from `0` or `n - 1`, whichever is closer; also the distance covered twice by the optimal path
    -- between stations.
    let minDist = min i (n - 1 - i)
    stationTimes (i + 1, n, (n - 1 + minDist) : l)

main = do
  line <- getLine
  let n = read line
  
  let times = stationTimes (0, n, [])
  putStrLn . unwords $ map show times
