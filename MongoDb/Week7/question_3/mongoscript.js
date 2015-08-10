use enron;
var filterMessageId = "<8147308.1075851042335.JavaMail.evans@thyme>";
var newEmailTo = 'mrpotatohead@10gen.com';

print("BEFORE UPDATE");
db.messages.findOne( 
	{'headers.Message-ID' : filterMessageId }, 
	{ _id: true, 'headers.Message-ID' : true, 'headers.To' :true } 
);
db.messages.update(
	{'headers.Message-ID' : filterMessageId } , 
	{$addToSet : {'headers.To' : newEmailTo } } 
);
print("AFTER UPDATE");
db.messages.findOne( 
	{'headers.Message-ID' : filterMessageId }, 
	{ _id: true, 'headers.Message-ID' : true, 'headers.To' :true } 
);