import Data.Bits

main = do
  line <- getLine
  let x = read line :: Int

  print $ popCount x
