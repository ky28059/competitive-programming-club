main = do
  line <- getLine
  let nums = map read $ words line :: [Int]
  let x = head nums
  let y = last nums
  
  putStrLn $ if 3 * x == 2 * y then "YES" else "NO"
