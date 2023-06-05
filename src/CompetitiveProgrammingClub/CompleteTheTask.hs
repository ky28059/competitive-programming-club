import Data.Bits

runTasks :: Int -> [Int] -> IO ()
runTasks s [_] = return ()
runTasks s l = do
  let a = head l
  let b = head $ tail l

  let s' = s - a + (a `xor` b)
  print $ s'
  runTasks s' (tail l)

main = do
  line1 <- getLine
  line2 <- getLine
  
  let n = read line1 :: Int
  let nums = map read $ words line2 :: [Int]
  
  runTasks (sum nums) nums
