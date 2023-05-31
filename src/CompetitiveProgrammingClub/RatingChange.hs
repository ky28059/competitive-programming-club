main = do
  line <- getLine
  let nums = words line
  
  let r = read $ head nums :: Int
  let p = read $ last nums :: Int

  let change = truncate $ (fromIntegral $ p - r) / 4
  print (r + change)
