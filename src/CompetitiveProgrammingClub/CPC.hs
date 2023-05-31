main = do
  line <- getLine
  let n = read line
  putStrLn ("C" ++ (concat $ replicate n "PC"))
