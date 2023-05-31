main = do
  line <- getLine
  let nums = map read $ words line :: [Int]
  let a = head nums
  let b = last nums
  
  if rem a 2 == 0
    -- `a` is even:
    -- if `b` is also even, `a + b` cannot ever be odd.
    -- if `b` is odd, `a` and `b` have opposite signs and `a + b` is odd.
    then putStrLn (if rem b 2 == 0 then "oops" else show $ a + b)
  else if rem b 2 /= 0
    -- `a` and `b` are both odd, so `a + b` is even and `a` needs to be added again to make the sum odd.
    then print (2 * a + b)
  else print (a + b)
