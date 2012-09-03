{-# LANGUAGE OverloadedStrings #-}
module DBHandling where
import Database.MongoDB
import Control.Monad
import Measurement


-- Sends the Measurement down the Pipe
putMeasuresToDB :: Pipe -> [Measurement] -> IO (Either Failure ())
putMeasuresToDB pipe xs = access pipe master "coffeW8" (inp xs)

--The action that inputs the list of measurements into the the database
inp :: [Measurement] -> Action IO ()
inp = mapM_ (\ a -> repsert (select ["time" =: time a] "measurements") . mToJson $ a)
