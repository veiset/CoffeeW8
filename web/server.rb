require 'sinatra'
require 'erubis'
require 'mongo'
require 'json'
require 'erb'


def is_num(argv)
    Integer(argv)
rescue ArgumentError
    false
else
    true
end

mongodb  = 'mongodb://localhost:27017'
database = 'coffeeW8'

connection = Mongo::Connection.from_uri(mongodb)
db = connection.db(database)

set :db, db
set :erubis, :escape_html => true

get '/' do 
    erb :home    
end

get '/api/since/:unixtime/?' do |ut|
    if is_num(ut)
        content_type :json
        get_data_since(Integer(ut)).to_json
    end
end

get '/api/last/:elements/?' do |elements|
    if is_num(elements)
        content_type :json
        get_last(Integer(elements)).to_json
    end
end

get '/api/last/:elements/measurements' do |elements|
    if is_num(elements)
        content_type :json
        get_last(Integer(elements)).to_json
    end
end

get '/api/last/:secs/seconds' do |secs|
    if is_num(secs)
        now = Time.now.to_i * 1000
        ticks = Integer(secs) * 1000
        
        content_type :json
        get_data_since(now - ticks).to_json
    end
end

get '/api/last/:secs/minutes' do |secs|
    if is_num(secs)
        now = Time.now.to_i * 1000
        ticks = Integer(secs) * 1000 * 60
        
        content_type :json
        get_data_since(now - ticks).to_json
    end
end

get '/api/last/:secs/hours' do |secs|
    if is_num(secs)
        now = Time.now.to_i * 1000
        ticks = Integer(secs) * 1000 * 60 * 60
        
        content_type :json
        get_data_since(now - ticks).to_json
    end
end
get '/api/last/:secs/days' do |secs|
    if is_num(secs)
        now = Time.now.to_i * 1000
        ticks = Integer(secs) * 1000 * 60 * 60 * 24
        
        content_type :json
        get_data_since(now - ticks).to_json
    end
end

def get_last(elements)
    data = settings.db.collection('measurements').find().sort({_id:-1}).limit(elements)

    json = []
    data.each {
        |record| json << {"time" => record["_id"], "weight" => record["weight"]}
    }

    return json
end

def get_data_since(ut)
        data = settings.db.collection('measurements').find({
            "_id" => { '$gt' => Integer(ut) }
        }).limit(300000)

        json = []
        data.each {
            |record| json << {"time" => record["_id"], "weight" => record["weight"]}
        }

    return json
end
