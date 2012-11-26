require 'sinatra'
require 'mongo'
require 'json'
require 'erb'

mongodb  = 'mongodb://localhost:27017'
database = 'coffeeW8'

get '/api/since/:unixtime' do |ut|
    connection = Mongo::Connection.from_uri(mongodb)
    db = connection.db(database)
    puts ut
    data = db.collection('measurements').find({"_id" => {'$gt' => Integer(ut)}}).limit(3001)

    json = []
    data.each {
        |record| json << {"time" => record["_id"], "weight" => record["weight"]}
    }

    content_type :json
    json.to_json

end

get '/api/last/:elements' do |e|
    # Currently not working properly, database needs to be setup to have time as index
    connection = Mongo::Connection.from_uri(mongodb)
    db = connection.db(database)
    puts e
    data = db.collection('measurements').find().sort({_id:-1}).limit(Integer(e))

    json = []
    data.each {
        |record| json << {"time" => record["_id"], "weight" => record["weight"]}
    }

    content_type :json
    json.to_json
end

get '/' do 
    erb :home    
end
