main = do
  line <- getLine
  let num = read line :: Integer
  print (num - 1)
