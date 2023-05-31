runTests :: (Int, Int) -> IO ()
runTests (i, t)
  | i == t = return ()
  | otherwise = do
    line1 <- getLine
    line2 <- getLine

    let x = read $ last $ words line1 :: Int
    let throws = map read $ words line2 :: [Int]

    print $ sum $ map (\throw -> abs $ x - throw) throws
    runTests (i + 1, t)

main = do
  line <- getLine
  let t = read line
  
  runTests (0, t)
