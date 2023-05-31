import Data.List

main = do
  s <- getLine
  putStrLn (if isInfixOf "freshman" s then "YES" else "NO")
