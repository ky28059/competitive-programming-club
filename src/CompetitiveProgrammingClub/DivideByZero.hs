main = do
  line <- getLine
  let nums = map read $ words line :: [Double]
  let a = head nums
  let b = last nums
  
  if b == 0
    then putStrLn "INFINITY"
  else print . truncate $ a / b
