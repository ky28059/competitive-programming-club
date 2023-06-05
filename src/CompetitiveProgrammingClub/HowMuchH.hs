main = do
  str <- getLine
  print . length $ filter (\x -> x == 'h') str
