{-# LANGUAGE OverloadedStrings #-}
module Measurement where
import Data.Aeson
import Data.Bson
import qualified Data.HashMap.Strict as M
import qualified Data.Vector as V
import qualified Data.ByteString.Lazy as B
import Control.Monad

data Measurement = M {
  time :: Integer,
  weight ::Integer
  } deriving (Show,Eq,Ord)

mToJson :: Measurement -> Document 
mToJson m  = ["_id" =: time m, "weight" =: weight m]

parseMeasures :: B.ByteString -> Maybe [Measurement]
parseMeasures str =
  decode str >>= liftM V.toList >>= mapM go
   where
   go (Object m) = do
    t <- M.lookup "time" m
    w <- M.lookup "weight" m
    case (fromJSON t,fromJSON w) of
      ((Error _), _) -> Nothing
      (_, (Error _)) -> Nothing
      (Success a, Success b) -> return (M a b)

