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
  (_, rsp)
     <- browse $ do
           setAllowRedirects True
           request $ getRequest ("http://veiset.org:8183/" ++ show i)
  pipe <- runIOE $ connect (M.host "127.0.0.1")
  print i
  putStrLn "Parsing Measures"
  let mms = parseMeasures . B.pack . map c2w . rspBody $ rsp
  if (isNothing mms)
    then do
      putStrLn "Could not parse json from http://veiset.org:8183/"
    else do
      let ms = fromJust mms
      let j = maximum . map time $ ms
      putStrLn ("Putting" ++ show (length ms) ++ "measurements to DB")
      e <- putMeasuresToDB pipe ms
      case e  of
        (Left error) -> print error
        (Right _) -> do
           putStrLn "Done Putting to DB"
           M.close pipe
           P.runCommand "sleep 10" >>= waitForProcess -- Workaround for veiset (noob)
           mainLoop j
