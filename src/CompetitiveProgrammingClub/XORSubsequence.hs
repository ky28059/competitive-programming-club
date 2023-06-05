import Data.List

runTests :: (Int, Int) -> IO ()
runTests (i, t)
  | i == t = return ()
  | otherwise = do
    line1 <- getLine
    line2 <- getLine

    let sequence = map read $ words line2 :: [Int]
    print . length $ nub sequence

    runTests (i + 1, t)

main = do
  line <- getLine
  let t = read line

  runTests (0, t)
