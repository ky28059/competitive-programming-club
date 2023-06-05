main = do
  line <- getLine
  let [a, b, c] = words line

  let duplicated = a == b || a == c || b == c
  putStrLn $ if duplicated then "YES" else "NO"
