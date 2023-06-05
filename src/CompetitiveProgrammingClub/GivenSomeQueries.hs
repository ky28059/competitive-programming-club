import Data.IntSet (IntSet)
import qualified Data.IntSet as IntSet

processQueries :: IntSet -> Int -> Int -> IO ()
processQueries s i q
  | i == q = return ()
  | otherwise = do
    line <- getLine
    let [t, x] = map read $ words line :: [Int]

    if t == 1
      then processQueries (IntSet.insert x s) (i + 1) q
    else do
      print $ case IntSet.lookupGE x s of
        Just x -> x
        Nothing -> -1

      processQueries s (i + 1) q

main = do
  line <- getLine
  let q = read line :: Int

  processQueries IntSet.empty 0 q
