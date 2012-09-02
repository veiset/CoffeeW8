{-# LANGUAGE OverloadedStrings #-}
import Network.Browser
import Network.HTTP
import Data.Maybe
import Data.Aeson
import Database.MongoDB
import qualified Data.HashMap.Strict as M
import qualified Data.Vector as V
import Control.Monad
import qualified Data.ByteString.Lazy as B
import Data.ByteString.Internal(c2w)
import System.Posix.Unistd(sleep)

main = forever $ do
      (_, rsp)
         <- browse $ do
               setAllowRedirects True
               request $ getRequest "http://veiset.org:8183/1"
      pipe <- runIOE $ connect (Database.MongoDB.host "127.0.0.1")
      putToDB pipe . B.pack . map c2w . rspBody $ rsp
      Database.MongoDB.close pipe
      sleep 10

putToDB pipe str = access pipe master "coffeW8" (inp (parseMeasure str))

inp :: Maybe [(Integer,Integer)] -> Action IO ()
inp Nothing = return () --This case should log that the JSON was not parsed
inp (Just xs) = mapM_ 
                  (\(a,b) -> 
                    repsert (select ["time" =: a] "measurements") ["time" =: a, "weight" =: b])
                  xs

parseMeasure :: B.ByteString -> Maybe [(Integer,Integer)]
parseMeasure str =
  decode str >>= liftM V.toList >>= mapM go
   where
   go (Object m) = do
    t <- M.lookup "time" m
    w <- M.lookup "weight" m
    case (fromJSON t,fromJSON w) of
      ((Error _), _) -> Nothing
      (_, (Error _)) -> Nothing
      (Success a, Success b) -> return (a,b)
