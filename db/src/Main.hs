{-# LANGUAGE OverloadedStrings #-}
module Main where
import Database.MongoDB as M
import Network.Browser
import Network.HTTP
import Data.Maybe
import Data.ByteString.Internal(c2w)
import System.Process as P
import qualified Data.ByteString.Lazy as B
import Measurement
import DBHandling

main = mainLoop 1


mainLoop i = do
  P.runCommand "sleep 10" >>= waitForProcess -- Workaround for veiset (noob)
  (_, rsp)
     <- browse $ do
           setAllowRedirects True
           request $ getRequest ("http://veiset.org:8183/" ++ show i)
  pipe <- runIOE $ connect (M.host "127.0.0.1")
  print "Parsing Measures"
  let mms = parseMeasures . B.pack . map c2w . rspBody $ rsp
  M.close pipe
  if (isNothing mms)
    then do
      putStrLn "Could not parse json from http://veiset.org:8183/"
    else do
      let ms = fromJust mms
      let j = maximum . map time $ ms
      print "Putting to DB"
      putMeasuresToDB pipe ms
      print "Done Putting to DB"
      mainLoop j
