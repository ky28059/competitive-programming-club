main = do
  line <- getLine
  let [r, p] = map read $ words line :: [Int]

  let change = truncate $ (fromIntegral $ p - r) / 4
  print (r + change)
