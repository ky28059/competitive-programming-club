constructPrefixes :: [String] -> String -> [String] -> [String]
constructPrefixes [] str lines = lines
constructPrefixes nums "" lines = constructPrefixes (tail nums) (head nums) (head nums : lines)
constructPrefixes nums str lines = do
  let num = head nums
  let str' = str ++ " " ++ num
  
  constructPrefixes (tail nums) str' (str' : lines)

main = do
  line1 <- getLine
  line2 <- getLine
  let nums = words line2
  
  putStr . unlines $ constructPrefixes nums "" []
