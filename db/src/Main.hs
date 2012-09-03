{-# LANGUAGE OverloadedStrings #-}
module Main where
import Database.MongoDB as M
import Network.Browser
import Network.HTTP
import Data.Maybe
import Data.ByteString.Internal(c2w)
import System.Posix.Unistd(sleep)
import qualified Data.ByteString.Lazy as B
import System.Posix.Signals (installHandler, Handler(Catch), sigINT, sigTERM)
import Control.Concurrent.MVar (modifyMVar_, newMVar, withMVar, MVar)
import Measurement
import DBHandling

main = mainLoop 1


mainLoop i = do
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
      sleep 10
      mainLoop j
