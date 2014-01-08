## Inspirational Quotes Service

This is a simple REST Service written in Ruby On Rails and Deployed on Heroku that provides some Motivational Quotes as a JSON.

### Get a Motivational Quote

<b>GET REQUEST</b> to: http://inspirationalquotes.herokuapp.com/random_quote

You will get something like the json below:

```json
{ 
"content": "\n“True leadership lies in proving that the people at top can lead-by-example to motivate and inspire their team relentlessly.”\n",
"created_at": "2013-12-24T11:19:51Z",
"id": 597,
"updated_at": "2013-12-24T11:19:51Z"
}
```

### Motivational Quotes Source
Quotes are fetched from [This WebSite](http://www.quotesdaddy.com/find/quote/Motivation/) scraping the HTML and building a simple Quotes Database.