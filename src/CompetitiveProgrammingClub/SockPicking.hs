containsSockPair :: String -> Bool -> Bool
containsSockPair "" detected = False
containsSockPair l detected
  | ('L':xs) <- l = containsSockPair xs True -- If we have a left sock, set detected to true
  | detected = True -- If we already have a left sock and we are currently at a right sock, we have a pair!
  | otherwise = containsSockPair (tail l) detected -- If we have a right sock but no left sock yet, keep looking

main = do
  line <- getLine
  socks <- getLine
  putStrLn $ if containsSockPair socks False then "YES" else "NO"
