main = do
  line <- getLine
  let nums = map read $ words line :: [Int]
  print (head nums + last nums)
