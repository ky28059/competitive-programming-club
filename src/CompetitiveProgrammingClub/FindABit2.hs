import Data.Bits

main = getLine >>= print . countTrailingZeros . (read :: String -> Int)
