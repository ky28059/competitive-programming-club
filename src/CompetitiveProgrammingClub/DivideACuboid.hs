main = do
  line <- getLine
  let [x, y, z] = map read $ words line :: [Int]
  
  print $ if rem x 2 == 0 || rem y 2 == 0 || rem z 2 == 0
    then 0
  else min (x * y) $ min (y * z) (x * z)
