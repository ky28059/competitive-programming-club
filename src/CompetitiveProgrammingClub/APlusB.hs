main = do
  line <- getLine
  let nums = map read $ words line
  print (head nums + last nums)
