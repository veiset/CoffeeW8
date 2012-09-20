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
    data = db.collection('measurements').find({"time" => {'$gt' => Integer(ut)}}).sort({"time" => -1}).limit(300)

    json = []
    data.each {
        |record| json << {"time" => record["time"], "weight" => record["weight"]}
    }

    content_type :json
    json.to_json

end

get '/api/last/:elements' do |e|
    # Currently not working properly, database needs to be setup to have time as index
    connection = Mongo::Connection.from_uri(mongodb)
    db = connection.db(database)
    puts e
    data = db.collection('measurements').find().limit(Integer(e))

    json = []
    data.each {
        |record| json << {"time" => record["time"], "weight" => record["weight"]}
    }

    content_type :json
    json.to_json
end

get '/' do 
    erb :home    
end
