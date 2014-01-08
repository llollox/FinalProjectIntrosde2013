task :fetch_quotes => :environment do
  require 'nokogiri'
  require 'open-uri'

	puts "Delete all quotes"
	Quote.all.each do |q| q.destroy end

	30.times do |page|
		URL = "http://www.quotesdaddy.com/find/quote/Motivation/" + (page + 1).to_s
		puts "GET = #{URL}"
	 	doc = Nokogiri::HTML(open(URL))
	 	quotes = doc.css(".quoteText")
	 	
	 	quotes.each do |quote|
	 		if quote.text.size < 250 # per evitare poemi
	 			q = Quote.new
	 			q.content = quote.text
	 			q.save
	 			puts "QUOTE: #{q.content}" 
	 		end
	 	end

 	end

 	Quote.all.each do |q| puts q.content end
end