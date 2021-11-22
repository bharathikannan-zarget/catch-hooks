## CATCH HOOKS

It is a simple catch hook service. 

Pre-Requisite:

* MySQL

*Create schema
______________

`mysql -uroot < src/main/resources/schema.sql`



In the first release, it supports JSON hooks. For example, to receive shopify related events you can start ngrok

ngrok http 9000 -subdomain=<developer-name>-shopify-events  

Example:

ngrok http 9000 -subdomain=bk-shopify-events 


Now, you can register the ngrok endpoint to Shopify to receive events. 



To view requests:
______________


/view/<url>

example:

http://localhost:9000/view/shopify 

