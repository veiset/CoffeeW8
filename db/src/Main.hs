{-# LANGUAGE OverloadedStrings, DeriveDataTypeable #-}
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
import System.Console.CmdArgs

data AppConfig = AppConfig {
  runOnce :: Bool,
  listenDomain :: String,
  interval :: Int
} deriving (Show, Data, Typeable)

appconfig = AppConfig {
  runOnce = False  &= help "When given the values are only queried for once",
  listenDomain = "http://veiset.org:8183/" &= typ "DOMAIN", -- &= name "DOMAIN" &= argPos 0 ,
  interval = 10 &= help "The number of to wait before requerying the values"
} &= summary "CoffeW8DB v 0.1" &= program "coffeW8DB"

main = do 
  inp <- cmdArgs appconfig
  let domain = listenDomain inp
  let intrv = interval inp
  if runOnce inp 
   then
    mainBody 1 domain intrv (const (return ()))
   else
    mainLoop domain intrv 1

mainBody t domain intrv callback = do
  (_, rsp)
     <- browse $ do
           setAllowRedirects True
           request $ getRequest (domain ++ show t)
  pipe <- runIOE $ connect (M.host "127.0.0.1")
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
           P.runCommand ("sleep " ++ show intrv) >>= waitForProcess -- Workaround for veiset (noob)
           callback j

mainLoop domain intrv t = mainBody t domain intrv (mainLoop domain intrv)
