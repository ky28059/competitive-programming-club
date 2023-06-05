main = do
  line <- getLine
  let [x, y] = map read $ words line :: [Int]

  putStrLn $ if 3 * x == 2 * y then "YES" else "NO"
