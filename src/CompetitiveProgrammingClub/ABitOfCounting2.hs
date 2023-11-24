import Data.Bits

main = getLine >>= print . popCount . (read :: String -> Int)
