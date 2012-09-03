require 'sinatra'
require 'mongo'
require 'json'
require 'erb'

mongodb  = 'mongodb://localhost:27017'
database = 'coffeeW8'

get '/api/:elements' do |e|
    connection = Mongo::Connection.from_uri(mongodb)
    db = connection.db(database)
    puts e
    data = db.collection('m').find().limit(Integer(e))

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
