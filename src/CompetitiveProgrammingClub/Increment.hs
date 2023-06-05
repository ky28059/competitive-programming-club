checkSequence :: Int -> [Int] -> Bool
checkSequence prev [] = True
checkSequence prev seq = do
  let num = head seq
  if (num /= prev + 1)
    then False
  else checkSequence num (tail seq)

main = do
  line1 <- getLine
  line2 <- getLine
  let (x:xs) = map read $ words line2 :: [Int]

  putStrLn $ if checkSequence x xs then "YES" else "NO"
