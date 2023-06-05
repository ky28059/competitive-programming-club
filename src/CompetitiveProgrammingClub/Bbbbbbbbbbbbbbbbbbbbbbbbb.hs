import Data.Char

main = do
  line <- getLine
  let [n, x] = map read $ words line :: [Int]

  let char = chr $ 96 + x
  putStrLn $ replicate n char
