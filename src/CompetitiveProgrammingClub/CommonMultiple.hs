runTests :: Int -> Int -> IO ()
runTests i t
  | i == t = return ()
  | otherwise = do
    line <- getLine
    let [a, b] = map read $ words line :: [Int]

    print (a * b)
    runTests (i + 1) t

main = do
  line <- getLine
  let t = read line :: Int

  runTests 0 t
