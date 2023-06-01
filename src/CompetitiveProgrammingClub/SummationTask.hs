main = do
  line <- getLine
  let nums = words line
  let n = read $ head nums :: Double
  let x = read $ last nums :: Int

  let sum = truncate $ (n + 1) * n / 2
  putStrLn $ if x == sum then "CORRECT" else "INCORRECT"
