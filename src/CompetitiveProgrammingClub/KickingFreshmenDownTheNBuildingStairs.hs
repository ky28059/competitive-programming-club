calcDrinks :: (Int, Int, [Int]) -> Int
calcDrinks (str, drinks, weights)
  | weights == [] = drinks
  | otherwise = do
    let weight = head weights
    let reqDrinks = max (weight - str) 0 -- Required drink consumption to kick the freshman, or 0 if you have ample strength

    -- New strength = old strength + energy drinks consumed - 1 (for kicking the freshman)
    calcDrinks (str + reqDrinks - 1, drinks + reqDrinks, tail weights)

runTests :: (Int, Int) -> IO ()
runTests (i, t)
  | i == t = return ()
  | otherwise = do
    line1 <- getLine
    line2 <- getLine
    let weights = map read $ words line2 :: [Int]

    print $ calcDrinks (0, 0, weights)
    runTests (i + 1, t)

main = do
  line <- getLine
  let t = read line :: Int

  runTests (0, t)
