runTests :: (Int, Int) -> IO ()
runTests (i, t)
  | i == t = return ()
  | otherwise = do
    line <- getLine
    let nums = map read $ words line :: [Int]

    let a = head nums
    let b = last nums
    print (a * b)

    runTests (i + 1, t)

main = do
  line <- getLine
  let t = read line :: Int

  runTests (0, t)
