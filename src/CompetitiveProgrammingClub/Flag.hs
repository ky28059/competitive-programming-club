checkFlag :: (Int, Int, Char) -> IO (Bool)
checkFlag (i, n, prevColor)
  | i == n = return (True)
  | otherwise = do
    stripe <- getLine
    let color = head stripe
    
    -- Fail if the stripe is the same color as the one above it, or not all colors in the stripe are the same.
    if color == prevColor || (not $ all (== color) (tail stripe))
      then return (False)
    else checkFlag (i + 1, n, color)

main = do
  line <- getLine
  let n = read . head $ words line :: Int

  valid <- checkFlag (0, n, 'a')
  putStrLn $ if valid then "YES" else "NO"
