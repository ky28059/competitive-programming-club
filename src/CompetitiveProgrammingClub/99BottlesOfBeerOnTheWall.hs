main = do
  line <- getLine
  let n = read line :: Int
  putStrLn $ (show n) ++ " bottles of beer on the wall, " ++ (show n) ++ " bottles of beer, take one down, pass it around, " ++ (show $ n - 1) ++ " bottles of beer on the wall!"
