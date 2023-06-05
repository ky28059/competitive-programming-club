main = do
  line <- getLine
  let [a, b] = map read $ words line :: [Int]

  if b == 0
    then putStrLn "INFINITY"
  else print $ div a b
