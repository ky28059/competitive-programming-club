maxMoves :: String -> Int -> Int -> Int -> Int
maxMoves "" sum i m = sum
maxMoves s sum i m
  | ('W':xs) <- s = maxMoves xs (sum + i - m) (i + 1) (m + 1)
  | otherwise = maxMoves (tail s) sum (i + 1) m

main = do
  str <- getLine
  print $ maxMoves str 0 0 0 -- TODO: this function signature seems a bit extreme...
