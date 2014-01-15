task :destroy_quotes => :environment do
	Quote.all.each do |q| 
		if q.content.size > 100
			q.destroy
		end
	end
end