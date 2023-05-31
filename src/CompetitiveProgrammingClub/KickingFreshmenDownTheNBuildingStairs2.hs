main = do
  line <- getLine
  let ids = words line

  let a = head ids
  let b = head $ tail ids
  let c = last ids
  
  let duplicated = a == b || a == c || b == c
  putStrLn (if duplicated then "YES" else "NO")
